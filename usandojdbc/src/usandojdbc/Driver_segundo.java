// aula #3 insert data into a database

package usandojdbc;

import java.sql.*;

public class Driver_segundo {

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
			String sql = "insert into employees" +
			"(last_name, first_name, email)" +
			"values ('Patrik', 'Cavalo', 'patrik.cavalo@fertog.com')"; 
			
			myStmt.executeUpdate(sql);
			
			System.out.println("Insert complete");
			
		}	
		
		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}