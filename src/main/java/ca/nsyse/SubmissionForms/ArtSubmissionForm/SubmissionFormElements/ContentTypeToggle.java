package ca.nsyse.SubmissionForms.ArtSubmissionForm.SubmissionFormElements;

import ca.nsyse.SubmissionForms.ArtSubmissionForm.FormFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

/**
 * Created by Nsyse on 2016-03-29.
 */
public class ContentTypeToggle extends SubmissionFormElement {
    
    ButtonGroup contentRatingOptions;

    JLabel descLabel;

    private JRadioButton traditionalButton;
    private JRadioButton digitalButton;
    private JRadioButton unspecifiedButton;

    public ContentTypeToggle(FormFrame listeningFrame) {
        super(listeningFrame);

        traditionalButton = new JRadioButton("Traditional");
        traditionalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateContentTypeIndicator();
            }
        });
        digitalButton = new JRadioButton("Digital");
        digitalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateContentTypeIndicator();
            }
        });
        unspecifiedButton = new JRadioButton("Unspecified");
        unspecifiedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateContentTypeIndicator();
            }
        });

        this.contentRatingOptions = new ButtonGroup();

        descLabel = new JLabel("Content type");
        this.add(descLabel);

        contentRatingOptions.add(traditionalButton);
        contentRatingOptions.add(digitalButton);
        contentRatingOptions.add(unspecifiedButton);

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(traditionalButton);
        this.add(digitalButton);
        this.add(unspecifiedButton);
    }

    private void updateContentTypeIndicator(){
        //TODO
    }

    @Override
    public String validateFields() {
        System.out.println("validating content type");
        String selectedContentRating = getSelectedContentRating();
        System.out.println("selection: " + selectedContentRating);
        String errorMessage ="";
        if (selectedContentRating.equals("")){
            //TODO: Activate warnings if asked for.
            //JOptionPane.showMessageDialog(null, "I did not manage to create the scripts!\n", "Just sayin.", JOptionPane.INFORMATION_MESSAGE);
        }
        //This is optional, will not throw error, but warnings
        return "";
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
