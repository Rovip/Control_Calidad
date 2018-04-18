package com.excomer.control_calidad.data.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	/*private static Connection con;
	private static String strcon = "jdbc:postgresql://10.10.10.141:5433/RiverSoft"; 
	private static String us ="postgres"; 
	private static String passwd ="RiverSoft";
	private static String dri = "com.microsoft.sqlserver.jdbc.SQLServerDriver";*/
	
	private static Connection con;
	private static String strcon = "jdbc:postgresql://localhost:5434/Excomer"; 
	private static String us ="postgres"; 
	private static String passwd ="nelson";
	private static String dri = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	
	//Conectar
	
    public Connection  conectar(){
    try {
       Class.forName("org.postgresql.Driver");
       con = DriverManager.getConnection(strcon, us, passwd);
    } catch ( Exception e ) {
       System.err.println( e.getClass().getName()+": "+ e.getMessage() );
       System.exit(0);
    }
   return con;
 }
    
    public void close() throws SQLException {
    	con.close();
    }

}
