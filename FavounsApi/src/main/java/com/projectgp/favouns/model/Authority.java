package com.projectgp.favouns.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Authority implements GrantedAuthority{
	private static final long serialVersionUID = 958401346433511886L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String authority;
	@ManyToOne(optional = false)
	private User user;
	
	public Authority() {}
	
	public Authority(String authority) {
		this.authority = authority;
	}
	
	public User getUser() {
		return user;
	}
}
