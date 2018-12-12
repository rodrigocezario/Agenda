package br.edu.unifebe.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.edu.unifebe.dao.UsuarioDao;
import br.edu.unifebe.modelo.Usuario;

public class JFrmLogin extends JFrame implements ActionListener {
	
	//componentes da nossa janela
	private JLabel lbLogin, lbSenha;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JButton btnCancel, btnOk;
	
	public JFrmLogin() {
		//inicialização dos componentes
		this.lbLogin = new JLabel("Login:");
		this.lbSenha = new JLabel("Senha:");
		
		this.txtLogin = new JTextField(18);
		this.txtSenha = new JPasswordField(18);
		
		this.btnCancel = new JButton("Cancelar");
		this.btnOk = new JButton("Logar");
		
		this.btnOk.addActionListener(this);
		
		
		//container intermediario
		JPanel pnlLogin = new JPanel();
		pnlLogin.add(lbLogin);
		pnlLogin.add(txtLogin);
		pnlLogin.add(lbSenha);
		pnlLogin.add(txtSenha);
		pnlLogin.add(btnCancel);
		pnlLogin.add(btnOk);
		
		this.getContentPane().add(pnlLogin);
		
		//tratamentos da janela (aparencia)
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(300, 125);
		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		if (b.getText().equals("Logar")) {
			try {
				UsuarioDao dao = new UsuarioDao();
				
				String login = this.txtLogin.getText();
				String senha = String.valueOf(this.txtSenha.getPassword());
				
				Usuario usuario = dao.logar(login, senha);
				
				JFrmPrincipal principal = new JFrmPrincipal(usuario);//exibi a tela principal
				this.setVisible(false);//oculto a tela de login
			
				//System.out.println("logou....");
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, e2.getMessage(), "Erro", 
						JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

}
