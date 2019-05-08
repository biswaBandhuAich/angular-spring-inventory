package com.store.medicine.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Medicine {
	@Id
	private String id;
	private String brand;
	private String generic;
	private String quantity;
	private String unitprice;
	private String totalprice;
	private String scheduleh;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getGeneric() {
		return generic;
	}
	public void setGeneric(String generic) {
		this.generic = generic;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(String unitprice) {
		this.unitprice = unitprice;
	}
	public String getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}
	public String getScheduleh() {
		return scheduleh;
	}
	public void setScheduleh(String scheduleh) {
		this.scheduleh = scheduleh;
	}
}
