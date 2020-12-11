class TesteException {

    public static void main(String args[]) {
        Banco banco = new Banco("Globalcode Bank", 1000);
        Agencia agencia = new AgenciaStandard("321", banco);
        Cliente cliente1 = new Cliente("Cliente 1", "1232323");
        ContaEspecial contaEspecial = new ContaEspecial(2000, "876654", cliente1, agencia, 500);
        ContaPoupanca contaPoupanca = new ContaPoupanca(600, "135646", cliente1, agencia, "01/01/2005");
        
        saque(contaEspecial, 2950.0);
        saque(contaPoupanca, 340);
        
        contaEspecial.imprimeDados();
        contaPoupanca.imprimeDados();
    }
    
    private static void saque(Conta conta, double valor) {
    	    
        try {
        	
        	conta.saque(valor);
        	
        } catch(SaldoInsuficienteException e) {
        	
        	e.printStackTrace();
        }
    	
    }
}
