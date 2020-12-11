/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 */
public class TestaConta {

    public static void main(String[] args) {
    	    
        // Criar um objeto do tipo Conta
        Conta conta = new Conta();
        
        // Usar o metodo inicializaConta para fazer a inicializacao do objeto criado
        conta.inicializaConta(10000.0,"1234567890","Herberton Candido Souza", 10, 100);
        
        // executar um deposito
        conta.deposito(10000.0);
        
        // Imprimir o saldo apos o deposito
        conta.imprimeDados();
        
        // executar um saque cujo valor seja menor que o saldo
        conta.saque(15000.0);
        
        
        // Imprimir o saldo apos o deposito
        conta.imprimeDados();
        
        // executar uma retirada cujo valor seja maior que o saldo
        conta.saque(15000.0);
        
        // Imprimir o saldo apos o deposito
        conta.imprimeDados();
        
    }
}
