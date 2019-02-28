package com.navarro.challenge.dto;

import java.io.Serializable;

import com.navarro.challenge.domain.Finan;
import com.navarro.challenge.domain.FinanType;

public class FinanDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private FinanType finanType;
	private Integer amount;
	private Double value;
	private Double quota;
	private String name;
	private String contacto;

	public FinanDTO() {
	}

	public FinanDTO(Finan obj) {
		id = obj.getId();
		finanType = obj.getFinanType();
		amount = obj.getAmount();
		value = obj.getValue();
		quota = obj.getQuota();
		name = obj.getName();
		contacto = obj.getContacto();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FinanType getFinanType() {
		return finanType;
	}

	public void setFinanType(FinanType finanType) {
		this.finanType = finanType;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Double getQuota() {
		return quota;
	}

	public void setQuota(Double quota) {
		this.quota = quota;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
}
