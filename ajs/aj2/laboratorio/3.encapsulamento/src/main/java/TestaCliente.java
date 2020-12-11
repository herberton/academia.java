/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 */
/**
 * @author Globalcode
 * 
 */
public class TestaCliente {

    public static void main(String[] args) {
    	    
        // Criacao do cliente
        Cliente cliente = new Cliente();
        
        // Inicializacao do cliente usando o metodo inicializaCliente
        cliente.inicializaCliente("Herberton Candido Souza", "033.330.808-50");
        
        // Impressao dos dados do cliente
        cliente.imprimeDados();
    }
}
