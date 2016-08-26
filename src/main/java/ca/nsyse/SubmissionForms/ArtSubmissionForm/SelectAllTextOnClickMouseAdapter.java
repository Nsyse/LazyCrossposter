package ca.nsyse.SubmissionForms.ArtSubmissionForm;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Nsyse on 2016-03-27.
 */
public class SelectAllTextOnClickMouseAdapter extends MouseAdapter {

    private CustomTextInputUtil manipulatedTextInput;

    public SelectAllTextOnClickMouseAdapter(CustomTextInputUtil manipulatedTextInput){
        this.manipulatedTextInput = manipulatedTextInput;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (manipulatedTextInput.isUnmodified()){
            manipulatedTextInput.selectAllText();
        }
    }
}
