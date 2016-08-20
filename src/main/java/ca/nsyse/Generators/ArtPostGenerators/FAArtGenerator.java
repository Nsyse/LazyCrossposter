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
public class FAArtGenerator extends AbstractArtSeleniumOverwriter {
    public FAArtGenerator(String submissionPath, String submissionTitle, String submissionDescription, ArrayList<String> tagsList, String contentRating) {
        super("Furaffinity", submissionPath, submissionTitle, submissionDescription, tagsList, contentRating);
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
            outStream.write("<link rel=\"selenium.base\" href=\"http://www.furaffinity.net/\" />");
            outStream.newLine();
            outStream.write("<title>FA upload ready test</title>");
            outStream.newLine();
            outStream.write("</head>");
            outStream.newLine();
            outStream.write("<body>");
            outStream.newLine();
            outStream.write("<table cellpadding=\"1\" cellspacing=\"1\" border=\"1\">");
            outStream.newLine();
            outStream.write("<thead>");
            outStream.newLine();
            outStream.write("<tr><td rowspan=\"1\" colspan=\"3\">FA upload ready test</td></tr>");
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
            outStream.write("	<td>title=Index -- Fur Affinity [dot] net</td>");
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
            outStream.write("	<td>css=input.button</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>type</td>");
            outStream.newLine();
            outStream.write("	<td>name=submission</td>");
            outStream.newLine();
            outStream.write("	<td>"+getSubmissionPath()+"</td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>clickAndWait</td>");
            outStream.newLine();
            outStream.write("	<td>css=input.button</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>type</td>");
            outStream.newLine();
            outStream.write("	<td>name=title</td>");
            outStream.newLine();
            outStream.write("	<td>"+ getEscapedTitleTitle()+"</td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>type</td>");
            outStream.newLine();
            outStream.write("	<td>id=JSMessage</td>");
            outStream.newLine();
            outStream.write("	<td>"+getSubmissionDescription()+"</td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>type</td>");
            outStream.newLine();
            outStream.write("	<td>id=keywords</td>");
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
            Hardcoded preferences
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>select</td>");
            outStream.newLine();
            outStream.write("	<td>name=cat</td>");
            outStream.newLine();
            outStream.write("	<td>label=Artwork (Digital)</td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>select</td>");
            outStream.newLine();
            outStream.write("	<td>name=atype</td>");
            outStream.newLine();
            outStream.write("	<td>label=Portraits</td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            */
            outStream.write("	<td>click</td>");
            outStream.newLine();
            outStream.write("	<td>id=rating-type-general</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>click</td>");
            outStream.newLine();

            String contentRating = getContentRating();
            if (contentRating.equals("G")||contentRating.equals("T")){
                outStream.write("	<td>id=rating-type-general</td>");
            }
            else if(contentRating.equals("M")){
                outStream.write("	<td>id=id=rating-type-mature</td>");
            }
            else if(contentRating.equals("A")){
                outStream.write("	<td>id=rating-type-adult</td>");
            }

            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
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
