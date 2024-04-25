package factory;

import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionFactory {

	//NOME USUARIO DB
	private static final String USERNAME = "root";
	
	//SENHA USUARIO DB
	private static  final String PASSWORD = "";
	
	//CAMINHO DB
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/projeto_java_db";
	
	//CONECCAO COM DB
			
	public static Connection createConnectionToMySQL() throws Exception {
		//FAZ COM QUE A CLASSE SEJA CARREGADA PELA JVM
		Class.forName("com.mysql.jdbc.Driver");
		
		//CRIA CONEXAO COM DB
		Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
		
		return connection;
	}
	
	public static void main(String[]args) throws Exception {
		//RECUPERAR CONEXAO COM DB
		Connection con = createConnectionToMySQL();
		//TESTAR
		if(con!=null) {
			System.out.println("Conexão obtida");
			con.close();
		}
		
	}
	
	
}
