package usandojdbc;


import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.PreparedStatement;

public class WriteBlobDemo {

	public static void main(String[] args) throws Exception {
		
		Connection myConn = null;
		java.sql.PreparedStatement myStmt = null;
		FileInputStream input	= null;
				
		
		try {
			//  Conectar-se à DB
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			
			// Prepare Staement
			String sql = "update employees set resume=? where email='mago@valdivia.com'";
			myStmt=myConn.prepareStatement(sql);
			
			// Estabelecendo parâmetro para o nome do arquivo de curriculo (resume0
			File theFile= new File("myResume.pdf");
			input = new FileInputStream(theFile);
			myStmt.setBinaryStream(1, input);
			
			System.out.println("Lendo arquivo addiciondo" + theFile.getAbsolutePath());
			
			// Executando statement
			myStmt.executeUpdate();
			System.out.println("feito com sucesso");
					
			
		}	
		
		catch (Exception exc) {
			exc.printStackTrace();
		} finally{
			close(myConn, myStmt, null);
		}

}

	private static void close(Connection myConn, java.sql.PreparedStatement myStmt, Object object) {
		// TODO Auto-generated method stub
		
	}

}

