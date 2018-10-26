package br.edu.unifebe.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.rowset.spi.TransactionalWriter;

public class Conexao {
	
	//implementação de Singleton
	
	private static Connection conexao;
	
	private Conexao() {
		// TODO Auto-generated constructor stub
	}
	
	//getInstance() - método estático
	
	public static Connection getConnection() throws SQLException{
		if (conexao == null) {
			//cria a conexao
			DriverManager.registerDriver(new org.sqlite.JDBC());
			conexao = DriverManager.getConnection("jdbc:sqlite:agenda.db");
		}
		
		return conexao; 
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Exception("Não se pode fazer clone de um singleton...");
	}

}
