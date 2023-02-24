/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.pi.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Nasreddine
 */
public class OneDoctorController implements Initializable {

    @FXML
    private AnchorPane Anchor_doctor;
    @FXML
    private Label label_idDoctor;
    @FXML
    private Label label_firstname;
    @FXML
    private Label label_lastname;
    @FXML
    private Label label_speciality;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public AnchorPane getAnchor_doctor() {
        return Anchor_doctor;
    }

    public void setAnchor_doctor(AnchorPane Anchor_doctor) {
        this.Anchor_doctor = Anchor_doctor;
    }

    public Label getLabel_idDoctor() {
        return label_idDoctor;
    }

    public void setLabel_idDoctor(int label_idDoctor) {
        this.label_idDoctor.setText(String.valueOf(label_idDoctor));
    }

    public Label getLabel_firstname() {
        return label_firstname;
    }

    public void setLabel_firstname(String label_firstname) {
        this.label_firstname.setText(label_firstname);
    }

    public Label getLabel_lastname() {
        return label_lastname;
    }

    public void setLabel_lastname(String label_lastname) {
        this.label_lastname.setText(label_lastname);
    }

    public Label getLabel_speciality() {
        return label_speciality;
    }

    public void setLabel_speciality(String label_speciality) {
        this.label_speciality.setText(label_speciality);
    }
    
    
    
}
