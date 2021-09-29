/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demokenil;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author kenil
 */
public class Demokenil {

    Connection conn=null;
    PreparedStatement pst=null;
    
    
       public static Connection connectdb()
    {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con=DriverManager.getConnection("jdbc:sqlite:userinfo.db");
            System.err.println("system connected");
            return con;
            
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    
    }
    public static void main(String[] args) {
         
                Connection conn=null;
                PreparedStatement pst=null;
                ResultSet ra=null;
    
            conn=Demokenil.connectdb();
             
             String sql1 ="SELECT * FROM userinfo WHERE ID=1";
              try {
                

                  pst=conn.prepareStatement(sql1); 
                  ra=pst.executeQuery();
                  
                 String km=ra.getString("ID");
                    
                  System.err.println(km);
                  if(km.matches("1"))
                  {
                      
                      page3 kd=new page3();
                      kd.setVisible(true);
                  }
                  
            
                 ra.close();
                  pst.close();
              } catch (HeadlessException | SQLException e)
              {
                    
                        login ksx=new login();
                        ksx.setVisible(true);
              }finally{
                try {
                    pst.close();
                    ra.close();
                } catch (Exception e) {
                }
        
        
              }}
    
    
}
