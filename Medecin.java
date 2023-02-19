/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi.entities;

/**
 *
 * @author Dell
 */
public class Medecin {
    private int phone;
    private  String nom ;
    private  String photo;
    private String email ;
    private  String adresse ;
        private String specialite ;

    public Medecin(int phone, String nom, String photo, String email, String adresse, String specialite) {
        this.phone = phone;
        this.nom = nom;
        this.photo = photo;
        this.email = email;
        this.adresse = adresse;
        this.specialite = specialite;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

   

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Medecin{" + "phone=" + phone + ", nom=" + nom + ", photo=" + photo + ", email=" + email + ", adresse=" + adresse + ", specialite=" + specialite + '}';
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
        final Medecin other = (Medecin) obj;
        return this.phone == other.phone;
    }
    
    
    
}
