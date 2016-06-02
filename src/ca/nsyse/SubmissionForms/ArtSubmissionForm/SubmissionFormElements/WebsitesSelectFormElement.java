package ca.nsyse.SubmissionForms.ArtSubmissionForm.SubmissionFormElements;

import ca.nsyse.SubmissionForms.ArtSubmissionForm.FormFrame;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Nsyse on 2016-03-29.
 */
public class WebsitesSelectFormElement extends SubmissionFormElement {

    private ArrayList<WebsiteSelector> selectors = new ArrayList<>();

    public WebsitesSelectFormElement(FormFrame listeningFrame) {
        super(listeningFrame);

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        addSelector(new WebsiteSelector("DeviantArt"));
        addSelector(new WebsiteSelector("Furaffinity"));
        addSelector(new WebsiteSelector("Weasyl"));
        addSelector(new WebsiteSelector("Furiffic"));
        addSelector(new WebsiteSelector("SoFurry"));
        addSelector(new WebsiteSelector("InkBunny"));
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
