/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 */
class TestaAgencia {

    public static void main(String[] args) {
    	    
        // Criacao da agencia
        Agencia agencia = new Agencia();
        
        // Inicializacao da agencia
        agencia.inicializaAgencia("1335", 12);
        
        // Impressao dos dados da agencia
        agencia.imprimeDados();
    }
}
