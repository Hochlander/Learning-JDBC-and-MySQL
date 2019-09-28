// aula #4, Atualizando dados na DB

package usandojdbc;

import java.sql.*;

public class Driver_quarto {

	public static void main(String[] args) {
		
		String url =  "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String password = "root";
				
		
		try {
			// 1. Conectar-se à DB
			Connection myConn = DriverManager.getConnection(url, user, password);
			
			//2. Criar um statement
			Statement myStmt = myConn.createStatement();
			
			//3. Executar uma SQL query
			String sql = "delete from employees where last_name = 'Patrik'";
			
			int rowsAffected = myStmt.executeUpdate(sql);
			
			System.out.println("Rows affected: "+ rowsAffected);
					
			System.out.println("Delete complete");
			
		}	
		
		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
