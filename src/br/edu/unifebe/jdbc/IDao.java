package br.edu.unifebe.jdbc;

import java.sql.SQLException;
import java.util.List;

public interface IDao<E> {
	
	//NORMALMENTE....
	//crud
	void salvar(E e) throws SQLException;
	void alterar(E e) throws SQLException;
	void excluir(int id) throws SQLException;
	List<E> listar() throws SQLException;
	E detalhe(int id) throws SQLException;

}
