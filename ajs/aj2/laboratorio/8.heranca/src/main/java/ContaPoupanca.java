/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 * Tarefas: 
 * 1) Faca com que a classe ContaPoupanca estenda a classe Conta 
 * 2) Adicione o atributo data de aniversario (dataAniversario) a classe ContaPoupanca,
 *  declarando-o como String e encapsule o atributo 
 * 3) Crie um construtor para a classe ContaPoupanca obrigando a passagem da data de 
 *  aniversario e todos os parametros necessarios para abertura de Conta 
 * 4) Faca override do metodo imprimeDados fazendo com que ele imprima
 *  tambem a data de aniversario e o tipo da conta (CONTA POUPANCA) em seu cabecalho
 */
public class ContaPoupanca extends Conta {
	private String dataAniversario;
	public String getDataAniversario() {
		return this.dataAniversario;
	}
	public void setDataAniversario(String dataAniversario) {
		this.dataAniversario = dataAniversario;
	}
	
	/**
	 * @param saldoInicial
	 *		Saldo Inicial da conta
	 * @param num
	 *		Numero da conta
	 * @param tit
	 *		Titular da conta
	 * @param ag
	 *		Agencia a qual a conta pertence
	 * @param bc
	 * 		Banco a qual a agencia pertence
	 * @param dataAniversario
	 *		Data de aniversario da conta poupança
	 */
	public ContaPoupanca(double saldoInicial, String num, Cliente tit, Agencia ag, String dataAniversario) {
		super(saldoInicial, num, tit, ag);
		this.setDataAniversario(dataAniversario);
	}
	
	/**
	 * @param num
	 *		Numero da conta
	 * @param tit
	 *		Titular da conta
	 * @param ag
	 *		Agencia a qual a conta pertence
	 * @param bc
	 *		Banco a qual a agencia pertence
	 * @param ldataAniversario
	 *		Data de aniversario da conta poupança
	 */
	public ContaPoupanca(String num, Cliente tit, Agencia ag, String dataAniversario) {
		super(num, tit, ag);
		this.setDataAniversario(dataAniversario);
	}
	
	/**
	 *	Este metodo deve imprimir todos os dados da conta corrente
	 */
	public void imprimeDados() {
		System.out.println("========================================");
		System.out.println("CONTA POUPANÇA:");
		super.imprimeDados();
		System.out.println("Data de aniversário: " + this.getDataAniversario());
		System.out.println("========================================");
	}
}
