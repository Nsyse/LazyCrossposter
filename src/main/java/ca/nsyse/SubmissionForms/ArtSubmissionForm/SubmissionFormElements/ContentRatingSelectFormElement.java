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

    private JRadioButton generalOption;
    private JRadioButton teenOption;
    private JRadioButton matureOption;
    private JRadioButton adultOption;

    public ContentRatingSelectFormElement(FormFrame listeningFrame) {
        super(listeningFrame);

        this.indicatorLabel = new JLabel("Content rating");
        indicatorLabel.setOpaque(true);
        this.add(indicatorLabel);

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        generalOption = new JRadioButton("G");
        generalOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateContentRatingIndicator();
            }
        });
        teenOption = new JRadioButton("T");
        teenOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateContentRatingIndicator();
            }
        });
        matureOption = new JRadioButton("M");
        matureOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateContentRatingIndicator();
            }
        });
        adultOption = new JRadioButton("A");
        adultOption.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateContentRatingIndicator();
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

    private void updateContentRatingIndicator(){
        String indicatorText = "";
        Color indicatorColor = new Color(255,255,255);
        if(generalOption.isSelected()){
            indicatorColor = new Color(37, 174, 64);
            indicatorText = "General";
        }
        else if(teenOption.isSelected()) {
            indicatorColor = new Color(201, 205, 58);
            indicatorText = "Teen (13+)";
        }
        else if(matureOption.isSelected()) {
            indicatorColor = new Color(218, 128, 43);
            indicatorText = "Mature";
        }
        else if(adultOption.isSelected()) {
            indicatorColor = new Color(174, 54, 57);
            indicatorText = "Adult";
        }
        indicatorLabel.setBackground(indicatorColor);
        indicatorLabel.setText(indicatorText);
        requestUIUpdate();
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
