package ca.nsyse.Generators.ArtPostGenerators;

import ca.nsyse.PathChooser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Nsyse on 2016-03-27.
 */
public class WeasylArtGenerator extends AbstractArtSeleniumOverwriter {

    public WeasylArtGenerator(String submissionPath, String submissionTitle, String submissionDescription, ArrayList<String> tagsList, String contentRating, String thumbnailPath) {
        super("Weasyl", submissionPath, submissionTitle, submissionDescription, tagsList, contentRating, thumbnailPath);
    }

    @Override
    public void overwriteSeleniumTest() {
        BufferedWriter outStream = null;
        try {

            outStream = new BufferedWriter(new FileWriter(
                    PathChooser.getLazyScriptsPath() + File.separator + this.getWebsiteName()
                            + " upload_ready_test.html"));
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
            outStream.write("<link rel=\"selenium.base\" href=\"https://www.weasyl.com/\" />");
            outStream.newLine();
            outStream.write("<title>Weasyl upload ready test</title>");
            outStream.newLine();
            outStream.write("</head>");
            outStream.newLine();
            outStream.write("<body>");
            outStream.newLine();
            outStream.write("<table cellpadding=\"1\" cellspacing=\"1\" border=\"1\">");
            outStream.newLine();
            outStream.write("<thead>");
            outStream.newLine();
            outStream.write("<tr><td rowspan=\"1\" colspan=\"3\">Weasyl upload ready test</td></tr>");
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
            outStream.write("	<td>title=Home &#x2014; Weasyl</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>waitForVisible</td>");
            outStream.newLine();
            outStream.write("	<td>link=Submit</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>clickAndWait</td>");
            outStream.newLine();
            outStream.write("	<td>link=Submit</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>clickAndWait</td>");
            outStream.newLine();
            outStream.write("	<td>link=Visual</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>type</td>");
            outStream.newLine();
            outStream.write("	<td>id=submitfile</td>");
            outStream.newLine();
            outStream.write("	<td>"+getSubmissionPath()+"</td>");
            outStream.newLine();
            outStream.write("</tr>");

            if (!getThumbnailPath().isEmpty()){
                outStream.newLine();
                outStream.write("<tr>");
                outStream.newLine();
                outStream.write("	<td>type</td>");
                outStream.newLine();
                outStream.write("	<td>id=thumbfile</td>");
                outStream.newLine();
                outStream.write("	<td>"+getThumbnailPath()+"</td>");
                outStream.newLine();
                outStream.write("</tr>");
            }
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>type</td>");
            outStream.newLine();
            outStream.write("	<td>id=submissiontitle</td>");
            outStream.newLine();
            outStream.write("	<td>" + getEscapedTitleTitle() + "</td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            /* Preferences
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>select</td>");
            outStream.newLine();
            outStream.write("	<td>id=submissioncat</td>");
            outStream.newLine();
            outStream.write("	<td>label=Digital</td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>select</td>");
            outStream.newLine();
            outStream.write("	<td>id=submissionfolder</td>");
            outStream.newLine();
            outStream.write("	<td>label=Furfaggotry</td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>select</td>");
            outStream.newLine();
            outStream.write("	<td>id=submissionrating</td>");
            outStream.newLine();
            outStream.write("	<td>label=General</td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            */
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>type</td>");
            outStream.newLine();
            outStream.write("	<td>id=submissiondesc</td>");
            outStream.newLine();
            outStream.write("	<td>"+getSubmissionDescription()+"</td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>waitForVisible</td>");
            outStream.newLine();
            outStream.write("	<td>//form[@id='submit-form']/div[4]/ul/li/input</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>click</td>");
            outStream.newLine();
            outStream.write("	<td>//form[@id='submit-form']/div[4]/ul/li/input</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>type</td>");
            outStream.newLine();
            outStream.write("	<td>//form[@id='submit-form']/div[4]/ul/li/input</td>");
            outStream.newLine();
            outStream.write("	<td>");
            ArrayList<String> tags = getTagsList();
            for(int i=0; i<tags.size(); i++) {
                String currentTagText = tags.get(i);
                currentTagText = currentTagText.replace(" ", "_");
                outStream.write(currentTagText+" ");
            }
            outStream.write("</td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            /*
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>click</td>");
            outStream.newLine();
            outStream.write("	<td>name=customthumb</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            */
            String contentRating = this.getContentRating();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>select</td>");
            outStream.newLine();
            outStream.write("	<td>id=submissionrating</td>");
            outStream.newLine();
            if (contentRating.equals("G")){
                outStream.write("	<td>label=General</td>");
            }
            else if(contentRating.equals("T")){
                outStream.write("	<td>label=Moderate (13+)</td>");
            }
            else if(contentRating.equals("M")){
                outStream.write("	<td>label=Mature (18+ non-sexual)</td>");
            }
            else if(contentRating.equals("A")){
                outStream.write("	<td>label=Explicit (18+ sexual)</td>");
            }

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
