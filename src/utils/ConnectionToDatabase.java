/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hirwa
 */
public class ConnectionToDatabase {
    public Connection con = null;
    public PreparedStatement ps = null;
    public Statement s = null;
    public ResultSet rs = null;
    
    public void getConnection(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaProjects?","root","");
            System.out.println("Connected!!\n");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionToDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getDisconnection(){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionToDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionToDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionToDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(s!=null){
            try {
                s.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionToDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("\nDisconnected!!\n");
    }
}
