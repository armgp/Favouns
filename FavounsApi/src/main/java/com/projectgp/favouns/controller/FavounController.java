package com.projectgp.favouns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectgp.favouns.model.Favoun;
import com.projectgp.favouns.repository.FavounRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class FavounController {

	@Autowired
	FavounRepository favounRepo; 
	
	@GetMapping("favouns")
	public List<Favoun> getAllFavouns(){
		return favounRepo.findAll();
	}
}
