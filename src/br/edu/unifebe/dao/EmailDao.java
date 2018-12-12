package br.edu.unifebe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.edu.unifebe.jdbc.Conexao;
import br.edu.unifebe.jdbc.IDao;
import br.edu.unifebe.modelo.Contato;
import br.edu.unifebe.modelo.Email;

public class EmailDao implements IDao<Email> {
	
	private Connection conexao = null;
	
	public EmailDao() throws SQLException {
		this.conexao = Conexao.getConnection();
	}

	@Override
	public void salvar(Email e) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Operação não disponível");
	}
	
	public void salvar(Email e, Contato c) throws SQLException{
		String sql = "insert into Email (EmailEnd, ContatoID) values (?, ?)";
		PreparedStatement prmt = this.conexao.prepareStatement(sql);
		prmt.setString(1, e.getEmail());
		prmt.setInt(2, c.getId());
		prmt.execute();
	}

	@Override
	public void alterar(Email e) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Email> listar() throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Operação não disponível");
	}
	
	public List<Email> listar(Contato c) throws SQLException {
		return null;
	}

	@Override
	public Email detalhe(int id) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Operação não disponível");
	}
	
	

}
