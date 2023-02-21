
package tn.esprit.pi.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
import tn.esprit.pi.services.ServiceAppointment;

/**
 * FXML Controller class
 *
 * @author Nasreddine
 */
public class AppointmentPatientController implements Initializable {

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
    @FXML
    private ListView<AnchorPane> list_collection2;
    private int idAp;
    private int idDoctor;
    private int idUser=2;
    @FXML
    private Button button_ajouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            try {
                // TODO
                afficher2();
            } catch (SQLException ex) {
                Logger.getLogger(AppointmentPatientController.class.getName()).log(Level.SEVERE, null, ex);
            }
            afficher();
       
    }   catch (SQLException ex) {    
            Logger.getLogger(AppointmentPatientController.class.getName()).log(Level.SEVERE, null, ex);
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
        
        
        
        String getDateRdv = line_date.getValue().format(NEW_FORMATTER).toString();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateRDV = format.parse(getDateRdv);
        Date dateNow=new Date();
        
        
        if(dateNow.before(dateRDV))
        {
        Sa.updateDate(line_date.getValue().format(NEW_FORMATTER).toString(),idAp);
        }else System.out.println("Date non valide");

        afficher2();
      
    }

    @FXML
    private void retourAcceuil(ActionEvent event) {
    }

    @FXML
    private void select(MouseEvent event) {
        
        this.idDoctor= Integer.parseInt(((AnchorPane)this.list_collection.getSelectionModel().getSelectedItem()).getId());

    }

    @FXML
    private void refreshClicked(MouseEvent event) throws SQLException {
                afficher2();
                afficher();

    }

    
    
      private void afficher() throws SQLException 
    {
        String userRole="PATIENT";
        int userId=2;

        
        this.list_collection.getItems().clear();
        ObservableList<AnchorPane> pubss = FXCollections.observableArrayList();
        
        ServiceAppointment Sa = new ServiceAppointment();
       
        
        
        for(int i = 0; i < Sa.getListDoctor().size(); ++i) 
        {
            User get = (User)Sa.getListDoctor().get(i);
            FXMLLoader load = new FXMLLoader(this.getClass().getResource("/tn/esprit/pi/gui/OneDoctor.fxml"));

            try {
                Parent var7 = (Parent)load.load();
            } catch (IOException var27) {
                System.out.println("errour");
            }

            OneDoctorController oneDoctorController2 = (OneDoctorController)load.getController();
            AnchorPane p = new AnchorPane(new Node[]{oneDoctorController2.getAnchor_doctor()});
            
            oneDoctorController2.setLabel_firstname(get.getFirstname());
            oneDoctorController2.setLabel_lastname(get.getLastname());
            oneDoctorController2.setLabel_speciality(get.getSpeciality());  
            
            oneDoctorController2.setLabel_idDoctor(get.getIdUser());
            

           
            
            p.setId(Integer.toString(get.getIdUser()));
            
            pubss.add(p);
        }
        this.list_collection.getItems().addAll(pubss);
    
       
        
    }
    
    
    
    
    
    public void afficher2() throws SQLException {
        String userRole="PATIENT";
        int userId=2;

        
        this.list_collection2.getItems().clear();
        ObservableList<AnchorPane> pubss = FXCollections.observableArrayList();
        
        ServiceAppointment Sa = new ServiceAppointment();
        
        for(int i = 0; i < Sa.show().size(); ++i) {
            
            Appointment get = (Appointment)Sa.show().get(i);
            if(userId==get.getIdPatient()){
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
            appointmentController2.setIdMedecin(get.getIdMedecin());
         
            appointmentController2.setEtat(false);

           
            
            p.setId(Integer.toString(get.getIdAp()));
            
            pubss.add(p);
        }
        }
        this.list_collection2.getItems().addAll(pubss);
        
      
    }

    @FXML
    private void select2(MouseEvent event) {
    
        System.out.println(idAp);
        
        this.idAp= Integer.parseInt(((AnchorPane)this.list_collection2.getSelectionModel().getSelectedItem()).getId());

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

    @FXML
    private void addClicked(MouseEvent event) throws SQLException, ParseException {
        
        ServiceAppointment Sa=new ServiceAppointment();
        
        if(verifHHMM(line_hour.getText(),line_min.getText()))
        {
            String time=line_hour.getText()+":"+line_min.getText();
            
        
            
        final DateTimeFormatter NEW_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
         String getDateRdv = line_date.getValue().format(NEW_FORMATTER);
   
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateRDV = format.parse(getDateRdv);
        Date dateNow=new Date();

        if(dateNow.before(dateRDV))
        {
        
            Appointment a= new Appointment(line_date.getValue().format(NEW_FORMATTER).toString(),time,idDoctor,idUser,false);
        
            Sa.add(a);
            
        }
        else System.out.println("Date Non valide");

        }
        afficher2();
        
    }
    
}
