package ca.nsyse.SubmissionForms.JournalSubmissionForm;

import java.util.ArrayList;

/**
 * Created by Nsyse on 2016-03-27.
 */
public class JournalSubmissionFormModel {

    private String submissionTitle;
    private String submissionDescription;
    private ArrayList<String> websitesNamesChosen;

    public JournalSubmissionFormModel(){
        websitesNamesChosen = new ArrayList<>();
    }

    public String getSubmissionDescription() {
        return submissionDescription;
    }

    public void setSubmissionDescription(String submissionDescription) {
        this.submissionDescription = submissionDescription;
    }

    public String getSubmissionTitle() {
        return submissionTitle;
    }

    public void setSubmissionTitle(String submissionTitle) {
        this.submissionTitle = submissionTitle;
    }

    public void setWebsitesNamesChosen(ArrayList<String> websitesNamesChosen) {
        this.websitesNamesChosen = websitesNamesChosen;
    }

    public ArrayList<String> getWebsitesNamesChosen() {
        return websitesNamesChosen;
    }
}
