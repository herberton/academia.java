package br.com.globalcode.threads;

import javax.swing.JOptionPane;

public class TesteWaitNotify {

	public static void main(String args[]) throws Exception {

		// inicializando repositorio de dados
		ListaConvidados lista = new ListaConvidados();

		Thread t1 = new Thread(new EntregadorDeConvite(lista),"\"entregador1\"");
		Thread t2 = new Thread(new EntregadorDeConvite(lista),"\"entregador2\"");
		Thread t3 = new Thread(new EntregadorDeConvite(lista),"\"entregador3\"");
/*		Thread t4 = new Thread(new EntregadorDeConvite(lista),"\"entregador\t4\"");
		Thread t5 = new Thread(new EntregadorDeConvite(lista),"\"entregador\t5\"");
		Thread t6 = new Thread(new EntregadorDeConvite(lista),"\"entregador\t6\"");
		Thread t7 = new Thread(new EntregadorDeConvite(lista),"\"entregador\t7\"");
		Thread t8 = new Thread(new EntregadorDeConvite(lista),"\"entregador\t8\"");
		Thread t9 = new Thread(new EntregadorDeConvite(lista),"\"entregador\t9\"");
		Thread t10 = new Thread(new EntregadorDeConvite(lista),"\"entregador\t10\"");*/
		// disparando entregadores de convites
		// sao as threads consumidoras do repositorio de dados
		t1.start();
		t2.start();
		t3.start();
		/*t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();*/

		// loop de entrada de dados
		// esta thread (main) é a produtora de dados
		while (true) {
			// obtem um novo email para adicionar na lista
			String email = JOptionPane.showInputDialog(
					"Digite o email do proximo convidado ", "");
			if (email != null) {
				lista.adicionar(email);
			} else {
				lista.fecharLista();
				break; // para sair do loop
			}
		}
	}
}
