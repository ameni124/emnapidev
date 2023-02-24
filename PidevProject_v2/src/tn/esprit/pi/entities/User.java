/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.pi.entities;


public class User {
    private int idUser;
    private String firstname;
    private String lastname;
    private String speciality;
    private String role;

    public User(int idUser, String firstname, String lastname, String speciality, String role) {
        this.idUser = idUser;
        this.firstname = firstname;
        this.lastname = lastname;
        this.speciality = speciality;
        this.role = role;
    }

    public User(String firstname, String lastname, String speciality, String role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.speciality = speciality;
        this.role = role;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "user{" + "idUser=" + idUser + ", firstname=" + firstname + ", lastname=" + lastname + ", speciality=" + speciality + ", role=" + role + '}';
    }
    
    
    
    
}
