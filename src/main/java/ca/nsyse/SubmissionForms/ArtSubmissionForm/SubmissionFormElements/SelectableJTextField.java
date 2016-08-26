package ca.nsyse.SubmissionForms.ArtSubmissionForm.SubmissionFormElements;

import ca.nsyse.SubmissionForms.ArtSubmissionForm.CustomTextInputUtil;

import javax.swing.*;

/**
 * Created by Nsyse on 2016-08-26.
 */
public class SelectableJTextField extends JTextField implements CustomTextInputUtil{

    private final String defaultText;

    public SelectableJTextField(String defaultText){
        super(defaultText);
        this.defaultText = defaultText;
    }

    public SelectableJTextField(String defaultText, int numberColumns){
        super(defaultText, numberColumns);
        this.defaultText = defaultText;
    }

    @Override
    public boolean isUnmodified() {
        return this.defaultText.equals(super.getText());
    }

    @Override
    public void selectAllText() {
        super.selectAll();
    }
}
