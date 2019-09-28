package usandojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class Driver_sexto {

	public static void main(String[] args) throws SQLException {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
				
		
		try {
			// 1. Conectar-se à DB
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			
			//2. preparar um statement
			myStmt = (PreparedStatement) myConn.prepareStatement("select * from employees where salary >? and posicao=?");
			
			//3. Set parameters
			myStmt.setDouble(1, 800);
			myStmt.setString(2, "ataque");
			
			//4. Executando uma query SQL
			myRs = myStmt.executeQuery();
			
			//5. Display the result set
			display(myRs);
		
			
		}	
		
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}