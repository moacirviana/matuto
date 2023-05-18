package com.xibe.matuto.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@ManyToMany
	@JoinTable(name = "produto_categoria",
		joinColumns = @JoinColumn(name = "id_produto"),
		inverseJoinColumns = @JoinColumn(name = "id_categoria"))	
	private Set<Categoria> categories = new HashSet<>();
	
	public Produto() {}
	

	public Produto(Long id,	String titulo, String descricao,
			BigDecimal valor, byte[] picture, Set<Categoria> categories) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.valor = valor;
		this.picture = picture;
		this.categories = categories;
	}


	public Set<Categoria> getCategories() {
		return categories;
	}

	public void setCategories(Set<Categoria> categories) {
		this.categories = categories;
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
