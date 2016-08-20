package ca.nsyse.Generators.ArtPostGenerators;

import ca.nsyse.GeneratesTest;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.ArrayList;

/**
 * Created by Nsyse on 2016-03-26.
 */
public abstract class AbstractArtSeleniumOverwriter implements GeneratesTest {

    public String getContentRating() {
        return contentRating;
    }

    private final String contentRating;
    private String websiteName;

    public String getSubmissionPath() {
        return submissionPath;
    }

    public String getEscapedTitleTitle() {

        String escapedTitle = StringEscapeUtils.escapeHtml4(submissionTitle);
        return escapedTitle;
    }

    public ArrayList<String> getTagsList() {
        return tagsList;
    }

    private String submissionPath;
    private String submissionTitle;

    public String getSubmissionDescription() {
        String escapedDesc = StringEscapeUtils.escapeHtml4(submissionDescription);
        return escapedDesc;
    }

    private String submissionDescription;
    private ArrayList<String> tagsList;

    /**
     * Overwrites the selenium upload file test
     * @param submissionPath
     * @param submissionTitle
     * @param submissionDescription
     * @param tagsList
     */
    public AbstractArtSeleniumOverwriter(String websiteName, String submissionPath, String submissionTitle, String submissionDescription, ArrayList<String> tagsList, String contentRating){
        this.websiteName = websiteName;
        this.submissionPath = submissionPath;
        this.submissionTitle = submissionTitle;
        this.tagsList = tagsList;
        this.submissionDescription = submissionDescription;
        this.contentRating = contentRating;
    }

    public String getWebsiteName() {
        return websiteName;
    }
}
