package br.edu.unifebe.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.edu.unifebe.jdbc.Conexao;
import br.edu.unifebe.jdbc.IDao;
import br.edu.unifebe.modelo.Contato;
import br.edu.unifebe.modelo.Telefone;

public class TelefoneDao implements IDao<Telefone> {
	
	private Connection conexao = null;
	
	public TelefoneDao() throws SQLException {
		this.conexao = Conexao.getConnection();
	}

	@Override
	public void salvar(Telefone e) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Telefone e) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Telefone> listar() throws SQLException {
		throw new UnsupportedOperationException("Operação não disponível");
	}
	
	public List<Telefone> listar(Contato c) throws SQLException {
		return null;
	}

	@Override
	public Telefone detalhe(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
