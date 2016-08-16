package ca.nsyse;

import ca.nsyse.SubmissionForms.ArtSubmissionForm.ArtFormFillerFrame;
import ca.nsyse.SubmissionForms.JournalSubmissionForm.JournalFormFillerFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nsyse on 2016-03-29.
 */
public class FormChoosingFrame extends JFrame {

    public FormChoosingFrame(){
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
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private JPanel buildPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton uploadDrawing = new JButton("Upload a Drawing");
        uploadDrawing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spawnDrawingUploader();
            }
        });
        uploadDrawing.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(uploadDrawing);

        JButton uploadJournal = new JButton("Upload a Journal");
        uploadJournal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spawnJournalUploader();
            }
        });
        uploadJournal.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(uploadJournal);

        /*
        //Configure
        JButton configureButton = new JButton("Configure");
        configureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spawnJournalUploader();
            }
        });
        configureButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(configureButton);
        */

        return panel;
    }

    private void spawnDrawingUploader(){
        ArtFormFillerFrame fFF = new ArtFormFillerFrame();
    }

    private void spawnJournalUploader(){
        JournalFormFillerFrame jFF = new JournalFormFillerFrame();
    }

    private void spawnConfigureFrame(){
        ConfigureFrame cF = new ConfigureFrame();
    }

}
