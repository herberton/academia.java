/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 */
class TestaCliente {

    public static void main(String[] args) {
        // Criacao do cliente
        Cliente cliente = new Cliente();
        
        // Inicializacao do cliente
        cliente.inicializaCliente("Herberton Candido Souza", "230.283.488-70");
        
        // Impressao dos dados do cliente
        cliente.imprimeDados();
    }
}
