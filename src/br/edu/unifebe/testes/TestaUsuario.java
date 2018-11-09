package br.edu.unifebe.testes;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.edu.unifebe.dao.UsuarioDao;
import br.edu.unifebe.modelo.Usuario;

public class TestaUsuario {

	public static void main(String[] args) {
		
		//String nome;
		//nome = janelinha("Informe o seu nome:");
		
		int escolha = Integer.parseInt(
				janelinha("Digite 1 para adicionar usuário"));
		
		if (escolha == 1) {
			Usuario usuario = new Usuario();
			usuario.setNome(janelinha("Informe o seu nome:"));
			usuario.setEmail(janelinha("Informe o email:"));
			usuario.setSenha(janelinha("Digite uma senha:"));
			usuario.setLogin(janelinha("Informe o login: "));
			
			try {
				UsuarioDao dao = new UsuarioDao();
				dao.salvar(usuario);
				System.out.println("Usuário salvo com sucesso!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//imprimir os registros de usuário
		
		try {
			
			UsuarioDao dao = new UsuarioDao();
			
			System.out.println(" ==== USUÁRIOS ==== ");
			//forEach  delicia para iteração em coleções
			for(Usuario usuario : dao.listar()) {
				System.out.println("ID: "+ usuario.getId() + 
						"\tNome: "+ usuario.getNome() + 
						"\tLogin: "+ usuario.getLogin());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	public static String janelinha(String texto) {
		return JOptionPane.showInputDialog(texto);
	}

}
