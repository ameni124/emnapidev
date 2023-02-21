/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.pi.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nasreddine
 */
public class MyConnection {
    // BD Credentials
    final static String URL= "jdbc:mysql://localhost:3306/amenidb";
    final static String USERNAME="root";
    final static String PWD="";
    //att
    private Connection cnx;
    
    //Singleton #1
    static MyConnection instance=null;
    //constructor
    //Singleton #2

    private MyConnection() {
       
        try {
            cnx= (Connection) DriverManager.getConnection(URL,USERNAME,PWD);
            System.out.println("Connexion etablie avec Succes");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
    //getters & setters

    public Connection getCnx() {
        return cnx;
    }
    
    //Singleton #3
    public static MyConnection getInstance() {
        if(instance==null){
            instance=new MyConnection();
        }
        return instance;
    }
    

}
