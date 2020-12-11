/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 */
public class TestaAgencia {

    public static void main(String[] args) {
    	    
        // Inicializar um objeto do tipo Agencia
        Agencia agencia = new Agencia();
        
        // usar o metodo inicializaAgencia (ver quais sao os parametros na classe Agencia)
        agencia.inicializaAgencia("10", 100); 
        
        
        // Imprimir os dados da agencia
        agencia.imprimeDados();
        
    }
}
