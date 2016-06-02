package ca.nsyse.SubmissionForms.ArtSubmissionForm.SubmissionFormElements;

import ca.nsyse.SubmissionForms.ArtSubmissionForm.ArtFormFillerFrame;
import ca.nsyse.SubmissionForms.ArtSubmissionForm.SelectAllTextOnClickMouseAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nsyse on 2016-03-27.
 */
public class TagsSubmissionFormElement extends SubmissionFormElement {

    private ArrayList<JTextField> tagsFields = new ArrayList<>();
    private JPanel tagFieldsPanel = new JPanel();
    private String defaultTagFieldText = "<Enter tag here>";

    public TagsSubmissionFormElement(ArtFormFillerFrame listeningFrame) {
        super(listeningFrame);
        //Prepare title
        JLabel titleLabel = new JLabel("Submission tags");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Add title
        this.add(titleLabel);

        //Prepare tag fields Panel
        tagFieldsPanel.setLayout(new BoxLayout(tagFieldsPanel, BoxLayout.Y_AXIS));
        //Add panel
        this.add(tagFieldsPanel);

        //Prepare add/remove tag panel
        JPanel addRemoveTagsPanel = new JPanel();
        addRemoveTagsPanel.setLayout(new BoxLayout(addRemoveTagsPanel, BoxLayout.X_AXIS));
        JButton addTagFieldButton = new JButton("Add new tag entry");
        addTagFieldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTagField();
            }
        });
        addRemoveTagsPanel.add(addTagFieldButton);
        JButton removeTagFieldButton = new JButton("Remove last tag entry");
        removeTagFieldButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeTagField();
            }
        });
        addRemoveTagsPanel.add(removeTagFieldButton);
        //Add add/remove tag panel
        this.add(addRemoveTagsPanel);
    }

    public void addTagField(){
        JTextField newTagField = new JTextField(defaultTagFieldText);
        newTagField.addMouseListener(new SelectAllTextOnClickMouseAdapter(newTagField));
        newTagField.setHorizontalAlignment(JTextField.CENTER);
        tagsFields.add(newTagField);
        tagFieldsPanel.add(newTagField);
        this.requestUIUpdate();
    }

    public void removeTagField(){
        if (!tagsFields.isEmpty()){
            tagFieldsPanel.remove(tagsFields.remove(tagsFields.size()-1));
        }
        this.requestUIUpdate();
    }

    public ArrayList<String> getAllTags(){
        ArrayList<String> tags = new ArrayList<>();
        for (JTextField tagField: tagsFields){
            tags.add(tagField.getText());
        }
        return tags;
    }

    @Override
    public String validateFields() {
        String errorMessage ="";
        if(tagsFields.size()==0){
            errorMessage ="- At least one tag is needed!";
        }
        else{
            boolean invalidTagFound = false;
            for (int i=0; i<tagsFields.size() && !invalidTagFound; i++){
                JTextField testedField = tagsFields.get(i);
                if (defaultTagFieldText.equals(testedField.getText())|| testedField.getText().length()==0){
                    invalidTagFound = true;
                }
            }
            if (invalidTagFound){
                errorMessage="- At least one non-initialized tag was found!";
            }
            else{
                ArrayList<String> tags = getAllTags();
                Set<String> tagsSet = new HashSet<String>(tags);
                if (tagsSet.size() < tagsFields.size()){
                    errorMessage="- Duplicate tags were found!";
                }
            }
        }
        return errorMessage;
    }
}
