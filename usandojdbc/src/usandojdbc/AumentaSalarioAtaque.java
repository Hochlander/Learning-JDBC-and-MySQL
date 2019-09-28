// aula 7: Stored procedures

package usandojdbc;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import com.mysql.jdbc.PreparedStatement;

	public class AumentaSalarioAtaque {

		public static void main(String[] args) throws SQLException {
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
					
			
			try {
				//  Conectar-se à DB
				myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
				
				String posicao = "ataque";
				int TamanhoAumento = 200;
				
				// Mostrar salários antes 
				System.out.println("\n Salários antes \n");
				showSalaries (myConn, posicao);
				
				//Prearar chamada de Stored Procedure
				myStmt=myConn.prepareCall("{call aumenta_salario_ataque(?,?)}");
				
				// estabelecendo parâmetros
				myStmt.setString(1, posicao);
				myStmt.setDouble(2, TamanhoAumento);
				
				//chamando Stored procedure
				System.out.println("\n \n Chamando Stored Procedure aumenta_salario_ataque");
				myStmt.execute();
				System.out.println("terminada a chamada do stored procedure");
						
				// mostrando salarios depois
				System.out.println("\n Salários depois \n");
				showSalaries (myConn, posicao);
					
				
			}	
			
			catch (Exception exc) {
				exc.printStackTrace();
			} finally{
				close(myConn, myStmt, null);
			}

	}

}
