/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.pi.services;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Nasreddine
 */
public interface IServiceCRUD <object>
{
    void  add(object t)          throws SQLException; 
    void  update(object t,int id)throws SQLException;
    void  delete (int t)         throws SQLException;
    List <object> show ()        throws SQLException; 
}
