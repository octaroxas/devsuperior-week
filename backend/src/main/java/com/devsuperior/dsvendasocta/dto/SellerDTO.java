package com.devsuperior.dsvendasocta.dto;

import java.io.Serializable;

import com.devsuperior.dsvendasocta.entities.Seller;

public class SellerDTO implements Serializable {
	
	// O objeto DTO não possui ligação com o banco de dados
	private static final long serialVersionUID = 1L;
	private Long id;	
	private String name;
	
	public SellerDTO() {
	}

	public SellerDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public SellerDTO(Seller entity) {
		super();
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
