package ca.nsyse.SubmissionForms.ArtSubmissionForm.SubmissionFormElements;

import ca.nsyse.SubmissionForms.ArtSubmissionForm.CustomTextInputUtil;

import javax.swing.*;

/**
 * Created by Nsyse on 2016-08-26.
 */
public class SelectableJTextArea extends JTextArea implements CustomTextInputUtil{

    private String defaultText;

    public SelectableJTextArea(String defaultText){
        super(defaultText);
        this.defaultText = defaultText;
    }

    public boolean isUnmodified() {
        return this.getText().equals(defaultText);
    }

    @Override
    public void selectAllText() {
        this.selectAll();
    }
}
