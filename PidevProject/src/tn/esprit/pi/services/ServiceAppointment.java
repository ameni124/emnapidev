/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.pi.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.esprit.pi.entities.Appointment;
import tn.esprit.pi.entities.User;
import tn.esprit.pi.util.MyConnection;

/**
 *
 * @author Nasreddine
 */
public class ServiceAppointment implements IServiceCRUD<Appointment>{

    Connection cnx= MyConnection.getInstance().getCnx();

    @Override
    public void add(Appointment a) throws SQLException {
        //request 
        String req="INSERT INTO `appointment`(`dateAp`, `hour`, `idPatient`,`idMedecin`,`status`) VALUES (?,?,?,?,?)";

        
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setString(1,a.getDateAp());
            pst.setString(2,a.getHour());
            pst.setInt(3,a.getIdPatient());
            pst.setInt(4, a.getIdMedecin());
            pst.setBoolean(5,a.isStatus());
            
                         
            pst.executeUpdate();
            System.out.println("rendez-vous ajouter avec Succes");
    }

    @Override
    public void update(Appointment a, int idAp) throws SQLException {
        //request 
        String req="UPDATE `appointment` SET  `dateAp`=? ,`hour`=? WHERE idAp =?";
        PreparedStatement pst =cnx.prepareStatement(req);
        pst.setString(1,a.getDateAp());
        pst.setString(2,a.getHour());
        pst.setInt(3,idAp);
        pst.executeUpdate();

        System.out.println("modification terminer avec Succes");

         
    }

    @Override
    public void delete(int idAp) throws SQLException {
        //request 
        String req="DELETE FROM `appointment` WHERE idAp=?";

        
            PreparedStatement pst =cnx.prepareStatement(req);
            pst.setInt(1,idAp);            
            pst.executeUpdate();
            System.out.println("Rendez-vous Supprimer avec Succes");     
    }

    
    
    @Override
    public List show() throws SQLException {
        //LIST
        List<Appointment> appointments = new ArrayList<>();
        //request 
        String req ="SELECT * FROM APPOINTMENT";
        
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                appointments.add(new Appointment(rs.getInt("idAp"),rs.getString("dateAp"),rs.getString("hour"),rs.getInt("idMedecin"),rs.getInt("idPatient"),rs.getBoolean("status")));    
            }

        return appointments; 
    }
    

    public void acceptMedecin(int idAp) throws SQLException{
    //request 
        String req="UPDATE `appointment` SET  `status`=true WHERE idAp =?";
        PreparedStatement pst =cnx.prepareStatement(req);
        pst.setInt(1,idAp);
        pst.executeUpdate();

        System.out.println("accepte terminer avec Succes");
    }

    public List show(int idMedecin) throws SQLException {
        //LIST
        List<Appointment> appointments = new ArrayList<>();
        //request 
        String req ="SELECT * FROM APPOINTMENT where idMedecin="+String.valueOf(idMedecin);
        
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                appointments.add(new Appointment(rs.getInt("idAp"),rs.getString("dateAp"),rs.getString("hour"),rs.getInt("idPatient"),rs.getInt("idMedecin"),rs.getBoolean("status")));    
            }

        return appointments; 

    }

    public void updateDate(String newDate,int idAp) throws SQLException {

        //request 
        String req="UPDATE `appointment` SET  `dateAp`=? WHERE idAp =?";
        PreparedStatement pst =cnx.prepareStatement(req);
        pst.setDate(1,Date.valueOf(newDate));
        pst.setInt(2,idAp);
        pst.executeUpdate();

        System.out.println("date modifier avec Succes");
    }

    public void updateHour(String hour, int idAp) throws SQLException {
        //request 
        String req="UPDATE `appointment` SET  `hour`=? WHERE idAp =?";
        PreparedStatement pst =cnx.prepareStatement(req);
        pst.setString(1,hour);
        pst.setInt(2,idAp);
        pst.executeUpdate();

        System.out.println("hour modifier avec Succes");    }
    
    
    
    public List getListDoctor() throws SQLException {
        //LIST
        List<User> doctors = new ArrayList<>();
        //request 
        String req ="SELECT * FROM USER where Role='MEDECIN' ";
        
            //insert
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next())
            {
                doctors.add(
                        new User(
                        rs.getInt("idUser")
                        ,rs.getString("firstname")
                        ,rs.getString("lastname")
                        ,rs.getString("speciality")
                        ,rs.getString("role")));    
            }

        return doctors; 

    }
    
}
