package view;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interface extends JFrame {

	private final int _WIDTH = 600, _HEIGHT = 400;
	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal = null;
	private final String TITLE = "Sistema de Gerenciamento de Vacinas";
	
	private Interface() {}
	
	public static void main(String args[]) {
		new Interface().montarTela();
	}
	
	private void montarTela() {
		prepararJanela();
		prepararPanelPrincipal();
		prepararBotaoAdicionarCategoria();
		prepararBotaoRemoverCategoria();
		prepararBotaoAdicionarPessoa();
		prepararBotaoRemoverPessoa();
		mostrarTela();
	}
	
	private void mostrarTela() {
		this.pack();
		this.setSize(_WIDTH, _HEIGHT);
		this.setVisible(true);
	}
	
	private void prepararJanela() {
		this.setTitle(TITLE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void prepararPanelPrincipal() {
		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(null);
		this.add(panelPrincipal);
	}
	
	private void prepararBotaoAdicionarCategoria() {
		Icon icone = new ImageIcon("src/resources/adicionarCategoria.png");
		JButton botaoAdicionarCategoria = new JButton(icone);
		botaoAdicionarCategoria.setBounds(35, 10, 90, 90);
		panelPrincipal.add(botaoAdicionarCategoria);
		
		JLabel labelAdicionarCategoria = new JLabel("Adicionar Categoria");
		labelAdicionarCategoria.setFont(new Font("TimesRoman", Font.BOLD, 12));
		labelAdicionarCategoria.setBounds(10, 100, 140, 20);
		panelPrincipal.add(labelAdicionarCategoria);
	}
	
	private void prepararBotaoRemoverCategoria() {
		Icon icone = new ImageIcon("src/resources/removerCategoria.png");
		JButton botaoRemoverCategoria = new JButton(icone);
		botaoRemoverCategoria.setBounds(200, 10, 90, 90);
		panelPrincipal.add(botaoRemoverCategoria);
		
		JLabel labelRemoverCategoria = new JLabel("Remover Categoria");
		labelRemoverCategoria.setFont(new Font("TimesRoman", Font.BOLD, 12));
		labelRemoverCategoria.setBounds(175, 100, 140, 20);
		panelPrincipal.add(labelRemoverCategoria);
	}
	
	private void prepararBotaoAdicionarPessoa() {
		Icon icone = new ImageIcon("src/resources/adicionarPessoa.png");
		JButton botaoAdicionarPessoa = new JButton(icone);
		botaoAdicionarPessoa.setBounds(35, 140, 90, 90);
		panelPrincipal.add(botaoAdicionarPessoa);
		
		JLabel labelAdicionarPessoa = new JLabel("Adicionar Pessoa");
		labelAdicionarPessoa.setFont(new Font("TimesRoman", Font.BOLD, 12));
		labelAdicionarPessoa.setBounds(20, 230, 140, 20);
		panelPrincipal.add(labelAdicionarPessoa);
	}
	
	private void prepararBotaoRemoverPessoa() {
		Icon icone = new ImageIcon("src/resources/removerPessoa.png");
		JButton botaoRemoverPessoa = new JButton(icone);
		botaoRemoverPessoa.setBounds(200, 140, 90, 90);
		panelPrincipal.add(botaoRemoverPessoa);
		
		JLabel labelRemoverPessoa = new JLabel("Remover Pessoa");
		labelRemoverPessoa.setFont(new Font("TimesRoman", Font.BOLD, 12));
		labelRemoverPessoa.setBounds(190, 230, 140, 20);
		panelPrincipal.add(labelRemoverPessoa);
	}
}
