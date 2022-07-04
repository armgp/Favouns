package com.projectgp.favouns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectgp.favouns.model.Favoun;
import com.projectgp.favouns.repository.FavounRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/")
public class FavounController {

	@Autowired
	FavounRepository favounRepo;

//	@GetMapping("favouns")
//	public List<Favoun> getAllFavouns(){
//		return favounRepo.findAll();
//	}
	
	@GetMapping("favouns")
	public ResponseEntity<?> getAllFavouns(){
		HttpHeaders responseHeaders = new HttpHeaders();
		
//		responseHeaders.set("Access-Control-Allow-Origin", "*");
//		responseHeaders.set("Access-Control-Allow-Methods", "GET, POST, PATCH, PUT, DELETE, OPTIONS");
//		responseHeaders.set("Access-Control-Expose-Headers", "*, Authorization");
//        responseHeaders.set("Access-Control-Expose-Headers", "Origin, Content-Type, X-Auth-Token");
		
		return new ResponseEntity<List<Favoun>>(favounRepo.findAll(), responseHeaders, HttpStatus.OK);
	}
}
