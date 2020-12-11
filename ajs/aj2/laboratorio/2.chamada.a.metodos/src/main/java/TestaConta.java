/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 */
class TestaConta {

    public static void main(String[] args) {
    	    
        // Criacao da conta
        Conta conta = new Conta();
        
        // Inicializacao da conta
        conta.inicializaConta(100, "32520-5", "Herberton C. Souza", 3215, 13);
        
        // Impressao dos dados da conta
        conta.imprimeDados();
        
        // Saque da conta
        conta.saque(100);
                
        // Impressao dos dados da conta
        conta.imprimeDados();
                
        // Deposito em conta
        conta.deposito(1000);
        
        // Impressao dos dados da conta
        conta.imprimeDados();
        
    }
}
