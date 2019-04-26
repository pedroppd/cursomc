package com.pedrodantas.cursomc.domain.enums;

public enum Perfil {


	ADMIN(1, "ROLE_ADMIN"),
	CLIENTE(2,"ROLE_CLIENTE");
	
	private Integer id;
	private String descricao;
	
	
	private Perfil(Integer id, String descricao) {
		this.setId(id);
		this.setDescricao(descricao);
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
	public static Perfil ToEnum(Integer cod) {
		if(cod==null) {
			
		}
		
		for(Perfil x : Perfil.values()) {
			if(cod.equals(x.getId())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
}
