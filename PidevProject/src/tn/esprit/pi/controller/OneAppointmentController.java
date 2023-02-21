/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.pi.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import tn.esprit.pi.services.ServiceAppointment;

/**
 * FXML Controller class
 *
 * @author Nasreddine
 */
public class OneAppointmentController implements Initializable {

    @FXML
    private AnchorPane anchor_appointment;
    @FXML
    private Label label_dateAp;
    @FXML
    private Label label_hour;
    @FXML
    private Label idPatient;
    @FXML
    private Label label_idPatient;
    @FXML
    private Button button_accepter;

    private int idAp;
    private int idMedecin=1;
    @FXML
    private Label label_idMedecin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void accepterClicked(MouseEvent event) throws SQLException {
      
        ServiceAppointment Sa=new ServiceAppointment();
        Sa.acceptMedecin(idAp);
        
    }

    public AnchorPane getAnchor_appointment() {
        return anchor_appointment;
    }

    public void setAnchor_appointment(AnchorPane anchor_appointment) {
        this.anchor_appointment = anchor_appointment;
    }

    public String getLabel_dateAp() {
        return label_dateAp.getText();
    }

    public void setLabel_dateAp(String label_dateAp) {
        this.label_dateAp.setText(label_dateAp);
    }

    public String getLabel_hour() {
        return label_hour.getText();
    }

    public void setLabel_hour(String label_hour) {
        this.label_hour.setText(label_hour);
    }

    public String getIdPatient() {
        return idPatient.getText();
    }

    public void setIdPatient(String idPatient) {
        this.idPatient.setText(idPatient);
    }

    public int getLabel_idPatient() {
        return Integer.valueOf(label_idPatient.getText());
    }

    public void setLabel_idPatient(String label_idPatient) {
        this.label_idPatient.setText(label_idPatient);
    }

    public Button getButton_accepter() {
        return button_accepter;
    }

    public void setButton_accepter(Button button_accepter) {
        this.button_accepter = button_accepter;
    }

    public int getIdAp() {
        return idAp;
    }

    public void setIdAp(int idAp) {
        this.idAp = idAp;
    }

    public int getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(int idMedecin) {
        this.idMedecin = idMedecin;
        label_idMedecin.setText(String.valueOf(idMedecin));
    }
    
    public void setEtat(boolean buttonAccepter){
    button_accepter.setVisible(buttonAccepter);
    }

    @FXML
    private void buttonRefuserClicked(MouseEvent event) throws SQLException {
       
        ServiceAppointment Sa=new ServiceAppointment();
        Sa.delete(idAp);
    }
    
}
