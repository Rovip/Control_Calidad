package data.conection;

import com.excomer.control_calidad.data.connection.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Persistence {
	 private int res;
	 private Conexion con;
	 private Connection c;
	 private Statement stmt = null;
	 private ResultSet rs = null;
	    
	 public ResultSet consult(String query) {
	            try
	            {
	                con = new Conexion();
	                c = con.conectar();
	                if (c != null)
	                {
	                    stmt = c.createStatement();
	                    rs = stmt.executeQuery(query);
	                    c.close();
	                }
	            }
	            catch (Exception exc)
	            {
	                System.err.println("Error:" + exc);  
	            }
	            return rs;
	        }
	 
	 public void persist(String query) {
		 try
         {
             con = new Conexion();
             c = con.conectar();
             
             if (c != null)
             {
            	 c.setAutoCommit(false);
                 stmt = c.createStatement();
                 stmt.executeUpdate(query);
                
               
               c.commit();
               c.close();
             }
         }
         catch (Exception exc)
         {
             JOptionPane.showMessageDialog(null, "Error" + exc);  
         }
		 
	
         
	 }

}
