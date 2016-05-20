package SubmissionForms.ArtSubmissionForm.SubmissionFormElements;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by Nsyse on 2016-03-29.
 */
public class WebsiteSelector extends JPanel {

    private String websiteName;
    private JLabel websiteLabel;
    private JCheckBox checkBox;

    public WebsiteSelector(String websiteName){
        //Prepare label
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.websiteName=websiteName;
        websiteLabel = new JLabel(websiteName);
        websiteLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Add label
        this.add(websiteLabel);
        //Prepare Checkbox
        checkBox = new JCheckBox();
        checkBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkBox.setSelected(true);
        //Add checkbox
        this.add(checkBox);
        this.setBorder(new EmptyBorder(0,15,0,15));
    }

    public boolean getIsSelected(){
        return this.checkBox.isSelected();
    }

    public String getWebsiteName() {
        return websiteName;
    }
}
