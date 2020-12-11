import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;



import java.io.IOException;


public class SerializaObjeto {
	
	public static void main(String... args) {
		
		try {
			
			FileOutputStream fileOutputStream = new FileOutputStream("cliente.object");
			
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			objectOutputStream.writeObject(new Cliente(17, "José"));
			
			objectOutputStream.close();
			
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		Cliente cliente = null;
		
		try {
			FileInputStream fileInputStream = new FileInputStream("cliente.object");
			
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			
			cliente = (Cliente)objectInputStream.readObject();
			
			objectInputStream.close();
			
		} catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("cliente.getId(): " + cliente.getId());
		System.out.println("cliente.getNome(): " + cliente.getNome());
		
	}
	
}
