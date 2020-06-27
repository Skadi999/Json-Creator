/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsoncreator;

import jsoncreator.generators.StairsGenerator;
import jsoncreator.generators.WallGenerator;
import jsoncreator.generators.BlockGenerator;
import jsoncreator.generators.SlabGenerator;
import jsoncreator.generators.FenceGenerator;
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
import jsoncreator.generators.FileGenerator;

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

    public boolean validate() {
        return (txtRegName.getText() != null && !txtRegName.getText().equals("")
                && txtTextureName.getText() != null
                && !txtTextureName.getText().equals("") && txtModId.getText()
                != null && !txtModId.getText().equals("")
                && !txtDirectory.getText().equals("")
                && txtDirectory.getText() != null);
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

    private void commonOnClick(FileGenerator gen, String name) {
        if (validate()) {
            gen.generate();
            resultSuccess(name);
        } else if (txtDirectory.getText().equals("") || txtDirectory.getText() == null) {
            resultEmptyDirectory();
        } else {
            resultEmptyField();
        }
    }

    @FXML
    private void stairsOnClick(ActionEvent event) {
        commonOnClick(new StairsGenerator(txtRegName.getText(), txtTextureName.getText(),
                txtModId.getText(), txtDirectory.getText()), "Stairs");
    }

    @FXML
    private void blockOnClick(ActionEvent event) {
        commonOnClick(new BlockGenerator(txtRegName.getText(), txtTextureName.getText(),
                txtModId.getText(), txtDirectory.getText()), "Block");
    }

    @FXML
    private void slabOnClick(ActionEvent event) {
        commonOnClick(new SlabGenerator(txtRegName.getText(), txtTextureName.getText(),
                txtModId.getText(), txtDirectory.getText()), "Slab");
    }

    @FXML
    private void wallOnClick(ActionEvent event) {
        commonOnClick(new WallGenerator(txtRegName.getText(), txtTextureName.getText(),
                txtModId.getText(), txtDirectory.getText()), "Wall");
    }

    @FXML
    private void fenceOnClick(ActionEvent event) throws IOException {
        commonOnClick(new FenceGenerator(txtRegName.getText(), txtTextureName.getText(),
                txtModId.getText(), txtDirectory.getText()), "Fence");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
