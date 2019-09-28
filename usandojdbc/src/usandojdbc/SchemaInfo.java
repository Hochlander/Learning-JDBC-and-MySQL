package usandojdbc;

import java.io.File;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.PreparedStatement;

public class SchemaInfo {

	public static void main(String[] args) throws Exception {
		
		String catalog = null;
		String schemaPattern = null;
		String tableNamePattern = null;
		String columnNamePattern = null;
		String [] types = null;
		
		Connection myConn = null;
		ResultSet myRs	= null;
				
		
		try {
			//  1. Conectar-se à DB
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
			
			//2. pegando metadados
			DatabaseMetaData databaseMetaData = myConn.getMetaData();
			
			//3. pegando uma lista de tabelas
			
			System.out.println("lista de tabelas");
			System.out.println("________________________");
			
			myRs = databaseMetaData.getTables(catalog, schemaPattern, tableNamePattern, types);
			
			while(myRs.next()) {
				System.out.println(myRs.getString("TABLE_NAME"));
			}
			
			//4. CRIAR A LISTA DE COLUNAS
		System.out.println("\n\n Lista de colunas");
		System.out.println("________________________");
			
		
		}	
		
		catch (Exception exc) {
			exc.printStackTrace();
		} finally{
			close(myConn, null, myRs);
		}

}

	private static void close(Connection myConn, java.sql.PreparedStatement myStmt, Object object) {
		// TODO Auto-generated method stub
		
	}

}


