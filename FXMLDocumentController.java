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

    public void resultSuccess(String name) {
        lblResult.setVisible(true);
        lblResult.setTextFill(Color.web("#008d28"));
        lblResult.setText(name + " successfully created!");
    }

    public void resultEmptyDirectory() {
        lblResult.setVisible(true);
        lblResult.setTextFill(Color.web("#bc0000"));
        lblResult.setText("You've not selected a directory.");
    }

    public void resultEmptyField() {
        lblResult.setVisible(true);
        lblResult.setTextFill(Color.web("#bc0000"));
        lblResult.setText("One of your text fields is empty! You must fill all three fields.");
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
        if (validate(txtRegName.getText(), txtTextureName.getText(), txtModId.getText())) {
            StairsCreator st = new StairsCreator(txtRegName.getText(), txtTextureName.getText(), txtModId.getText(), txtDirectory.getText());
            st.create();
            resultSuccess("Stairs");
        } else if (txtDirectory.getText().equals("") || txtDirectory.getText() == null) {
            resultEmptyDirectory();
        } else {
            resultEmptyField();
        }
    }

    //"Generate Block" button on click event
    @FXML
    private void blockOnClick(ActionEvent event) throws IOException {
        if (validate(txtRegName.getText(), txtTextureName.getText(), txtModId.getText())) {
            BlockCreator bt = new BlockCreator(txtRegName.getText(), txtTextureName.getText(), txtModId.getText(), txtDirectory.getText());
            bt.create();
            resultSuccess("Block");

        } else if (txtDirectory.getText().equals("") || txtDirectory.getText() == null) {
            resultEmptyDirectory();
        } else {
            resultEmptyField();
        }
    }
    //TODO REMOVE PARAMETERS FROM VALIDATE METHOD
    //"Generate Slab" button on click event
    @FXML
    private void slabOnClick(ActionEvent event) throws IOException {
        if (validate(txtRegName.getText(), txtTextureName.getText(), txtModId.getText())) {
            SlabCreator st = new SlabCreator(txtRegName.getText(), txtTextureName.getText(), txtModId.getText(), txtDirectory.getText());
            st.create();
            resultSuccess("Slab");

        } else if (txtDirectory.getText().equals("") || txtDirectory.getText() == null) {
            resultEmptyDirectory();
        } else {
            resultEmptyField();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
