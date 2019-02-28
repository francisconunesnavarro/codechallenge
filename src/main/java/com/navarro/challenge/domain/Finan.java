package com.navarro.challenge.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Finan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer amount;
	private Double value;
	private Double quota;
	private String name;
	private String contacto;

	@OneToOne
	@JoinColumn(name = "finantype_id")
	private FinanType finanType;

	public Finan() {
	}

	public Finan(Integer id, FinanType finanType, Integer amount, Double value, Double quota) {
		super();
		this.id = id;
		this.finanType = finanType;
		this.amount = amount;
		this.value = value;
		this.quota = quota;
	}
	
	public Finan(Integer id, FinanType finanType, Integer amount, Double value, Double quota, String name, String contacto) {
		super();
		this.id = id;
		this.finanType = finanType;
		this.amount = amount;
		this.value = value;
		this.quota = quota;
		this.name = name;
		this.contacto = contacto;
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
		Finan other = (Finan) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
