package br.com.globalcode.model;

import br.com.globalcode.annotations.TextBox;

public class Produto {
	
	
	// fields...
	
	@TextBox(label="ID", enabled=false)
	private int id;
	@TextBox(label="descricao")
	private String descricao;
	@TextBox(label="preco")
	private double preco;
	@TextBox(label="marca")
	private String marca;
	
	
	//constructors...
	
	public Produto(int id, String descricao, double preco, String marca) {
		this.setId(id);
		this.setDescricao(descricao);
		this.setPreco(preco);
		this.setMarca(marca);
	}
	
	
	// getters...
	
	public int getId() {
		return this.id;
	}
	public String getDescricao() {
		return this.descricao;
	}
	public double getPreco() {
		return this.preco;
	}
	public String getMarca() {
		return this.marca;
	}
	
	
	// setters...
	
	public void setId(int id) {
		this.id = id;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
}