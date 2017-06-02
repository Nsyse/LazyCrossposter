package ca.nsyse;

import javax.swing.*;
import java.io.File;

/**
 * Created by Nsyse on 2016-05-19.
 */
public class PathChooser {

    private PathChooser(){}

    //TODO: Make this work for other peeps!
    public static String getLazyGenerateCodePath(){
        checkIfFolderExistAndCreateIfNot("Selenium upload script\\Generators");
        return "Selenium upload script\\Generators\\";
    }

    private static void checkIfFolderExistAndCreateIfNot(String path){
        if (! new File(path).exists()) {
            //Try to create a directory
            boolean success = (new File(path)).mkdirs();
            if (!success) {
                JOptionPane.showMessageDialog(null, "I did not manage to create the Folder to put scripts in!\n", "FUCK!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public static String getLazyScriptsPath(){
        checkIfFolderExistAndCreateIfNot("Selenium upload script");
        return "Selenium upload script\\";
    }
}
