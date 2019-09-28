package usandojdbc;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class WriteClobDemo {

	public static void main(String[] args) throws Exception {
		
		Connection myConn = null;
		java.sql.PreparedStatement myStmt = null;
		FileReader input = null;
				
		
		try {
			//  Conectar-se à DB
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			
			// Prepare Staement
			String sql = "update employees set curriculo=? where email='mago@valdivia.com'";
			myStmt=myConn.prepareStatement(sql);
			
			// Estabelecendo parâmetro para o nome do arquivo de curriculo (resume0
			File theFile= new File("C:\\Users\\Lenovo G40\\Documents\\nota luthero 23072019.docx");
			input = new FileReader(theFile);
			myStmt.setCharacterStream(1, input);
				
			System.out.println("Lendo arquivo addiciondo" + theFile.getAbsolutePath());
			
			// Executando statement
			System.out.println("\n guardando curriculo na base de dados: " + theFile);
			System.out.println(sql);
			
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

