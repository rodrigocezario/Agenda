package br.edu.unifebe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifebe.exceptions.ContatoException;
import br.edu.unifebe.jdbc.Conexao;
import br.edu.unifebe.jdbc.IDao;
import br.edu.unifebe.modelo.Contato;
import br.edu.unifebe.modelo.Email;
import br.edu.unifebe.modelo.Telefone;
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
		EmailDao dao = new EmailDao();
		dao.salvar(email, contato);
	}
	
	public void adicionarEmail(List<Email> emails, Contato contato) {
		
	}

	@Override
	public void alterar(Contato e) throws SQLException {
		String sql = "update Contato set ContatoNome = ? where ContatoID = ?";
		PreparedStatement prmt = this.conexao.prepareStatement(sql);
		prmt.setString(1, e.getNome());
		prmt.setInt(2, e.getId());
		prmt.execute();	
	}

	@Override
	public void excluir(int id) throws SQLException {
		String sql = "delete Contato where ContatoID = ?";
		PreparedStatement prmt = this.conexao.prepareStatement(sql);
		prmt.setInt(1, id);
		prmt.execute();	
	}

	@Override
	public List<Contato> listar() throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Operação não disponível");
	}
	
	public List<Contato> listar(Usuario usuario) throws SQLException {
		String sql = "select * from Contato where UserID = ?";
		PreparedStatement prmt = this.conexao.prepareStatement(sql);
		prmt.setInt(1, usuario.getId());
		
		ResultSet rs = prmt.executeQuery();
		
		List<Contato> contatos = new ArrayList<>();
		
		while(rs.next()) {
			Contato c = new Contato();
			
			EmailDao emailDao = new EmailDao();
			for (Email email : emailDao.listar(c)) {
				c.addEmail(email);
			}
			
			TelefoneDao foneDao = new TelefoneDao();
			for (Telefone fone : foneDao.listar(c)) {
				c.addTelefone(fone);
			}
			
			contatos.add(c);
		}
		
		rs.close();
		prmt.close();
		
		return contatos;
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
			c.setNome(rs.getString("ContatoNome"));
			
			//add Usuario
			UsuarioDao usuarioDao = new UsuarioDao();
			c.setUsuario(usuarioDao.detalhe(rs.getInt("UserID")));
			
			//add Email
			EmailDao emailDao = new EmailDao();
			for (Email email : emailDao.listar(c)) {
				c.addEmail(email);
			}
			
			//add Telefone
			TelefoneDao foneDao = new TelefoneDao();
			for (Telefone fone : foneDao.listar(c)) {
				c.addTelefone(fone);
			}
			
			rs.close();
			prmt.close();
			return c;
		}else
			throw new ContatoException("Contato não encontrado.");
	}

}
