package br.edu.unifebe.view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import br.edu.unifebe.modelo.Usuario;

public class JFrmPrincipal extends JFrame {
	
	private Usuario usuario;
	
	public JFrmPrincipal(Usuario usuario) {
		super("Sistema de Contatos");
		this.usuario = usuario;
		
		//tem que alterar (estamos testando...)
		JLabel lb = new JLabel();
		lb.setText(usuario.getNome());
		this.getContentPane().add(lb);
		
		///fim do tem que alterar
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(500, 350);
		this.setLocationRelativeTo(null);
	}

}
