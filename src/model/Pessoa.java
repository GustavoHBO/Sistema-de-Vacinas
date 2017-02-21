/**
*	Classe pessoa, responsável pelas caracteristicas de cada pessoa na aplicação.
*	@Author Gustavo Henrique
*	@Since 20/02/2017
*/
package model;

import java.util.Date;

public class Pessoa{

	private String nome = null;
	private String cpf = null;
	private String cidade = null;
	private String sexo = null;
	private Date dataDeNascimento = null;
	private int quantVacinas = 0;
	private Categoria categoria = null;
	
	public Pessoa(String nome, String cpf, String cidade, String sexo, Date dataDeNascimento, int quantVacinas, Categoria categoria) {
		this.nome = nome;
		this.cpf = cpf;
		this.cidade = cidade;
		this.sexo = sexo;
		this.dataDeNascimento = dataDeNascimento;
		this.quantVacinas = quantVacinas;
		this.categoria = categoria;
	}
	
	/**
	 * Retorna o nome da pessoa
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Altera o nome da pessoa
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Retorna o CPF da pessoa
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * Altera o CPF da pessoa
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/**
	 * Retorna a cidade da pessoa
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}
	/**
	 * Altera a cidade da pessoa
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	/**
	 * Retorna o sexo da pessoa.
	 * @return the sexo
	 */
	public String isSexo() {
		return sexo;
	}
	/**
	 * Altera o sexo da pessoa.
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	/**
	 * Retorna a data de nascimento da pessoa
	 * @return the dataDeNascimento
	 */
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}
	/**
	 * Altera a data de nascimento da pessoa
	 * @param dataDeNascimento the dataDeNascimento to set
	 */
	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	/**
	 * Retirna a quantidade de vacinas que a pessoa tomou
	 * @return the quantVacinas
	 */
	public int getQuantVacinas() {
		return quantVacinas;
	}
	/**
	 * Altera a quantidade de vacinas que a pessoa tomou
	 * @param quantVacinas the quantVacinas to set
	 */
	public void setQuantVacinas(int quantVacinas) {
		this.quantVacinas = quantVacinas;
	}
	/**
	 * Retorna a categoria da pessoa
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}
	/**
	 * Altera a categoria da pessoa
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


}