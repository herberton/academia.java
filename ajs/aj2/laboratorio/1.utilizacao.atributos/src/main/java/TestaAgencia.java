/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 * 
 * 1) Crie um objeto da classe Agencia
 * 2) Inicialize todos os atributos deste objeto
 * 3) Imprima os valores dos atributos da classe Agencia de forma a obter o
 * seguinte resultado:
 * 
 * -----------------------------
 * AGENCIA: 1    BANCO  : 234
 * -----------------------------
 * 
 * Sugestoes: 
 * Utilizando '\t' para tab
 * Ex: System.out.println("Texto\tTexto");
 * 
 * voce produzira a seguinte saida: 
 * Texto  Texto
 */
class TestaAgencia {

    public static void main(String[] args) {
    	    Agencia agencia = new Agencia();
    	    agencia.numero = "1";
    	    agencia.banco = 234;
    	    
    	    System.out.println("-----------------------------");
    	    System.out.println("AGENCIA: " + agencia.numero + "\tBANCO\t: " + agencia.banco);
    	    System.out.println("-----------------------------");
    }
}
