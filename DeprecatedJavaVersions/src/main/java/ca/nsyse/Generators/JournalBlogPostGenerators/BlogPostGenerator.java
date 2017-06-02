package ca.nsyse.Generators.JournalBlogPostGenerators;

import ca.nsyse.GeneratesTest;

/**
 * Created by Nsyse on 2016-03-29.
 */
public abstract class BlogPostGenerator implements GeneratesTest {

    private final String websiteName;
    private String journalTitle;
    private String journalDescription;


    //TODO: Encode html chars
    public String getWebsiteName() {
        return websiteName;
    }

    public String getJournalTitle() {
        return journalTitle;
    }

    public String getJournalDescription() {
        return journalDescription;
    }

    public BlogPostGenerator(String websiteName, String journalTitle, String journalDescription){
        super();
        this.websiteName = websiteName;
        this.journalTitle=journalTitle;
        this.journalDescription=journalDescription;
    }
}
