package br.edu.unifebe.modelo;

import java.util.ArrayList;
import java.util.List;

public class Contato {
	
	private int id;
	private String nome;
	private Usuario usuario;
	private List<Email> emails;
	private List<Telefone> telefones;
	
	//solução para o ContatoDao.detalhe(int id);
	public Contato(){
		this.emails = new ArrayList<>();
		this.telefones= new ArrayList<>();		
	}
	
	
	public Contato(Usuario usuario) {
		this.usuario = usuario;
		this.emails = new ArrayList<>();
		this.telefones= new ArrayList<>();
	}
	
	public void addEmail(Email email) {
		this.emails.add(email);
	}
	
	public void addTelefone(Telefone telefone) {
		this.telefones.add(telefone);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Usuario getUsuario() {
		return usuario;
	}

	public List<Email> getEmails() {
		return emails;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}

}
