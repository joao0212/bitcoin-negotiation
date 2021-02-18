package br.com.alura.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import br.com.alura.enuns.Status;
import br.com.alura.enuns.Tipo;

@Entity
public class Ordem {

	public Ordem() {
	}

	public Ordem(Double preco, Tipo tipo, @NotNull(message = "UserId não pode ser nulo.") Long usuarioId) {
		super();
		this.preco = preco;
		this.tipo = tipo;
		this.usuarioId = usuarioId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double preco;

	@Enumerated(EnumType.STRING)
	private Tipo tipo;

	private LocalDate data;

	@Enumerated(EnumType.STRING)
	private Status status;

	@Column(name = "user_id")
	@NotNull(message = "UserId não pode ser nulo.")
	private Long usuarioId;

	public Long getId() {
		return id;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getData() {
		return data;
	}

	public Double getPreco() {
		return preco;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public Status getStatus() {
		return status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ordem other = (Ordem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
