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
public final class DAArtGenerator extends AbstractArtSeleniumOverwriter {
    public DAArtGenerator(String submissionPath, String submissionTitle, String submissionDescription, ArrayList<String> tagsList, String contentRating){
        super("DeviantArt", submissionPath, submissionTitle, submissionDescription, tagsList,contentRating);
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
            outStream.write("<link rel=\"selenium.base\" href=\"http://www.deviantart.com/\" />");
            outStream.newLine();
            outStream.write("<title>DA upload ready test</title>");
            outStream.newLine();
            outStream.write("</head>");
            outStream.newLine();
            outStream.write("<body>");
            outStream.newLine();
            outStream.write("<table cellpadding=\"1\" cellspacing=\"1\" border=\"1\">");
            outStream.newLine();
            outStream.write("<thead>");
            outStream.newLine();
            outStream.write("<tr><td rowspan=\"1\" colspan=\"3\">DA upload ready test</td></tr>");
            outStream.newLine();
            outStream.write("</thead><tbody>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>openWindow</td>");
            outStream.newLine();
            outStream.write("	<td>/browse/all/</td>");
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
            outStream.write("	<td>title=Browse Art - DeviantArt</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>clickAndWait</td>");
            outStream.newLine();
            outStream.write("	<td>css=a.oh-l.oh-touch &gt; span</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>selectFrame</td>");
            outStream.newLine();
            outStream.write("	<td>deviation-0</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>type</td>");
            outStream.newLine();
            outStream.write("	<td>name=file</td>");
            outStream.newLine();
            outStream.write("	<td>"+getSubmissionPath()+"</td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>waitForVisible</td>");
            outStream.newLine();
            outStream.write("	<td>xpath=(//input[@name='ile-mature-input'])[2]</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>click</td>");
            outStream.newLine();
            outStream.write("	<td>xpath=(//input[@name='ile-mature-input'])[2]</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>click</td>");
            outStream.newLine();
            outStream.write("	<td>id=devtitle</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>type</td>");
            outStream.newLine();
            outStream.write("	<td>css= [id*=title]</td>");
            outStream.newLine();
            outStream.write("	<td>"+ getEscapedTitleTitle()+"</td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>click</td>");
            outStream.newLine();
            outStream.write("	<td>//form[@id='autocomplete-placebo']/div[2]/div/div/div/div</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>click</td>");
            outStream.newLine();
            outStream.write("	<td>css=span.placeholder</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>waitForVisible</td>");
            outStream.newLine();
            outStream.write("	<td>link=Anthro</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            //Hardcoded prefs
            /*
            outStream.write("	<td>click</td>");
            outStream.newLine();
            outStream.write("	<td>link=Anthro</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>waitForVisible</td>");
            outStream.newLine();
            outStream.write("	<td>link=Digital Media</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>click</td>");
            outStream.newLine();
            outStream.write("	<td>link=Digital Media</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>click</td>");
            outStream.newLine();
            outStream.write("	<td>link=Drawings</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            outStream.write("	<td>click</td>");
            outStream.newLine();
            outStream.write("	<td>link=Animals</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");
            outStream.newLine();
            */
            outStream.write("	<td>click</td>");
            outStream.newLine();
            outStream.write("	<td>css=span.subtext</td>");
            outStream.newLine();
            outStream.write("	<td></td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("<tr>");

            String contentRating = getContentRating();
            if (contentRating.equals("G")||contentRating.equals("T")){
                outStream.write("<tr>");
                outStream.newLine();
                outStream.write("	<td>click</td>");
                outStream.newLine();
                outStream.write("	<td>xpath=(//input[@name='ile-mature-input'])[2]</td>");
                outStream.newLine();
                outStream.write("	<td></td>");
                outStream.newLine();
                outStream.write("</tr>");
            }
            else{
                outStream.write("<tr>");
                outStream.newLine();
                outStream.write("	<td>click</td>");
                outStream.newLine();
                outStream.write("	<td>name=ile-mature-input</td>");
                outStream.newLine();
                outStream.write("	<td></td>");
                outStream.newLine();
                outStream.write("</tr>");
                if(contentRating.equals("A")){
                    outStream.write("<tr>");
                    outStream.newLine();
                    outStream.write("	<td>click</td>");
                    outStream.newLine();
                    outStream.write("	<td>xpath=(//input[@name='matureopts'])[2]</td>");
                    outStream.newLine();
                    outStream.write("	<td></td>");
                    outStream.newLine();
                    outStream.write("</tr>");
                }
            }

            outStream.newLine();
            outStream.write("	<td>assertValue</td>");
            outStream.newLine();
            outStream.write("	<td>id=devtitle</td>");
            outStream.newLine();
            outStream.write("	<td>"+ getEscapedTitleTitle()+"</td>");
            outStream.newLine();
            outStream.write("</tr>");
            outStream.newLine();
            outStream.write("</tbody></table>");
            outStream.newLine();
            outStream.write("</body>");
            outStream.newLine();
            outStream.write("</html>");
            outStream.newLine();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        finally {
            try{
                outStream.close();
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        }

    }
}
