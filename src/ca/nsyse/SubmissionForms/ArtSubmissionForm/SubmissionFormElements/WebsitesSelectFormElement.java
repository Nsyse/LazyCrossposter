package ca.nsyse.SubmissionForms.ArtSubmissionForm.SubmissionFormElements;

import ca.nsyse.SubmissionForms.ArtSubmissionForm.FormFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Nsyse on 2016-03-29.
 */
public class WebsitesSelectFormElement extends SubmissionFormElement {

    private ArrayList<WebsiteSelector> selectors = new ArrayList<>();
    protected static final String defaultCodes = "abcdef";

    public WebsitesSelectFormElement(FormFrame listeningFrame) {
        super(listeningFrame);

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        addSelector(new WebsiteSelector("DeviantArt", "a"));
        addSelector(new WebsiteSelector("Furaffinity", "b"));
        addSelector(new WebsiteSelector("Weasyl", "c"));
        addSelector(new WebsiteSelector("Furiffic", "d"));
        addSelector(new WebsiteSelector("SoFurry", "e"));
        addSelector(new WebsiteSelector("InkBunny", "f"));
    }

    @Override
    public String validateFields() {
        //Always valid
        return "";
    }

    private void addSelector(WebsiteSelector selector){
        this.add(selector);
        selectors.add(selector);
    }

    public ArrayList<String> getSelectedWebsites(){
        ArrayList<String> selectedWebsitesNamesList = new ArrayList<>();
        for (WebsiteSelector selector : selectors){
            if (selector.getIsSelected()){
                selectedWebsitesNamesList.add(selector.getWebsiteName());
            }
        }
        return selectedWebsitesNamesList;
    }
}
