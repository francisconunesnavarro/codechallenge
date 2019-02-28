package com.navarro.challenge.dto;

import java.io.Serializable;

import com.navarro.challenge.domain.FinanType;

public class FinanTypeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String type;
	private String name;
	private Double factor;

	public FinanTypeDTO() {
	}

	public FinanTypeDTO(FinanType obj) {
		id = obj.getId();
		type = obj.getType();
		name = obj.getName();
		factor = obj.getFactor();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getFactor() {
		return factor;
	}

	public void setFactor(Double factor) {
		this.factor = factor;
	}

}
