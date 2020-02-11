/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsoncreator;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 *
 * @author Вячеслав
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField txtDirectory;

    @FXML
    private TextField txtRegName;

    @FXML
    private TextField txtTextureName;

    @FXML
    private TextField txtModId;

    @FXML
    private AnchorPane anchorId;

    @FXML
    private Label lblResult;

    public boolean validate(String regName, String textureName, String modId) {
        return (regName != null && !regName.equals("") && textureName != null && !textureName.equals("") && modId != null && !modId.equals("") && !txtDirectory.getText().equals("") && txtDirectory.getText() != null);
    }

    //Browse directory button
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        try {
            Stage stage = (Stage) anchorId.getScene().getWindow();
            DirectoryChooser dc = new DirectoryChooser();
            File selectedDirectory = dc.showDialog(stage);
            txtDirectory.setText(selectedDirectory.getAbsolutePath());
        } catch (NullPointerException npe) {

        }
    }

    //"Generate Stairs" button on click event
    @FXML
    private void stairsOnClick(ActionEvent event) throws IOException {
        String regName = txtRegName.getText();
        String textureName = txtTextureName.getText();
        String modId = txtModId.getText();
        if (validate(regName, textureName, modId)) {
            StairsCreator st = new StairsCreator(regName, textureName, modId, txtDirectory.getText());
            st.create();
            lblResult.setVisible(true);
            lblResult.setTextFill(Color.web("#008d28"));
            lblResult.setText("Stairs successfully created!");

        } else if (txtDirectory.getText().equals("") || txtDirectory.getText() == null) {
            lblResult.setTextFill(Color.web("#bc0000"));
            lblResult.setVisible(true);
            lblResult.setText("You've not selected a directory.");
        } else {
            lblResult.setTextFill(Color.RED);
            lblResult.setVisible(true);
            lblResult.setText("One of your text fields is empty! You must fill all three fields.");
        }
    }

    @FXML
    private void blockOnClick(ActionEvent event) throws IOException {
        String regName = txtRegName.getText();
        String textureName = txtTextureName.getText();
        String modId = txtModId.getText();
        if (validate(regName, textureName, modId)) {
            BlockCreator bt = new BlockCreator(regName, textureName, modId, txtDirectory.getText());
            bt.create();
            lblResult.setVisible(true);
            lblResult.setTextFill(Color.web("#008d28"));
            lblResult.setText("Block successfully created!");

        } else if (txtDirectory.getText().equals("") || txtDirectory.getText() == null) {
            lblResult.setTextFill(Color.web("#bc0000"));
            lblResult.setVisible(true);
            lblResult.setText("You've not selected a directory.");
        } else {
            lblResult.setTextFill(Color.RED);
            lblResult.setVisible(true);
            lblResult.setText("One of your text fields is empty! You must fill all three fields.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
