/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.pi.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import tn.esprit.pi.entities.Appointment;
import tn.esprit.pi.entities.User;
import tn.esprit.pi.services.IServiceCRUD;
import tn.esprit.pi.services.ServiceAppointment;

/**
 * FXML Controller class
 *
 * @author Nasreddine
 */
public class AppointmentController implements Initializable {

    @FXML
    private Button button_modifier;
    @FXML
    private DatePicker line_date;
    @FXML
    private TextField line_hour;
    @FXML
    private Button btnAcceuil;
    @FXML
    private Label nomDoc;
    @FXML
    private Label specialiteDoc;
    @FXML
    private ListView<AnchorPane> list_collection;
    @FXML
    private Label label_id;
    @FXML
    private TextField line_min;
    private int idAp;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            afficher();
        } catch (SQLException ex) {
            Logger.getLogger(AppointmentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void updateClicked(MouseEvent event) throws SQLException, ParseException {
        
        System.out.println("\nupdateClicked");
        ServiceAppointment Sa = new ServiceAppointment();

        
        
        
        
        
        if(verifHHMM(line_hour.getText(),line_min.getText()))
        {
            String time=line_hour.getText()+":"+line_min.getText();
            Sa.updateHour(time,idAp);
        }
        final DateTimeFormatter NEW_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        String getDateRdv = line_date.getValue().format(NEW_FORMATTER);
   
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateRDV = format.parse(getDateRdv);
        Date dateNow=new Date();

        if(dateNow.before(dateRDV))
        {
        
        Sa.updateDate(line_date.getValue().format(NEW_FORMATTER).toString(),idAp);
        
        }else System.out.println("\ndate non valide");
        
        afficher();
    }

    @FXML
    private void retourAcceuil(ActionEvent event) {
    }

    @FXML
    private void select(MouseEvent event) {
        
       this.idAp= Integer.parseInt(((AnchorPane)this.list_collection.getSelectionModel().getSelectedItem()).getId());
               
       
       System.out.println("\n");
       System.out.println(idAp);
        
    }
    
    
    
    
    private void afficher() throws SQLException 
    {
        String userRole="ADMIN";
        int userId=3;

        
        this.list_collection.getItems().clear();
        ObservableList<AnchorPane> pubss = FXCollections.observableArrayList();
        
        ServiceAppointment Sa = new ServiceAppointment();
        System.out.println(Sa.show());
       
         if(userRole.equals("ADMIN"))
        {
            System.out.println("hello admin");
        
        
        for(int i = 0; i < Sa.show().size(); ++i) {
            Appointment get = (Appointment)Sa.show().get(i);
            FXMLLoader load = new FXMLLoader(this.getClass().getResource("/tn/esprit/pi/gui/OneAppointment.fxml"));

            try {
                Parent var7 = (Parent)load.load();
            } catch (IOException var27) {
                System.out.println("errour");
            }

            OneAppointmentController appointmentController2 = (OneAppointmentController)load.getController();
            AnchorPane p = new AnchorPane(new Node[]{appointmentController2.getAnchor_appointment()});
            
            appointmentController2.setIdAp(get.getIdAp());
            appointmentController2.setLabel_dateAp(get.getDateAp());
            appointmentController2.setLabel_hour(get.getHour());            
            appointmentController2.setLabel_idPatient(String.valueOf(get.getIdPatient()));
            
            appointmentController2.setEtat(false);
           
            
            p.setId(Integer.toString(get.getIdAp()));
            
            pubss.add(p);
        }
        this.list_collection.getItems().addAll(pubss);
    }
        else if(userRole.equals("MEDECIN"))
        {
        
            System.out.println("hello Medecin");
        
        
        for(int i = 0; i < Sa.show(userId).size(); ++i) {
            Appointment get = (Appointment)Sa.show(userId).get(i);
            FXMLLoader load = new FXMLLoader(this.getClass().getResource("/tn/esprit/pi/gui/OneAppointment.fxml"));

            try {
                Parent var7 = (Parent)load.load();
            } catch (IOException var27) {
                System.out.println("errour");
            }

            OneAppointmentController appointmentController2 = (OneAppointmentController)load.getController();
            AnchorPane p = new AnchorPane(new Node[]{appointmentController2.getAnchor_appointment()});
            
            appointmentController2.setIdAp(get.getIdAp());
            appointmentController2.setLabel_dateAp(get.getDateAp());
            appointmentController2.setLabel_hour(get.getHour());            
            appointmentController2.setLabel_idPatient(String.valueOf(get.getIdPatient()));
            
            if(!get.isStatus())
            {
            appointmentController2.setEtat(true);

            }
            else
            appointmentController2.setEtat(false);

           
            
            p.setId(Integer.toString(get.getIdAp()));
            
            pubss.add(p);
        }
        this.list_collection.getItems().addAll(pubss);
        }
        
        
    }

    @FXML
    private void refreshClicked(MouseEvent event) throws SQLException {
        
        afficher();
    }

    
    
    
    
    private boolean verifHHMM(String hh, String mm) {
        if(!isNumber(hh) || !isNumber(mm))
        {
            System.out.println("\nnot number");
            return false;
        }
        if(hh.length()>2 || mm.length()>2 || hh.length()<=0 || mm.length()<=0)
        {
            System.out.println("\nnot lenght");
            return false;
        }
        int hour=Integer.parseInt(hh);
        int min=Integer.parseInt(mm);
        if(hour>23 || hour<0 || min>59 || min < 0)
            return false;
        return true;
    }
    
    private boolean isNumber(String chaine){
    
        if(chaine.length()==0)
            return false;
        for (int i = 0; i < chaine.length(); i++) {
            if (!Character.isDigit(chaine.charAt(i))) {
                return false;
            }
        }
    return true;
    }
    
}
