/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Dell
 */
public class RdvVet {
     private  java.sql.Date dateRdv ;
     private String heureRdv ;
    private  String refRdv  ;
    private int id_veterinaire;
    private int id_patient;

    public RdvVet(Date dateRdv, String heureRdv, String refRdv, int id_veterinaire, int id_patient) {
        this.dateRdv = dateRdv;
        this.heureRdv = heureRdv;
        this.refRdv = refRdv;
        this.id_veterinaire = id_veterinaire;
        this.id_patient = id_patient;
    }

    public Date getDateRdv() {
        return dateRdv;
    }

    public void setDateRdv(Date dateRdv) {
        this.dateRdv = dateRdv;
    }

    public String getHeureRdv() {
        return heureRdv;
    }

    public void setHeureRdv(String heureRdv) {
        this.heureRdv = heureRdv;
    }

    public String getRefRdv() {
        return refRdv;
    }

    public void setRefRdv(String refRdv) {
        this.refRdv = refRdv;
    }

    public int getId_veterinaire() {
        return id_veterinaire;
    }

    public void setId_veterinaire(int id_veterinaire) {
        this.id_veterinaire = id_veterinaire;
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    @Override
    public String toString() {
        return "RdvVet{" + "dateRdv=" + dateRdv + ", heureRdv=" + heureRdv + ", refRdv=" + refRdv + ", id_veterinaire=" + id_veterinaire + ", id_patient=" + id_patient + '}';
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
        final RdvVet other = (RdvVet) obj;
        if (this.heureRdv != other.heureRdv) {
            return false;
        }
        if (this.id_veterinaire != other.id_veterinaire) {
            return false;
        }
        if (this.id_patient != other.id_patient) {
            return false;
        }
        if (!Objects.equals(this.refRdv, other.refRdv)) {
            return false;
        }
        if (!Objects.equals(this.dateRdv, other.dateRdv)) {
            return false;
        }
        return true;
    }
    
    
    
}
