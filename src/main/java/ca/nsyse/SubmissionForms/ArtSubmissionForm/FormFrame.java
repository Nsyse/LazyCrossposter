package ca.nsyse.SubmissionForms.ArtSubmissionForm;

import ca.nsyse.SubmissionForms.ArtSubmissionForm.SubmissionFormElements.SubmissionFormElement;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Nsyse on 2016-03-29.
 */
public abstract class FormFrame extends JFrame {

    private boolean readyForUpload = false;
    protected ArrayList<SubmissionFormElement> formElements = new ArrayList<>();;

    public FormFrame(){
    }
    /**
     *
     * @return If all fields are validated
     */
    protected abstract void submitForm();
    protected final boolean validateFormElements() {

        ArrayList<String> errorMessages = new ArrayList<>();

        for (int i = 0; i < formElements.size(); i++) {
            SubmissionFormElement element = formElements.get(i);
            String errorMessage = element.validateFields();
            if (errorMessage.length()>0){
                errorMessages.add(errorMessage);
            }
        }

        return showErrorsIfAny(errorMessages);
    }
    private boolean showErrorsIfAny(ArrayList<String> errorMessages){
        String completeErrror = "";
        for (String errorMessage : errorMessages){
            if (errorMessage.length()>0){
                if (completeErrror.length()==0){
                    completeErrror = "Error:";
                }
                completeErrror = completeErrror + "\n" + errorMessage;
            }
        }
        boolean thereWasNoError = true;
        if (completeErrror.length()>0){
            thereWasNoError=false;
            showSubmitErrorMessage(completeErrror);
        }
        return thereWasNoError;
    }

    private void showSubmitErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this, errorMessage, "Can't submit form!", JOptionPane.ERROR_MESSAGE);
    }

    public void updateUI(){
        this.pack();
        this.setResizable(false);
    }

    public void addFormElement(SubmissionFormElement element) {
        element.setAlignmentX(Component.CENTER_ALIGNMENT);
        formElements.add(element);
        this.add(element);
    }

    public boolean isReadyForUpload() {
        return readyForUpload;
    }
    public void setReadyForUpload(boolean readyForUpload) {
        this.readyForUpload = readyForUpload;
    }
}
