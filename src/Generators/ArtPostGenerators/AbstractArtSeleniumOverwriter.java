package Generators.ArtPostGenerators;

import Generators.GeneratesTest;

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

    public String getSubmissionTitle() {
        return submissionTitle;
    }

    public ArrayList<String> getTagsList() {
        return tagsList;
    }

    private String submissionPath;
    private String submissionTitle;

    public String getSubmissionDescription() {
        return submissionDescription;
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
