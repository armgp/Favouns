package com.projectgp.favouns.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
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

}
