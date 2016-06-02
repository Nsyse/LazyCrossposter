package ca.nsyse.SubmissionForms.ArtSubmissionForm.SubmissionFormElements;

import ca.nsyse.PreferencesFriend;
import ca.nsyse.SubmissionForms.ArtSubmissionForm.ArtFormFillerFrame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nsyse on 2016-03-27.
 */
public class PathSubmissionFormElement extends SubmissionFormElement {
    private String defaultPathFieldText = "<- Select Image Path";
    private JLabel selectFileLabel;
    private JButton selectFileButton;

    public String getFilePath() {
        return filePath;
    }

    private String filePath;

    public PathSubmissionFormElement(ArtFormFillerFrame listeningFrame){
        super(listeningFrame);

        JPanel selectFilePathPanel =  new JPanel();
        selectFilePathPanel.setLayout(new BoxLayout(selectFilePathPanel, BoxLayout.X_AXIS));

        selectFileButton = new JButton("Select File...");
        selectFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectFilePath();
            }
        });
        selectFilePathPanel.add(selectFileButton);

        selectFileLabel = new JLabel(defaultPathFieldText);
        selectFilePathPanel.add(selectFileLabel);

        this.add(selectFilePathPanel);
    }

    public String selectFilePath(){
        String rememberedDir = PreferencesFriend.getString(PreferencesFriend.PREF_KEY.IMAGE_DEFAULT_DIR, null);
        JFileChooser fileChooser;
        if (rememberedDir != null)
            fileChooser = new JFileChooser(rememberedDir);
        else
            //they'll figure it out
            fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("png Images", "png");
        fileChooser.setFileFilter(filter);
        int returnVal = fileChooser.showOpenDialog(null);
        String path = "";
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            path = fileChooser.getSelectedFile().getPath();
            PreferencesFriend.set(PreferencesFriend.PREF_KEY.IMAGE_DEFAULT_DIR,
                    fileChooser.getSelectedFile().getParentFile().getPath());
            filePath=path;
            selectFileLabel.setText(path);
            selectFileButton.setText("Change selected file...");
            this.requestUIUpdate();
        }
        return path;
    }

    @Override
    public String validateFields() {
        String errorMessage = "";
        if(selectFileLabel.getText().equals(defaultPathFieldText)){
            errorMessage = "- Please select a file to upload!";
        }
        return errorMessage;
    }
}