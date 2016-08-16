package ca.nsyse;

import javax.swing.*;

/**
 * Created by Nsyse on 2016-05-19.
 */
public class PathChooser {

    private PathChooser(){}

    //TODO: Make this work for other peeps!
    public static String getLazyGenerateCodePath(){
        return "D:\\Users\\Nsyse\\Pictures\\Selenium upload script\\Generators\\";
    }

    public static String getDefaultPath() {
        String remembered = PreferencesFriend.getString(PreferencesFriend.PREF_KEY.SELENIUM_SCRIPT_OUTPUT_DIR,
                null);
        if (remembered == null) {
            //launch picker
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int rv = fileChooser.showOpenDialog(null);
            if (rv == JFileChooser.APPROVE_OPTION) {
                String dir = fileChooser.getSelectedFile().toString();
                PreferencesFriend.set(PreferencesFriend.PREF_KEY.SELENIUM_SCRIPT_OUTPUT_DIR, dir);
                return dir;
            } else {
                //well if they don't want to pick then i'll dump em right on the ground
                return ".";
            }
        } else {
            return remembered;
        }
    }
}
