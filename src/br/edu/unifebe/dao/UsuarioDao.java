package br.edu.unifebe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.unifebe.exceptions.UsuarioException;
import br.edu.unifebe.jdbc.Conexao;
import br.edu.unifebe.jdbc.IDao;
import br.edu.unifebe.modelo.Usuario;

public class UsuarioDao implements IDao<Usuario> {
	
	private Connection conexao = null;
	
	public UsuarioDao() throws SQLException {
		this.conexao = Conexao.getConnection();
	}

	@Override
	public void salvar(Usuario e) throws SQLException {
		String sql = "Insert into Usuario (UserNome, UserEmail, UserLogin, "
				+ "UserSenha) values (?, ?, ?, ?)";
		PreparedStatement prmt = this.conexao.prepareStatement(sql);
		prmt.setString(1, e.getNome());
		prmt.setString(2, e.getEmail());
		prmt.setString(3, e.getLogin());
		prmt.setString(4, e.getSenha());
		
		prmt.execute();
	}

	@Override
	public void alterar(Usuario e) throws SQLException {
		String sql = "update Usuario set UserNome = ?, UserLogin = ?, "
				+ "UserEmail = ?, UserSenha = ? where UserID = ?";
		PreparedStatement prmt = this.conexao.prepareStatement(sql);
		prmt.setString(1, e.getNome());
		prmt.setString(2, e.getLogin());
		prmt.setString(3, e.getEmail());
		prmt.setString(4, e.getSenha());
		prmt.setInt(5, e.getId());
		
		prmt.execute();
	}

	@Override
	public void excluir(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> listar() throws SQLException {
		String sql = "select * from Usuario";
		PreparedStatement prmt = this.conexao.prepareStatement(sql);
		ResultSet rs = prmt.executeQuery();
		
		List<Usuario> lista = new ArrayList<>();
		
		while(rs.next()) {
			//vou adicionar na lista (Usuario)...
			Usuario usuario = new Usuario();
			
			usuario.setId(rs.getInt("UserID"));
			usuario.setNome(rs.getString("UserNome"));
			usuario.setEmail(rs.getString("UserEmail"));
			usuario.setLogin(rs.getString("UserLogin"));
			usuario.setSenha(rs.getString("UserSenha"));
			
			lista.add(usuario);
			
		}
		rs.close(); //liberar da memoria
		prmt.close();
		
		return lista;
	}

	@Override
	public Usuario detalhe(int id) throws SQLException {
		String sql = "Select * from Usuario where UserID = ?";
		PreparedStatement prmt = this.conexao.prepareStatement(sql);
		prmt.setInt(1, id);
		ResultSet rs = prmt.executeQuery();
		
		Usuario usuario = null;
		
		if (rs.next()) {
			
			usuario = new Usuario();
			
			usuario.setId(rs.getInt("UserID"));
			usuario.setNome(rs.getString("UserNome"));
			usuario.setEmail(rs.getString("UserEmail"));
			usuario.setLogin(rs.getString("UserLogin"));
			usuario.setSenha(rs.getString("UserSenha"));
			
		} else {
			throw new UsuarioException("Usuario não encontrado");
		}
		
		return usuario;
	}
	
	public Usuario logar(String login, String senha) throws SQLException {
		String sql = "Select * from Usuario where UserLogin = ? "
				+ "and UserSenha = ?";
		PreparedStatement prmt = this.conexao.prepareStatement(sql);
		prmt.setString(1, login);
		prmt.setString(2, senha);
		
		ResultSet rs = prmt.executeQuery();
		
		Usuario usuario = null;
		
		if (rs.next()) {
			usuario = new Usuario();
		
			usuario.setId(rs.getInt("UserID"));
			usuario.setNome(rs.getString("UserNome"));
			usuario.setEmail(rs.getString("UserEmail"));
			usuario.setLogin(rs.getString("UserLogin"));
			usuario.setSenha(rs.getString("UserSenha"));
		} else {
			throw new UsuarioException("Login ou senha incorreta!");
		}
		
		return usuario;
	}
	

}
