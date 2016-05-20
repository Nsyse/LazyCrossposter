package SubmissionForms.ArtSubmissionForm;

import Generators.ArtPostGenerators.SeleniumArtTestSuiteGenerator;
import SubmissionForms.ArtSubmissionForm.SubmissionFormElements.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Nsyse on 2016-03-27.
 */
public class ArtFormFillerFrame extends FormFrame {

    private ArtSubmissionFormModel artSubmissionFormModel;

    public ArtFormFillerFrame() {
        JPanel panel = buildPanel();
        Container pane = this.getContentPane();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        this.getContentPane().add(panel);
        this.setTitle("Nsyse Furry Crossposter");

        JLabel copyLeftNoticeLabel = new JLabel("This software is copyleft and provided as-is!");
        copyLeftNoticeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //this.add(copyLeftNoticeLabel);

        JLabel feedbackPlsLabel = new JLabel("Please send feature requests and feedback to the.nsyse@gmail.com");
        feedbackPlsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(feedbackPlsLabel);

        JButton submitButton = new JButton("Create Selnium Tests!");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitForm();
            }
        });
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(submitButton);


        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void submitForm() {
        this.setReadyForUpload(this.validateFormElements());
        if(this.isReadyForUpload()){
            artSubmissionFormModel = new ArtSubmissionFormModel();
            for(SubmissionFormElement element :formElements){
                if (element instanceof TitleSubmissionFormElement){
                    String title = ((TitleSubmissionFormElement)element).getSubmissionTitle();
                    artSubmissionFormModel.setSubmissionTitle(title);
                    System.out.println(title);
                }
                else if( element instanceof TagsSubmissionFormElement){
                    ArrayList<String> tags = ((TagsSubmissionFormElement)element).getAllTags();
                    artSubmissionFormModel.setSubmissionTags(tags);
                    System.out.println(tags);
                }
                else if (element instanceof DescriptionSubmissionFormElement){
                    String description = ((DescriptionSubmissionFormElement)element).getSubmissionDescription();
                    artSubmissionFormModel.setSubmissionDescription(description);
                    System.out.println(description);
                }
                else if (element instanceof PathSubmissionFormElement){
                    String path = ((PathSubmissionFormElement)element).getFilePath();
                    artSubmissionFormModel.setSubmissionPath(path);
                }
                else if (element instanceof WebsitesSelectFormElement){
                    ArrayList<String> websitesNames = ((WebsitesSelectFormElement)element).getSelectedWebsites();
                    artSubmissionFormModel.setWebsitesNamesChosen(websitesNames);
                }
                else if (element instanceof ContentRatingSelectFormElement){
                    String contentRating = ((ContentRatingSelectFormElement)element).getSelectedContentRating();
                    artSubmissionFormModel.setContentRating(contentRating);
                }
            }
            SeleniumArtTestSuiteGenerator generator = new SeleniumArtTestSuiteGenerator(artSubmissionFormModel);
        }
    }

    private JPanel buildPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        addFormElement(new PathSubmissionFormElement(this));
        addFormElement(new ContentRatingSelectFormElement(this));
        addFormElement(new TitleSubmissionFormElement(this));
        addFormElement(new DescriptionSubmissionFormElement(this));
        addFormElement(new TagsSubmissionFormElement(this));
        addFormElement(new WebsitesSelectFormElement(this));
        return panel;
    }

    public ArtSubmissionFormModel getArtSubmissionFormModel() {
        return artSubmissionFormModel;
    }
}
