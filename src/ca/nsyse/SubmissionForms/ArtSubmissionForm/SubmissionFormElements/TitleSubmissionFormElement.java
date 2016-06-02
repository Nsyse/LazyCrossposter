package ca.nsyse.SubmissionForms.ArtSubmissionForm.SubmissionFormElements;

import ca.nsyse.SubmissionForms.ArtSubmissionForm.FormFrame;
import ca.nsyse.SubmissionForms.ArtSubmissionForm.SelectAllTextOnClickMouseAdapter;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nsyse on 2016-03-27.
 */
public class TitleSubmissionFormElement extends SubmissionFormElement {

    private String submissionTitle;
    private JTextField titleField;

    private String defaultTitleFieldText = "<Enter title here>";

    public TitleSubmissionFormElement(FormFrame listeningFrame){
        super(listeningFrame);
        JLabel titleLabel = new JLabel("Submission title");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.titleField = new JTextField(defaultTitleFieldText, 25);
        titleField.setHorizontalAlignment(JTextField.CENTER);
        titleField.setMaximumSize(titleField.getPreferredSize());
        titleField.addMouseListener(new SelectAllTextOnClickMouseAdapter(titleField));

        this.add(titleLabel);
        this.add(titleField);
    }
    public String validateFields() {
        String invalidFieldAnswer ="";
        String readValue = titleField.getText();
        if (defaultTitleFieldText.equals(readValue)||readValue.length()==0){
            invalidFieldAnswer = "- You need to change the title field first!";
        }
        else{
            submissionTitle = readValue;
        }
        return invalidFieldAnswer;
    }

    public String getSubmissionTitle() {
        return submissionTitle;
    }
}
