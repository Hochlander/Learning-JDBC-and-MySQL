package usandojdbc;


import java.util.Scanner;
import java.sql.*;

public class TransactionDemo {
	public static void main (String[] args) {
		
		Connection myConn = null;
		Statement myStmt = null;
		
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			
		// Desligar autocommit
			myConn.setAutoCommit(false);
			
			// primeiro passo da transação: deletar todos os jogadores de defesa
			myStmt = myConn.createStatement();
			myStmt.executeUpdate("delete from employees where posicao = 'defesa'");
			
			// transação 2: subir para 5000 o salário de todos os do ataque
			myStmt.executeUpdate("update employees set salary=5000 where posicao='ataque'");
			
			System.out.println("\n>> etapas da transição estão completas\n");
			
			// perguntar ao usuário se pode salvar alterações
			boolean ok = askUserIfOkToSave();
			
			if (ok) {
				// guardar na DB
				myConn.commit();
				System.out.println("\n>> Transação COMPLETA\n");
			}else{ 
				// descatar
				myConn.rollback();
				System.out.println("\n>> Transação ABORTADA\n");
			}
			}
				
				catch (Exception exc) {
					exc.printStackTrace();
				} finally{
					close(myConn, myStmt, null);
				
			}
		}
	

	private static void close(Connection myConn, Statement myStmt, Object object) {
		// TODO Auto-generated method stub
		
	}

	private static boolean askUserIfOkToSave() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
