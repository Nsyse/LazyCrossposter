package ca.nsyse.SubmissionForms.ArtSubmissionForm.SubmissionFormElements;

import ca.nsyse.PreferencesFriend;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nsyse on 2016-03-29.
 */
public class WebsiteSelector extends JPanel implements ActionListener {

    private String websiteName;
    private String preferenceCode;
    private JLabel websiteLabel;
    private JCheckBox checkBox;

    public WebsiteSelector(String websiteName, String code){
        //Prepare label
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.websiteName=websiteName;
        preferenceCode = code;
        websiteLabel = new JLabel(websiteName);
        websiteLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Add label
        this.add(websiteLabel);
        //Prepare Checkbox
        checkBox = new JCheckBox();
        checkBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkBox.addActionListener(this);

        String prefconfig = PreferencesFriend.getString(PreferencesFriend.PREF_KEY.DEFAULT_UPLOAD_SITES,
                WebsitesSelectFormElement.defaultCodes);
        checkBox.setSelected(prefconfig.contains(preferenceCode));
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

    @Override
    public void actionPerformed(ActionEvent e) {
        String config = PreferencesFriend.getString(PreferencesFriend.PREF_KEY.DEFAULT_UPLOAD_SITES,
                WebsitesSelectFormElement.defaultCodes);
        if (!checkBox.isSelected()) {
            config = config.replace(preferenceCode, "");
        } else {
            config = config + preferenceCode;
        }
        PreferencesFriend.set(PreferencesFriend.PREF_KEY.DEFAULT_UPLOAD_SITES, config);
    }
}
