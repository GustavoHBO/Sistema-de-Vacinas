/**
 * Classe controller responsável pelo gerenciamento e controle da aplicação.
 * 
 * @author Gustavo Henrique
 * @since 20/02/2017
 * 
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import model.Categoria;
import model.Pessoa;

public class Controller {

	private static Controller controller = new Controller();
	private ArrayList<Pessoa> listaPessoas = null;
	private ArrayList<Categoria> listaCategorias = null;
	
	/*______________________________________________________________________________________________________________________________________*/
	
	/**
	 * Controller privado para utilização do singleton
	 */
	private Controller() {
		listaPessoas = new ArrayList<Pessoa>();
		listaCategorias = new ArrayList<Categoria>();
	}
	
	/*______________________________________________________________________________________________________________________________________*/
	
	/**
	 * Retorna a instancia existente do controller
	 * @return controller
	 */
	public static Controller getInstance() {
		if(controller == null)
			controller = new Controller();
		return controller;
	}
	
	/*______________________________________________________________________________________________________________________________________*/	
	
	/**
	 * Zera a instancia existente do controller
	 */
	public void zerarSingleton() {
		controller = new Controller();
	}
	
	/*______________________________________________________________________________________________________________________________________*/
	
	/**
	 * Adiciona uma categoria e retorna a categoria adicionada.
	 * @param nomeCategoria - Nome da categoria a ser adicionada.
	 * @return categoria - Categoria adicionada.
	 */
	public Categoria adicionarCategoria(String nomeCategoria) {
		Categoria categoria = new Categoria(nomeCategoria);
		listaCategorias.add(categoria);
		return categoria;
	}
	
	/*______________________________________________________________________________________________________________________________________*/
	
	/**
	 * Remove e retorna a categoria.
	 * @param nomeCategoria - Nome da categoria a ser removida.
	 * @return null, caso não encontre a categoria, ou, categoria caso encontre.
	 */
	public Categoria removerCategoria(String nomeCategoria) {
		Categoria categoria = null;
		Iterator<Categoria> it = listaCategorias.iterator();
		while(it.hasNext()) {
			categoria = it.next();
			if(categoria.getNomeCategoria().equals(nomeCategoria)) {
				listaCategorias.remove(categoria);
				return categoria;
			}
		}
		return null;
	}
	
	/*______________________________________________________________________________________________________________________________________*/
	
	/**
	 * Adiciona e retorna a pessoa inserida.
	 * @param nome - Nome da pessoa a ser adicionada.
	 * @param cpf - CPF da pessoa a ser adicionada.
	 * @param cidade - Cidade da pessoa a ser adicionada.
	 * @param dataNascimento - Data de nascimento da pessoa.
	 */
	public Pessoa adicionarPessoa(String nome, String cpf, String cidade, boolean sexo, Date dataDeNascimento, int quantVacinas, Categoria categoria) {
		Pessoa pessoa = null;
		
		if(nome.trim().equals(null) || cpf.trim().equals(null) || ) {
			return null;
		}
		
		
		pessoa = new Pessoa(nome, cpf, cidade, sexo, dataDeNascimento, quantVacinas, categoria);
		return null;
	}
	
	/*______________________________________________________________________________________________________________________________________*/
	
	/**
	 * Retorna a lista de pessoas
	 * @return the listaPessoas
	 */
	public ArrayList<Pessoa> getListaPessoas() {
		return listaPessoas;
	}

	/*______________________________________________________________________________________________________________________________________*/
	
	/**
	 * Altera a lista de pessoas
	 * @param listaPessoas the listaPessoas to set
	 */
	public void setListaPessoas(ArrayList<Pessoa> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}

	/*______________________________________________________________________________________________________________________________________*/
	
	/**
	 * Retorna uma lista de categorias adicionadas
	 * @return the listaCategorias
	 */
	public ArrayList<Categoria> getListaCategoria() {
		return listaCategorias;
	}

	/*______________________________________________________________________________________________________________________________________*/
	
	/**
	 * Altera a lista de categorias adicionadas
	 * @param listaCategorias the listaCategorias to set
	 */
	public void setListaCategoria(ArrayList<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}
}
