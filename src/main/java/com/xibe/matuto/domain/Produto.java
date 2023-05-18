package com.xibe.matuto.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = -8538897325926353850L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;

	@Column(length = 100)
	@NotEmpty(message = "Preenchimento obrigatorio")
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 100 caracteres")
	private String titulo;

	@Column(nullable = false, length = 200)
	@NotEmpty(message = "Preenchimento obrigatorio")
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 200 caracteres")
	private String descricao;

	@Column(nullable = false)
	private BigDecimal valor;

	@Lob
	@JsonIgnore
	private byte[] picture;
	
	public Produto() {}
	
	public Produto(Long id,
			String titulo,
			String descricao,
			BigDecimal valor, byte[] picture) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.valor = valor;
		this.picture = picture;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

}
