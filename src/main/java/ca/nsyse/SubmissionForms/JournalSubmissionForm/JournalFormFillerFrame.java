package ca.nsyse.SubmissionForms.JournalSubmissionForm;

import ca.nsyse.Generators.JournalBlogPostGenerators.SeleniumJournalTestSuiteGenerator;
import ca.nsyse.SubmissionForms.ArtSubmissionForm.FormFrame;
import ca.nsyse.SubmissionForms.ArtSubmissionForm.SubmissionFormElements.DescriptionSubmissionFormElement;
import ca.nsyse.SubmissionForms.ArtSubmissionForm.SubmissionFormElements.SubmissionFormElement;
import ca.nsyse.SubmissionForms.ArtSubmissionForm.SubmissionFormElements.TitleSubmissionFormElement;
import ca.nsyse.SubmissionForms.ArtSubmissionForm.SubmissionFormElements.WebsitesSelectFormElement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Nsyse on 2016-03-29.
 */
public class JournalFormFillerFrame extends FormFrame {

    private JournalSubmissionFormModel journalSubmissionFormModel;

    public JournalFormFillerFrame() {
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

    private JPanel buildPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        addFormElement(new TitleSubmissionFormElement(this));
        addFormElement(new DescriptionSubmissionFormElement(this));
        addFormElement(new WebsitesSelectFormElement(this));
        return panel;
    }

    public void submitForm() {
        this.setReadyForUpload(validateFormElements());
        if (this.isReadyForUpload()) {
            journalSubmissionFormModel = new JournalSubmissionFormModel();
            for (SubmissionFormElement element : formElements) {
                if (element instanceof TitleSubmissionFormElement) {
                    String title = ((TitleSubmissionFormElement) element).getSubmissionTitle();
                    journalSubmissionFormModel.setSubmissionTitle(title);
                } else if (element instanceof DescriptionSubmissionFormElement) {
                    String description = ((DescriptionSubmissionFormElement) element).getSubmissionDescription();
                    journalSubmissionFormModel.setSubmissionDescription(description);
                } else if (element instanceof WebsitesSelectFormElement) {
                    ArrayList<String> websitesNames = ((WebsitesSelectFormElement) element).getSelectedWebsites();
                    journalSubmissionFormModel.setWebsitesNamesChosen(websitesNames);
                }
            }
            SeleniumJournalTestSuiteGenerator generator = new SeleniumJournalTestSuiteGenerator(journalSubmissionFormModel);
        }

    }
}
