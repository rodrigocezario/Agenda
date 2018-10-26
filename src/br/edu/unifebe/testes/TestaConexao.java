package br.edu.unifebe.testes;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.unifebe.jdbc.Conexao;

public class TestaConexao {

	public static void main(String[] args) {
		
		try {
			Connection conexao1 = Conexao.getConnection();
			System.out.println("Conectado com Singleton....");
			
			System.out.println("Conexao1: "+ conexao1.toString());
			
			Connection conexao2 = Conexao.getConnection();
			System.out.println("Conexao2: "+ conexao2.toString());
			
		} catch (SQLException e) {
			System.out.println("Erro: "+ e.getMessage());
		}
		
	}

}
