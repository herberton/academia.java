import java.io.Serializable;

public class Cliente implements Serializable {
	
	private int id;
	private String nome;

	public Cliente(int id, String nome) {
		this.setId(id);
		this.setNome(nome);
	}
	
	public Cliente() { }
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
