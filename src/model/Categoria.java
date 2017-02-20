/**
 * Determina a categoria da pessoa
 * 
 * @author Gustavo Henrique
 * @since 20/12/2017
 */
package model;
public class Categoria {
	private String nomeCategoria = null;
	
	public Categoria(String nomeCategoria) {
		this.setNomeCategoria(nomeCategoria);
	}

	/**
	 * Retorna o nome da categoria
	 * @return the nomeCategoria
	 */
	public String getNomeCategoria() {
		return nomeCategoria;
	}

	/**
	 * Altera o nome da categoria
	 * @param nomeCategoria the nomeCategoria to set
	 */
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	
	
	
}
