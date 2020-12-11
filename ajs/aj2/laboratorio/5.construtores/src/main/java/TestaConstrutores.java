/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java 
 * 1) Construa um objeto da classe Conta com cada construtor e chame o metodo imprimeDados 
 * 2) Construa um objeto da classe Cliente e chame o metodo imprimeDados
 * 
 */
public class TestaConstrutores {

    public static void main(String[] args) {
    	    
    	    Conta conta1 = new Conta(100000, "1234567890", "Herberton Candido Souza", "10", 100);
    	    conta1.imprimeDados();
    	    
    	    Conta conta2 = new Conta("1234567890", "Herberton Candido Souza", "10", 100);
    	    conta2.imprimeDados();
    	    
    	    Cliente cliente = new Cliente("Herberton Candido Souza", "033.330.808-50");
    	    cliente.imprimeDados();
    }
}
