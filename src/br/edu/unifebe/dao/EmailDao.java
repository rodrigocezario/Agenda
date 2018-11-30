package br.edu.unifebe.dao;

import java.sql.SQLException;
import java.util.List;

import br.edu.unifebe.jdbc.IDao;
import br.edu.unifebe.modelo.Contato;
import br.edu.unifebe.modelo.Email;

public class EmailDao implements IDao<Email> {

	@Override
	public void salvar(Email e) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Operação não disponível");
	}
	
	public void salvar(Email e, Contato c) throws SQLException{
		
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
