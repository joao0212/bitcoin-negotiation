package br.com.alura.dto;

import java.time.LocalDate;

public class OrdemDTO {

	public OrdemDTO() { }

	public OrdemDTO(Double preco, String tipo, LocalDate data, String status, Long usuarioId) {
		super();
		this.preco = preco;
		this.tipo = tipo;
		this.data = data;
		this.status = status;
		this.usuarioId = usuarioId;
	}

	private Double preco;
	private String tipo;
	private LocalDate data;
	private String status;
	private Long usuarioId;

	public Double getPreco() {
		return preco;
	}

	public String getTipo() {
		return tipo;
	}

	public LocalDate getData() {
		return data;
	}

	public String getStatus() {
		return status;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
}
