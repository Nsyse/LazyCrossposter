package ca.nsyse.Generators.ArtPostGenerators;

import ca.nsyse.PathChooser;
import ca.nsyse.SeleniumTestSuiteGenerator;
import ca.nsyse.SubmissionForms.ArtSubmissionForm.ArtSubmissionFormModel;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Nsyse on 2016-03-27.
 */
public class SeleniumArtTestSuiteGenerator extends SeleniumTestSuiteGenerator {

    private String submissionName;

    public SeleniumArtTestSuiteGenerator(ArtSubmissionFormModel form) {
        super();
        String submissionPath = form.getSubmissionPath();
        String submissionTitle = form.getSubmissionTitle();
        this.submissionName = submissionTitle;
        String submissionDescription = form.getSubmissionDescription();
        ArrayList<String> tagsList = form.getSubmissionTags();
        ArrayList<String> websitesNames = form.getWebsitesNamesChosen();
        String contentRating = form.getContentRating();
        seleniumGenerators = new ArrayList<>();
        seleniumGenerators.add(new DAArtGenerator(submissionPath, submissionTitle, submissionDescription, tagsList, contentRating));
        seleniumGenerators.add(new FAArtGenerator(submissionPath, submissionTitle, submissionDescription, tagsList, contentRating));
        seleniumGenerators.add(new WeasylArtGenerator(submissionPath, submissionTitle, submissionDescription, tagsList, contentRating));
        seleniumGenerators.add(new SFArtGenerator(submissionPath, submissionTitle, submissionDescription, tagsList, contentRating));
        seleniumGenerators.add(new FurifficArtGenerator(submissionPath, submissionTitle, submissionDescription, tagsList, contentRating));
        seleniumGenerators.add(new IBArtGenerator(submissionPath, submissionTitle, submissionDescription, tagsList, contentRating));
        generateSuiteFile(websitesNames);
        generateSeleniumScripts(websitesNames);
    }

    private void generateSuiteFile(ArrayList<String> websitesNames) {
        BufferedWriter outStream = null;

        try {
            outStream = new BufferedWriter(new FileWriter( PathChooser.getLazyScriptsPath()+ "upload " + submissionName + " suite"));
            outStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            outStream.newLine();
            outStream.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
            outStream.newLine();
            outStream.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">");
            outStream.newLine();
            outStream.write("<head>");
            outStream.newLine();
            outStream.write("  <meta content=\"text/html; charset=UTF-8\" http-equiv=\"content-type\" />");
            outStream.newLine();
            outStream.write("  <title>Test Suite</title>");
            outStream.newLine();
            outStream.write("</head>");
            outStream.newLine();
            outStream.write("<body>");
            outStream.newLine();
            outStream.write("<table id=\"suiteTable\" cellpadding=\"1\" cellspacing=\"1\" border=\"1\" class=\"selenium\"><tbody>");
            outStream.newLine();
            outStream.write("<tr><td><b>Test Suite</b></td></tr>");
            outStream.newLine();
            for (String websiteName : websitesNames) {
                outStream.write("<tr><td><a href=\""+websiteName+" upload "+ submissionName+"_ready_test.html\">" + websiteName + " upload " + submissionName+" ready test</a></td></tr>");
                outStream.newLine();
            }
            outStream.write("</tbody></table>");
            outStream.newLine();
            outStream.write("</body>");
            outStream.newLine();
            outStream.write("</html>");
            outStream.newLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(null, "I did not manage to create the scripts!\n", "FUCKK", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            try {
                outStream.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
