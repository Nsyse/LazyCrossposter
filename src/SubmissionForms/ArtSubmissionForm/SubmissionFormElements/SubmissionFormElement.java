package SubmissionForms.ArtSubmissionForm.SubmissionFormElements;

import SubmissionForms.ArtSubmissionForm.ArtFormFillerFrame;
import SubmissionForms.ArtSubmissionForm.FormFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nsyse on 2016-03-27.
 */
public abstract class SubmissionFormElement extends JPanel {

    private FormFrame listeningFrame;

    public SubmissionFormElement(FormFrame listeningFrame){
        this.listeningFrame = listeningFrame;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public void requestUIUpdate(){
        listeningFrame.updateUI();
    }

    public abstract String validateFields();
}
