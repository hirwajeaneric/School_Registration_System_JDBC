/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Users;
import utils.ConnectionToDatabase;
import view.UserForm;

/**
 *
 * @author hirwa
 */
public class UserDao extends ConnectionToDatabase {
    
    byte[] person_image;
    FileInputStream fileinputstream;
        
    public void save(Users users){
        try {
            getConnection();
            
            //The next lines are where we are going to recieve the image file 
            //choosen from the form and convert it into bytes that can be sent 
            //and successfuly be saved in the database.
            try {
                fileinputstream = new FileInputStream(users.getImage());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[2048];
            try {
                for(int readNum; (readNum = fileinputstream.read(buf))!=-1;){
                    bos.write(buf,0,readNum);
                }
            } catch (IOException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            person_image = bos.toByteArray();

            //Now, we are going to Insert all data into the database.
            
            String sqlQuerry = "INSERT INTO schoolUsers VALUES (?,?,?,?,?,?)";
            
            ps = con.prepareStatement(sqlQuerry);
            
            ps.setString(1, users.getFirstName());
            ps.setString(2, users.getLastName());
            ps.setString(3, users.getPhoneNumber());
            ps.setString(4, users.getDateOfBirth());
            ps.setString(5, users.getRegistrantType());
            ps.setBytes(6, person_image);
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            getDisconnection();
        }
    }
    
    public void update(Users users){
        try {
            getConnection();
     
            //The next lines are where we are going to recieve the image file 
            //choosen from the form and convert it into bytes that can be sent 
            //and successfuly be saved in the database.
            try {
                fileinputstream = new FileInputStream(users.getImage());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[2048];
            try {
                for(int readNum; (readNum = fileinputstream.read(buf))!=-1;){
                    bos.write(buf,0,readNum);
                }
            } catch (IOException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            person_image = bos.toByteArray();
            
            //Sending data into the database using the querry.
            
            String updateQuerry = "UPDATE schoolUsers SET firstName=?, lastName=?, phoneNumber=?, dateOfBirth=?, registrantType=?, image=? WHERE phoneNumber=?";
            
            ps = con.prepareStatement(updateQuerry);
            
            ps.setString(1, users.getFirstName());
            ps.setString(2, users.getLastName());
            ps.setString(3, users.getPhoneNumber());
            ps.setString(4, users.getDateOfBirth());
            ps.setString(5, users.getRegistrantType());
            ps.setBytes(6, person_image);
            UserForm userform = new UserForm();
            String SelectedPhone = userform.selectedPhoneNumber;
            ps.setString(7, SelectedPhone);
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            getDisconnection();
        }
    }
}
