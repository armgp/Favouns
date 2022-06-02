package com.projectgp.favouns.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "favouns")
public class Favoun {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long favId;
	
	private String name;
	private String description;
	private int price;
	
	public Favoun() {
		
	}
	
	public Favoun(String name, String description, int price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public long getFavId() {
		return favId;
	}
	public void setFavId(long favId) {
		this.favId = favId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
