import static java.lang.System.out;

public class TesteRuntimeExceptions {

    public static void main(String[] args) {
    	try {
    		// Leitura do parametro digitado pelo usuario como parametro do main
    		String parametro1 = args[0];
    		int numero = Integer.parseInt(parametro1);
	} catch(NumberFormatException | ArrayIndexOutOfBoundsException e) {
		out.println("Parâmetros inválidos.");
		out.println();
		out.print("Não foi possível continuar os testes, motivo: ");
		out.println(e.getMessage());
		out.println();
		out.println("Stack Trace:");
		e.printStackTrace();
	}
    }
}
