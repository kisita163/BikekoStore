/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmltableview;

import static internal.BikekoValues.PAINTING;
import static internal.BikekoValues.PAINTING_TECHNIQUES;
import static internal.BikekoValues.TYPE;
import item.Data;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HuguesKi
 */
public class FXMLTableViewController implements Initializable {

    @FXML
    private TableView<Data> tableView;
    @FXML
    private TextField nameField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField authorField;
    @FXML
    private TextField sizeField;
    @FXML
    private TextField widthField;
    @FXML
    private TextField heightField;
    @FXML
    private TextField depthField;
    @FXML
    private TextField weightField;
    @FXML
    private ComboBox typeField;
    @FXML
    private ComboBox techniqueField;
    @FXML
    private CheckBox signedCheckBox;
    @FXML
    private CheckBox framedCheckBox;
    @FXML
    private CheckBox uniqueCheckBox;
    @FXML
    private CheckBox availabilityCheckBox;
    @FXML
    private ImageView imageView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        typeField.getItems().addAll(TYPE);
        typeField.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                setTechniqueField(newValue);
            }
        });
        priceField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    priceField.setText(oldValue);
                }
            }
        });

        widthField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    widthField.setText(oldValue);
                }
            }
        });

        heightField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    heightField.setText(oldValue);
                }
            }
        });

        depthField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    depthField.setText(oldValue);
                }
            }
        });

        weightField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                    weightField.setText(oldValue);
                }
            }
        });
    }

    @FXML
    protected void addItem(ActionEvent event) {
        String size = widthField.getText() + " x " + heightField.getText() + " cm";
        System.out.println("Name     : " + nameField.getText());
        System.out.println("Price    : " + priceField.getText());
        System.out.println("Author   : " + authorField.getText());
        System.out.println("Size     : " + size);
        System.out.println("Weight   : " + weightField.getText());
        System.out.println("Type     : " + typeField.getValue().toString());
        System.out.println("Technique: " + techniqueField.getValue().toString());
        System.out.println("Signed   : " + signedCheckBox.isSelected());
        System.out.println("Framed   : " + framedCheckBox.isSelected());
        System.out.println("Unique   : " + uniqueCheckBox.isSelected());
        System.out.println("Availability : " + availabilityCheckBox.isSelected());

        Data item = new Data(nameField.getText(),
                priceField.getText(),
                authorField.getText(),
                size,
                weightField.getText(),
                typeField.getValue().toString(),
                techniqueField.getValue().toString(),
                signedCheckBox.isSelected(),
                framedCheckBox.isSelected(),
                uniqueCheckBox.isSelected(),
                availabilityCheckBox.isSelected());

        ObservableList<Data> data = tableView.getItems();
        data.add(item);

        initFields();
    }

    private void setTechniqueField(String type) {
        techniqueField.getItems().clear();
        switch (type) {
            case PAINTING:
                techniqueField.getItems().addAll(PAINTING_TECHNIQUES);
                break;
            case "b":
                break;
            case "c":
                break;
            default:
                break;
        }
    }

    private void initFields() {
        nameField.setText("");
        priceField.setText("");
        authorField.setText("");
        widthField.setText("");
        heightField.setText("");
        depthField.setText("");
        weightField.setText("");

        signedCheckBox.setSelected(false);
        framedCheckBox.setSelected(false);
        uniqueCheckBox.setSelected(false);
        availabilityCheckBox.setSelected(false);
    }
    
    @FXML
    protected void handlePictures(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxmltableview/FXMLPictures.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
