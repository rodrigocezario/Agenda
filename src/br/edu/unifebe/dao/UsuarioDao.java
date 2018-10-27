package br.edu.unifebe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> listar() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario detalhe(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
