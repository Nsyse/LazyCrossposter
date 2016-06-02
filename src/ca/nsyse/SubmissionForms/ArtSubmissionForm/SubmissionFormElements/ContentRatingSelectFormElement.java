package ca.nsyse.SubmissionForms.ArtSubmissionForm.SubmissionFormElements;

import ca.nsyse.SubmissionForms.ArtSubmissionForm.FormFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

/**
 * Created by Nsyse on 2016-03-29.
 */
public class ContentRatingSelectFormElement extends SubmissionFormElement {

    JLabel indicatorLabel;
    ButtonGroup contentRatingOptions;

    public ContentRatingSelectFormElement(FormFrame listeningFrame) {
        super(listeningFrame);

        this.indicatorLabel = new JLabel("Content rating");
        indicatorLabel.setOpaque(true);
        this.add(indicatorLabel);

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        JRadioButton generalOption = new JRadioButton("G");
        generalOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(generalOption.isSelected()){
                    indicatorLabel.setBackground(new Color(37, 174, 64));
                    indicatorLabel.setText("General");
                    requestUIUpdate();
                }
            }
        });
        JRadioButton teenOption = new JRadioButton("T");
        teenOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(teenOption.isSelected()) {
                    indicatorLabel.setBackground(new Color(201, 205, 58));
                    indicatorLabel.setText("Teen (13+)");
                    requestUIUpdate();
                }
            }
        });
        JRadioButton matureOption = new JRadioButton("M");
        matureOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(matureOption.isSelected()) {
                    indicatorLabel.setBackground(new Color(218, 128, 43));
                    indicatorLabel.setText("Mature");
                    requestUIUpdate();
                }
            }
        });
        JRadioButton adultOption = new JRadioButton("A");
        adultOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(adultOption.isSelected()) {
                    indicatorLabel.setBackground(new Color(174, 54, 57));
                    indicatorLabel.setText("Adult");
                    requestUIUpdate();
                }
            }
        });

        this.contentRatingOptions = new ButtonGroup();

        contentRatingOptions.add(generalOption);
        contentRatingOptions.add(teenOption);
        contentRatingOptions.add(matureOption);
        contentRatingOptions.add(adultOption);

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(generalOption);
        this.add(teenOption);
        this.add(matureOption);
        this.add(adultOption);
    }

    @Override
    public String validateFields() {
        System.out.println("validating content rating");
        String selectedContentRating = getSelectedContentRating();
        System.out.println("selection: " + selectedContentRating);
        String errorMessage ="";
        if (selectedContentRating.equals("")){
            errorMessage="- You must select a content rating first!";
        }
        return errorMessage;
    }

    public String getSelectedContentRating(){
        String answer = "";
            for (Enumeration<AbstractButton> buttons = contentRatingOptions.getElements(); buttons.hasMoreElements();) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    answer= button.getText();
                }
            }
        return answer;
    }
}
