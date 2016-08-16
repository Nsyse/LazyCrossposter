package ca.nsyse.Generators.JournalBlogPostGenerators;

import ca.nsyse.SeleniumTestSuiteGenerator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Nsyse on 2016-03-30.
 */
public class SeleniumJournalTestSuiteGenerator extends SeleniumTestSuiteGenerator {

    private String journalTitle;

    public SeleniumJournalTestSuiteGenerator(ca.nsyse.SubmissionForms.JournalSubmissionForm.JournalSubmissionFormModel journalSubmissionFormModel) {
        super();
        this.journalTitle = journalSubmissionFormModel.getSubmissionTitle();
        String journalDesc = journalSubmissionFormModel.getSubmissionDescription();
        ArrayList<String> websitesNames = journalSubmissionFormModel.getWebsitesNamesChosen();
        seleniumGenerators.add(new DAJournalGenerator(journalTitle, journalDesc));
        seleniumGenerators.add(new FuraffinityJournalGenerator(journalTitle, journalDesc));
        seleniumGenerators.add(new WeasylJournalGenerator(journalTitle, journalDesc));
        seleniumGenerators.add(new SFJournalGenerator(journalTitle, journalDesc));
        seleniumGenerators.add(new FurifficJournalGenerator(journalTitle, journalDesc));
        seleniumGenerators.add(new IBJournalGenerator(journalTitle, journalDesc));
        generateSuiteFile(websitesNames);
        generateSeleniumScripts(websitesNames);
    }

    private void generateSuiteFile(ArrayList<String> websitesNames) {
        BufferedWriter outStream = null;
        try {
            outStream = new BufferedWriter(new FileWriter("D:\\Users\\Nsyse\\Pictures\\Selenium upload script\\Upload all journals"));
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
                outStream.write("<tr><td><a href=\""+websiteName+"_journal_upload "+journalTitle+"_ready_test.html\">"+websiteName+"_journal_upload "+journalTitle+"_ready_test</a></td></tr>");
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
        } finally {
            try {
                outStream.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
