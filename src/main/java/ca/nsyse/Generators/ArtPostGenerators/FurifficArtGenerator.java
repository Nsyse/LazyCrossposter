package ca.nsyse.Generators.ArtPostGenerators;

import ca.nsyse.PathChooser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Nsyse on 2016-03-26.
 */
public final class FurifficArtGenerator extends AbstractArtSeleniumOverwriter {
    public FurifficArtGenerator(String submissionPath, String submissionTitle, String submissionDescription, ArrayList<String> tagsList, String contentRating) {
        super("Furiffic", submissionPath, submissionTitle, submissionDescription, tagsList, contentRating);
    }

    @Override
    public void overwriteSeleniumTest() {
        BufferedWriter outStream = null;
        try {
            outStream = new BufferedWriter(new FileWriter(
                    PathChooser.getLazyScriptsPath() + File.separator + this.getWebsiteName()
                            + " upload " + this.getSubmissionTitle() + "_ready_test.html"));
            outStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            outStream.newLine();
            outStream.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
            outStream.newLine();
            outStream.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">");
            outStream.newLine();
            outStream.write("<head profile=\"http://selenium-ide.openqa.org/profiles/test-case\">");
            outStream.newLine();
            outStream.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
            outStream.newLine();
            outStream.write("<link rel=\"selenium.base\" href=\"https://www.furiffic.com/\" />");
            outStream.newLine();
            outStream.write("<title>Furrific test</title>");
            outStream.newLine();
            outStream.write("</head>");
            outStream.newLine();
            outStream.write("<body>");
            outStream.newLine();
            outStream.write("<table cellpadding=\"1\" cellspacing=\"1\" border=\"1\">");
            outStream.newLine();
            outStream.write("<thead>");
            outStream.newLine();
            outStream.write("<tr><td rowspan=\"1\" colspan=\"3\">Furrific test</td></tr>");
            outStream.newLine();
            outStream.write("</thead><tbody>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>openWindow</td>");
            outStream.newLine();
            outStream.write("	<td>/</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>waitForPopUp</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("	<td>5000</td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>selectWindow</td>");
            outStream.newLine();
            outStream.write("	<td>title=Welcome to Furiffic</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>clickAndWait</td>");
            outStream.newLine();
            outStream.write("	<td>link=Upload Submission</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>click</td>");
            outStream.newLine();
            outStream.write("	<td>css=input.uploader</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>type</td>");
            outStream.newLine();
            outStream.write("	<td>css=input.uploader</td>");
            outStream.newLine();
            outStream.write("	<td>"+getSubmissionPath()+"</td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>click</td>");
            outStream.newLine();
            outStream.write("	<td>//body/div/div/div[2]/div</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>waitForVisible</td>");
            outStream.newLine();
            outStream.write("	<td>id=editName</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>type</td>");
            outStream.newLine();
            outStream.write("	<td>id=editName</td>");
            outStream.newLine();
            outStream.write("	<td>"+getSubmissionTitle()+"</td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>click</td>");
            outStream.newLine();
            outStream.write("	<td>id=editDescription</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>pause</td>");
            outStream.newLine();
            outStream.write("	<td>1000</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>runScript</td>");
            outStream.newLine();
            outStream.write("	<td>tinyMCE.get('tinymce_1').setContent('"+getSubmissionDescription()+"') </td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>click</td>");
            outStream.newLine();
            String contentRating = getContentRating();
            if (contentRating.equals("M")){
                outStream.write("	<td>css=li[value=&quot;mature&quot;]</td>");
            }
            else if (contentRating.equals("A")){
                outStream.write("	<td>css=li[value=&quot;adult&quot;]</td>");
            }
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
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
