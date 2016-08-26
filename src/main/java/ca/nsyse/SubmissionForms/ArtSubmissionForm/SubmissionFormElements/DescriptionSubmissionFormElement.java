package ca.nsyse.SubmissionForms.ArtSubmissionForm.SubmissionFormElements;

import ca.nsyse.SubmissionForms.ArtSubmissionForm.FormFrame;
import ca.nsyse.SubmissionForms.ArtSubmissionForm.SelectAllTextOnClickMouseAdapter;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;

/**
 * Created by Nsyse on 2016-03-27.
 */
public class DescriptionSubmissionFormElement extends SubmissionFormElement {
    public String getSubmissionDescription() {
        return submissionDescription;
    }

    private String submissionDescription;
    private SelectableJTextArea descriptionField;
    private Document areaDocument;

    private String defaultDescriptionFieldText = "<Enter description here>";

    public DescriptionSubmissionFormElement(FormFrame listeningFrame){
        super(listeningFrame);
        JLabel titleLabel = new JLabel("Submission description");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.descriptionField = new SelectableJTextArea(defaultDescriptionFieldText);
        descriptionField.setMaximumSize(descriptionField.getPreferredSize());
        descriptionField.addMouseListener(new SelectAllTextOnClickMouseAdapter(descriptionField));
        descriptionField.setRows(15);
        JScrollPane descScrollPane = new JScrollPane(descriptionField);

        areaDocument = descriptionField.getDocument();
        areaDocument.addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateDescriptionFieldSize();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateDescriptionFieldSize();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateDescriptionFieldSize();
            }
        });

        this.add(titleLabel);
        this.add(descScrollPane);
    }

    public void updateDescriptionFieldSize(){
        this.requestUIUpdate();
    }

    public String validateFields() {
        String invalidFieldAnswer ="";
        String readValue = descriptionField.getText();
        if (defaultDescriptionFieldText.equals(readValue) || readValue.length()==0){
            invalidFieldAnswer = "- You need to change the description field first!";
        }
        else{
            submissionDescription = readValue;
        }
        return invalidFieldAnswer;
    }
}
