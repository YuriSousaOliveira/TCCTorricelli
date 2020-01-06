import java.sql.*;

import javax.swing.JOptionPane;

public class Banco{
	
	public void conexao(){
	 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con;
			con=DriverManager.getConnection("jdbc:mysql://localhost:1433/bancoteste", "sa","123");
			System.out.println("conectou");
			
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());} catch (SQLException e) {
			e.printStackTrace();
		}
	
	
	
	
	
}
}





