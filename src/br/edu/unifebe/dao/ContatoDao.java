package br.edu.unifebe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.unifebe.exceptions.ContatoException;
import br.edu.unifebe.jdbc.Conexao;
import br.edu.unifebe.jdbc.IDao;
import br.edu.unifebe.modelo.Contato;
import br.edu.unifebe.modelo.Email;
import br.edu.unifebe.modelo.Usuario;

public class ContatoDao implements IDao<Contato> {
	
	private Connection conexao = null;
	
	public ContatoDao() throws SQLException {
		this.conexao = Conexao.getConnection();
	}

	@Override
	public void salvar(Contato e) throws SQLException {
		String sql = "insert into Contato (ContatoNome, UserID) values (? , ?)";
		PreparedStatement prmt = this.conexao.prepareStatement(sql);
		prmt.setString(1, e.getNome());
		prmt.setInt(2, e.getUsuario().getId());
		prmt.execute();
	}
	
	public void adicionarEmail(Email email, Contato contato) throws SQLException {
		//String sql = "insert into Email (EmailEnd, ContatoID) values (?,?)";
		EmailDao dao = new EmailDao();
		dao.salvar(email, contato);
	}
	
	public void adicionarEmail(List<Email> emails) {
		
	}
	
	

	@Override
	public void alterar(Contato e) throws SQLException {
		String sql = "update Contato set ContatoNome = ? where ContatoID = ?";
		
		
	}

	@Override
	public void excluir(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Contato> listar() throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Operação não disponível");
	}
	
	public List<Contato> listar(Usuario usuario) throws SQLException {
		
		return null;
	}

	@Override
	public Contato detalhe(int id) throws SQLException {
		String sql = "select * from Contato where ContatoID = ?";
		PreparedStatement prmt = this.conexao.prepareStatement(sql);
		prmt.setInt(1, id);
		ResultSet rs = prmt.executeQuery();
		Contato c = null;
		if (rs.next()) {
			c = new Contato();
			//set as informações
			
			//add Email
			
			EmailDao emailDao = new EmailDao();
			for (Email email : emailDao.listar(c)) {
				c.addEmail(email);
			}
			
			//add Telefone
			
			return c;
		}else
			throw new ContatoException("Contato não encontrado.");
	}

}
