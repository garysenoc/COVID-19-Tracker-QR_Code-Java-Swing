/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectcovidtracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

/**
 *
 * @author Gary Senoc
 */
public class DBHelper {
    Connection con  = null;
    Statement stmt = null;
    
    public void connectDB() throws Exception{
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/db_covid","root","root");
        System.out.print("ok");
                
    }
    
    
    //Start  Insert DATA
    public boolean insertRecord( int idnum, String fname,String lname, String phone, String address){
    boolean flag = false;
        
        try{
        stmt = con.createStatement();
        String sql = "Insert into tblUsers values ("+idnum + ", '" + fname + "','"+ lname + "','"+ phone + "','" + address + "')";
            if(stmt.executeUpdate(sql)==1)
                 flag = true;
            
        }catch(SQLException ex){
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE,null,ex);
        }
        return flag;
    }
    // End Insert DATA
    
    
       public ResultSet displayAllRecords(){
        ResultSet rs = null;
         try {
             stmt = con.createStatement();
             String sql = "Select * from tblUsers";
              rs = stmt.executeQuery(sql);
         } catch (SQLException ex) {
             Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
         }
         return rs;
    }
       
        public ResultSet displayAllLogs(){
        ResultSet rs = null;
         try {
             stmt = con.createStatement();
             String sql = "Select * from tbllogs";
              rs = stmt.executeQuery(sql);
         } catch (SQLException ex) {
             Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
         }
         return rs;
    }
        
         public ResultSet displayAllLogsSpecific(String keywords){
        ResultSet rs = null;
         try {
             stmt = con.createStatement();
             String sql = "Select * from tbllogs where fullname like '%" + keywords + "%' or date like '%" + keywords + "%'";
              rs = stmt.executeQuery(sql);
         } catch (SQLException ex) {
             Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
         }
         return rs;
    }
       
       
       
     public ResultSet getLogin(){
        ResultSet rs = null;
         try {
             stmt = con.createStatement();
             String sql = "Select * from tbladmin";
              rs = stmt.executeQuery(sql);
         } catch (SQLException ex) {
             Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
         }
         return rs;
    } 
       
       
       
       
       
          
    //Start  Insert DATA
    public boolean updateRecord( int idnum, String fname,String lname, String phone, String address){
    boolean flag = false;
        
        try{
        stmt = con.createStatement();
        String sql = "Update  tblUsers set firstname = '" + fname + "', lastname = '" +lname + "',phone_number = '"+  phone +"', address = '" + address + "' where id = " + idnum;
            if(stmt.executeUpdate(sql)==1)
                 flag = true;
            
        }catch(SQLException ex){
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE,null,ex);
        }
        return flag;
    }
    // End Insert DATA
       
       public boolean deleteRecord(int idn){
        boolean flag = false;
        
        try{
        stmt = con.createStatement();
        String sql = "DELETE FROM tblUsers where id = " + idn;
            if(stmt.executeUpdate(sql)==1)
                 flag = true;
            
        }catch(SQLException ex){
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE,null,ex);
        }
        return flag;
   }
       
       
       
       
       
     public ResultSet searchKeyword(String keyword){
        ResultSet rs = null;
         try {
             stmt = con.createStatement();
             String sql = "Select * from tblUsers where firstname like '%" + keyword + "%' or lastname like '%"+ keyword  + "%' or phone_number like '%" + keyword + "%' or address like '%" + keyword + "%'";
              rs = stmt.executeQuery(sql);
         } catch (SQLException ex) {
             Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
         }
         return rs;
    }
       
     
     
   public boolean insertLog(String fullname){
    boolean flag = false;
        
    
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
        try{
        stmt = con.createStatement();
        String sql = "Insert into tbllogs values ('"+fullname + "','" +dtf.format(now) + "')";
            if(stmt.executeUpdate(sql)==1)
                 flag = true;
            
        }catch(SQLException ex){
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE,null,ex);
        }
        return flag;
    }
   
   
   
   
   
   
   
   
   
   
   
   
   
     
        public ResultSet displayByID(int idn){
        ResultSet rs = null;
         try {
             stmt = con.createStatement();
                        String sql = "Select * from tblUsers where id = " + idn ;
              rs = stmt.executeQuery(sql);
         } catch (SQLException ex) {
             Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
         }
         return rs;
    }
        
        
        
        
            public boolean updatePassword(String password){
    boolean flag = false;
        
        try{
        stmt = con.createStatement();
        String sql = "Update  tbladmin set password = '" + password +"'";
            if(stmt.executeUpdate(sql)==1)
                 flag = true;
            
        }catch(SQLException ex){
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE,null,ex);
        }
        return flag;
    }
    
}
