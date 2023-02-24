/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.pi.entities;

import java.util.Date;

/**
 *
 * @author Nasreddine
 */
public class Appointment {
    private int idAp;
    private String dateAp; 
    private String hour ;
    private int idMedecin;
    private int idPatient;
    private boolean status;

    public Appointment(int idAp, String dateAp, String hour, int idMedecin, int idPatient, boolean status) {
        this.idAp = idAp;
        this.dateAp = dateAp;
        this.hour = hour;
        this.idMedecin = idMedecin;
        this.idPatient = idPatient;
        this.status = status;
    }

    public Appointment(String dateAp, String hour, int idMedecin, int idPatient, boolean status) {
        this.dateAp = dateAp;
        this.hour = hour;
        this.idMedecin = idMedecin;
        this.idPatient = idPatient;
        this.status = status;
    }

    
    
    
    
    
    
    
    public int getIdAp() {
        return idAp;
    }

    public void setIdAp(int idAp) {
        this.idAp = idAp;
    }

    public String getDateAp() {
        return dateAp;
    }

    public void setDateAp(String dateAp) {
        this.dateAp = dateAp;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(int idMedecin) {
        this.idMedecin = idMedecin;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "appointment{" + "idAp=" + idAp + ", dateAp=" + dateAp + ", hour=" + hour + ", idMedecin=" + idMedecin + ", idPatient=" + idPatient + ", status=" + status + '}';
    }
    
    
    
    
    
}
