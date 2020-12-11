/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 * Tarefas: 
 * 1) Faca com que a classe ContaEspecial estenda a classe Conta 
 * 2) Adicione o atributo limite do tipo double e o encapsule 
 * 3) Crie construtores da classe obrigando a passagem do valor do limite na criacao de objetos 
 *  e todos os parametros necessarios anteriormente. 
 * 4) Faca override do metodo imprimeDados fazendo com que ele imprima tambem o
 *  valor do limite alem do tipo da conta (CONTA ESPECIAL) 
 * 5) Faca override do metodo saque para que ele considere o limite na hora de 
 *    verificar se existe ou nao saldo disponivel.
 *    Faca tambem com que este metodo acumule o CPMF devido.
 */
public class ContaEspecial extends Conta {
	
	private double limite;
	public double getLimite() {
		return this.limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
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
	 * @param limite
	 *		Limite da conta especial
	 */
	public ContaEspecial(double saldoInicial, String num, Cliente tit, Agencia ag, double limite) {
		super(saldoInicial, num, tit, ag);
		this.setLimite(limite);
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
	 * @param limite
	 *		Limite da conta especial
	 */
	public ContaEspecial(String num, Cliente tit, Agencia ag, double limite) {
		super(num, tit, ag);
		this.setLimite(limite);
	}
	
	
	/**
	 * @param valor
	 *            Valor a ser sacado da conta
	 */
	public void saque(double valor) {
		System.out.println("Realizando saque de R$ " + valor + " da conta " + numero);
		if (valor <= 0) {
			System.out.println("O valor de saque deve ser positivo");
			return;
		}
		
		if((saldo+limite) < valor) {
			System.out.println("Saldo insuficiente");
			return;
		}
		
		saldo-=valor;
		
		super.acumularIFN(valor);
		
	}
	
	
	
	/**
	 *	Este metodo deve imprimir todos os dados da conta corrente
	 */
	public void imprimeDados() {
		System.out.println("========================================");
		System.out.println("CONTA ESPECIAL:");
		super.imprimeDados();
		System.out.println("Limite da conta especial: R$" + this.getLimite());
		System.out.println("========================================");
	}
}
