package br.com.alura.model;

import java.time.LocalDate;

public class Bitcoin {

	public Bitcoin() {

	}

	public Bitcoin(Double preco, String tipo, LocalDate data) {
		super();
		this.preco = preco;
		this.tipo = tipo;
		this.data = data;
	}

	private Long id;
	private Double preco;
	private String tipo;
	private LocalDate data;

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Double getPreco() {
		return preco;
	}

	public String getTipo() {
		return tipo;
	}

	public LocalDate getData() {
		return data;
	}
}
