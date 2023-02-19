/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi.entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Dell
 */
public class Rdv {
    private  java.sql.Date dateRdv ;
    private int hour ;
    private  String ref  ;
    private int id_medecin;
    private int id_patient;

    public Rdv(Date dateRdv, int hour, String ref, int id_medecin, int id_patient) {
        this.dateRdv = dateRdv;
        this.hour = hour;
        this.ref = ref;
        this.id_medecin = id_medecin;
        this.id_patient = id_patient;
    }

    public int getId_medecin() {
        return id_medecin;
    }

    public void setId_medecin(int id_medecin) {
        this.id_medecin = id_medecin;
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public Date getDateRdv() {
        return dateRdv;
    }

    public void setDateRdv(Date dateRdv) {
        this.dateRdv = dateRdv;
    }

    @Override
    public String toString() {
        return "Rdv{" + "dateRdv=" + dateRdv + ", hour=" + hour + ", ref=" + ref + ", id_medecin=" + id_medecin + ", id_patient=" + id_patient + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rdv other = (Rdv) obj;
        if (this.hour != other.hour) {
            return false;
        }
        if (this.id_medecin != other.id_medecin) {
            return false;
        }
        if (this.id_patient != other.id_patient) {
            return false;
        }
        if (!Objects.equals(this.ref, other.ref)) {
            return false;
        }
        if (!Objects.equals(this.dateRdv, other.dateRdv)) {
            return false;
        }
        return true;
    }

    

   

    

   

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    

    

    
}
