/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 *
 * Esta classe representa um Panel de cadastro de clientes, 
 * para ser visualizada deve ser adicionada a um JFrame ou
 * outro container que possa ser visualizado.
 */
package br.com.globalcode.aj4.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import br.com.globalcode.util.GlobalcodeException;

/**
 * Esta classe monta um painel para cadastro de clientes. Para ser visualizada,
 * ela deve ser adicionada a um JFrame ou outro container.
 * 
 */
public class PainelCadastroClientes extends JPanel {

	private JLabel lNome;
	private JTextField tfNome;
	private JLabel lTelefone;
	private JTextField tfTelefone;
	private JLabel lID;
	private JTextField tfID;
	private JLabel lCPF;
	private JTextField tfCPF;
	private JPanel pCadastroCliente;
	private JPanel pBotoesCadastro;
	private JButton bExcluir;
	private JButton bSalvar;
	private JButton bNovo;

	/**
	 * Este construtor monta um Panel para insercao de dados de Cadastro de
	 * Clientes.
	 */
	public PainelCadastroClientes() throws GlobalcodeException {
		this.setLayout(new BorderLayout());
		pCadastroCliente = montaPanelCadastroCliente();
		pBotoesCadastro = montaPanelBotoesCadastro();
		this.add(pCadastroCliente, BorderLayout.CENTER);
		this.add(pBotoesCadastro, BorderLayout.SOUTH);
	}

	/**
	 * Metodo utilizado internamente para montagem do JPanel com o botao Salvar,
	 * por isto ele foi declarado como private.
	 * 
	 * @return JPanel com o botao Salvar, para salvar um cliente
	 */
	private JPanel montaPanelBotoesCadastro() {
		JPanel pBotoesCadastro = new JPanel();
		/*
		 * a)Implemente aqui o codigo para a montagem do painel de botoes
		 * (conforme tela apresentada na apostila).
		 * 
		 * Dica: Para associar uma tecla de atalho ao botao, utilize o metodo
		 * setMnemonic() usando como parametro KeyEvent.VK_(Letra desejada)
		 */
		 
		 bSalvar = new JButton("Salvar");
		 bExcluir = new JButton("Excluir");
		 bNovo = new JButton("Novo");
		 
		 bSalvar.setMnemonic(KeyEvent.VK_S);
		 bExcluir.setMnemonic(KeyEvent.VK_E);
		 bNovo.setMnemonic(KeyEvent.VK_N);
		 
		 pBotoesCadastro.add(bSalvar);
		 pBotoesCadastro.add(bExcluir);
		 pBotoesCadastro.add(bNovo);
		 
		return pBotoesCadastro;
	}

	/**
	 * Metodo utilizado internamente para montagem do JPanel para cadastro ou
	 * edicao de um cliente, por isto ele foi declarado como private.
	 * 
	 * @return JPanel para cadastro ou edicao de um cliente
	 */
	private JPanel montaPanelCadastroCliente() {
		JPanel pCadastroCliente = new JPanel();
		/*
		 * b) Implemente aqui o codigo para montagem do painel de cadastro de
		 * clientes (conforme tela apresentada na apostilas).
		 */
		 
		 JPanel pForm = new JPanel();
		 
		 lNome = new JLabel("Nome:");
		 lTelefone = new JLabel("Telefone:");
		 lCPF = new JLabel("CPF:");
		 lID = new JLabel("ID:");
	
		 
		 tfNome = new JTextField();
		 tfTelefone = new JTextField();
		 tfCPF = new JTextField();
		 tfID = new JTextField();
		 
		 
		 pForm.add(lNome);
		 pForm.add(tfNome);
		 
		 pForm.add(lTelefone);
		 pForm.add(tfTelefone);
		 
		 pForm.add(lCPF);
		 pForm.add(tfCPF);
		 
		 pForm.add(lID);
		 pForm.add(tfID);
		 
		 pCadastroCliente.add(pForm);
		 
		 
		 tfID.setEnabled(false);
		 pForm.setLayout(new GridLayout(8, 1));
		 pForm.setPreferredSize(new Dimension(290, 170));
		 pCadastroCliente.setLayout(new FlowLayout(FlowLayout.LEFT));
		 
		 
		 return pCadastroCliente;
	}
}