package SubmissionForms.ArtSubmissionForm;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Nsyse on 2016-03-27.
 */
public class SelectAllTextOnClickMouseAdapter extends MouseAdapter {

    private JTextField manipulatedField;
    private JTextArea manipulatedArea;

    public SelectAllTextOnClickMouseAdapter(JTextField textField){
        this.manipulatedField = textField;
    }

    public SelectAllTextOnClickMouseAdapter(JTextArea textArea){
        this.manipulatedArea = textArea;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (manipulatedArea==null){
            manipulatedField.selectAll();
        }
        else{
            manipulatedArea.selectAll();
        }
    }
}
