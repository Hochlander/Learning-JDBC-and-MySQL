// aula 2 conectando uma BD MySQL no Java

package usandojdbc;

import java.sql.*;

public class Driver {

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
			ResultSet myRs = myStmt.executeQuery("select * from employees");
			
			//4. Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
			}
			
		}
		
		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
