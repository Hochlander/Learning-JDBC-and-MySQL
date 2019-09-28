package usandojdbc;



import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReadClobDemo {

	public static void main(String[] args) throws Exception {
		
		Connection myConn = null;
		java.sql.PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		Reader input = null;
		FileWriter output = null;
				
		
		try {
			//  Conectar-se à DB
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			
			// Executando Statement
			myStmt = (PreparedStatement) myConn.createStatement();
			String sql = ("select resume from employees where email = 'mago@valdivia.com'");
			myRs = myStmt.executeQuery(sql);
			
			// Estabelecendo parâmetro para o nome do arquivo de curriculo (resume0
			File theFile= new File("CurriculoDoMago.docx");
			output = new FileWriter(theFile);
			
			if (myRs.next()) {
				
				input = myRs.getCharacterStream("resume");
				System.out.println("Lendo currículo da base de dados");
				System.out.println(sql);
				
				int theChar;
				while ((theChar = input.read())>0) {
					output.write(theChar);
				}
			}
				
			
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

