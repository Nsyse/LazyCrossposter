package ca.nsyse.SubmissionForms.ArtSubmissionForm.SubmissionFormElements;

import ca.nsyse.SubmissionForms.ArtSubmissionForm.ArtFormFillerFrame;
import ca.nsyse.SubmissionForms.ArtSubmissionForm.SelectAllTextOnClickMouseAdapter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nsyse on 2016-03-27.
 */
public class TagsSubmissionFormElement extends SubmissionFormElement {

    private SelectableJTextField tagsField;
    private String defaultTagFieldText = "<Enter tags here>";

    public TagsSubmissionFormElement(ArtFormFillerFrame listeningFrame) {
        super(listeningFrame);
        //Prepare title
        JLabel titleLabel = new JLabel("Submission tags");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Add title
        this.add(titleLabel);

        //Prepare tag fields Panel
        tagsField = new SelectableJTextField(defaultTagFieldText);
        tagsField.addMouseListener(new SelectAllTextOnClickMouseAdapter(tagsField));
        this.add(tagsField);

    }

    public ArrayList<String> getAllTags(){
        String[] tags = tagsField.getText().split("[\\s,]+");
        ArrayList<String> rv = new ArrayList<>();
        Collections.addAll(rv, tags);
        return rv;
    }

    @Override
    public String validateFields() {
        String errorMessage ="";
        if (! tagsField.getText().equals(defaultTagFieldText)) {
            ArrayList<String> tags = getAllTags();
            Set<String> tagsSet = new HashSet<String>(tags);
            if (tags.size() <= 1) {
                errorMessage = "- At least two tags are needed!";
            }
            if (tagsSet.size() < tags.size()) {
                errorMessage = "- Duplicate tags were found!";
            }
        }
        else{
            errorMessage = "- You forgot to enter tags, dumdum!";
        }
        return errorMessage;
    }
}