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

import exceptions.CategoriaInvalidaException;
import exceptions.CategoriaNulaException;
import exceptions.CidadeInvalidaException;
import exceptions.CidadeNulaException;
import exceptions.CpfInvalidoException;
import exceptions.CpfNuloException;
import exceptions.DataInvalidaException;
import exceptions.DataNulaException;
import exceptions.NomeNuloException;
import exceptions.NomeVazioException;
import exceptions.SexoInvalidoException;
import exceptions.SexoNuloException;
import model.Categoria;
import model.Pessoa;

public class Controller {

	private static Controller controller = new Controller();
	private ArrayList<Pessoa> listaPessoas = null;
	private ArrayList<Categoria> listaCategorias = null;

	private final int CPFLENGTH = 11;

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
	 * @param sexo - Sexo da pessoa a ser adicionada.
	 * @param dataNascimento - Data de nascimento da pessoa.
	 * @param quantVacinas - Quantidade de vacinas tomadas pela pessoa a ser cadastrada.
	 * @param categoria - Categoria que a pessoa a ser cadastrada pertence.
	 * @throws NomeNuloException - Caso o nome seja nulo.
	 * @throws NomeVazioException - Caso o nome esteja vazio.
	 * @throws CpfNuloException - Caso o CPF seja nulo.
	 * @throws CpfInvalidoException - Caso o CPF esteja vazio.
	 * @throws CidadeNulaException - Caso a cidade seja nula.
	 * @throws CidadeInvalidaException - Caso a cidade seja invalida.
	 * @throws SexoNuloException - Caso o sexo seja nulo.
	 * @throws SexoInvalidoException - Caso o sexo seja invalido.
	 * @throws DataNulaException - Caso a data seja nula.
	 * @throws DataInvalidaException - Caso a data seja invalida.
	 * @throws CategoriaNulaException - Casp a categoria seja nula.
	 * @throws CategoriaInvalidaException - Caso a categoria seja invalida.
	 */
	public Pessoa adicionarPessoa(String nome, String cpf, String cidade, String sexo, Date dataDeNascimento, int quantVacinas, Categoria categoria) {
		Pessoa pessoa = null;

		if(nome == null) {
			new NomeNuloException();
		}
		else if(nome.trim().length() == 0) {
			new NomeVazioException();
		}
		else if(cpf == null) {
			new CpfNuloException();
		}
		else if (cpf.trim().length() == 0 || cpf.length() != CPFLENGTH) {
			for(char a: cpf.toCharArray()) {
				switch(a) {
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					break;
				default:
					new CpfInvalidoException();
				}
			}
		}
		else if(cidade == null) {
			new CidadeNulaException();
		}
		else if(cidade.trim().length() == 0) {
			new CidadeInvalidaException();
		}
		else if(sexo == null) {
			new SexoNuloException();
		}
		else if(sexo.trim().length() == 0 || sexo.toUpperCase().equals("MASCULINO") || sexo.toUpperCase().equals("FEMININO")) {
			new SexoInvalidoException();
		}
		else if(dataDeNascimento == null) {
			new DataNulaException();
		}
		else if(dataDeNascimento.after(new Date())) {
			new DataInvalidaException();
		}
		else if(categoria == null) {
			new CategoriaNulaException();
		}
		else {
			Iterator<Categoria> it = listaCategorias.iterator();
			Categoria categoriaSearch = null;
			while(it.hasNext()) {
				categoriaSearch = it.next();
				if(categoria.getNomeCategoria().equals(categoriaSearch.getNomeCategoria())) {
					pessoa = new Pessoa(nome, cpf, cidade, sexo, dataDeNascimento, quantVacinas, categoria);
					return pessoa;
				}
			}  
			new CategoriaInvalidaException();
		}
		return null;
	}

	/*______________________________________________________________________________________________________________________________________*/

	/**
	 * Remove e retorna a pessoa excluida, ou null caso a pessoa não exista..
	 * @param cpf - CPF da pessoa a ser removida.
	 * @return pessoa - Pessoa removida ou null caso a pessoa não exista.
	 */
	public Pessoa removerPessoa(String cpf) {
		Pessoa pessoa = null;
		if(cpf == null) {
			new CpfNuloException();
		}
		else if(cpf.trim().length() == 0) {
			new CpfInvalidoException();
		}
		else {
			Iterator<Pessoa> it = listaPessoas.iterator();
			while(it.hasNext()) {
				pessoa = it.next();
				if(pessoa.getCpf().equals(cpf)) {
					listaPessoas.remove(pessoa);
					return pessoa;
				}
			}
		}
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
