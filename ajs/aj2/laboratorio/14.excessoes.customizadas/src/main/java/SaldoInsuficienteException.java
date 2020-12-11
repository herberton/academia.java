import static java.lang.System.out;

public class SaldoInsuficienteException extends Exception {
	
	public SaldoInsuficienteException(String mensagem) {
		super(mensagem);
	}
	
	public void printStackTrace() {
		out.println();
		out.println("-------------------------------------------------");
        	out.println("-EXCESSAO----------------------------------------");
        	out.println("-------------------------------------------------");
        	out.println("Ocorreu uma exceção ao efetuar o saque: ");
        	out.println("\t" + this.getMessage());
        	out.println("-------------------------------------------------");
        	out.println();
	}
}
