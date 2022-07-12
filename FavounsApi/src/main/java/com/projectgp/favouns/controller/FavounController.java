package com.projectgp.favouns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectgp.favouns.model.Favoun;
import com.projectgp.favouns.model.User;
import com.projectgp.favouns.service.FavounService;
import com.projectgp.favouns.service.UserDetailsServiceImpl;
import com.projectgp.favouns.utils.JwtUtil;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/")
public class FavounController {

	@Autowired
	FavounService favounService;
	
	@Autowired
	UserDetailsServiceImpl userService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@GetMapping("favouns")
	public ResponseEntity<?> getAllFavouns(){
		HttpHeaders responseHeaders = new HttpHeaders();
		return new ResponseEntity<List<Favoun>>(favounService.getAllFavouns(), responseHeaders, HttpStatus.OK);
	}
	
	@PutMapping("buyfavoun/{favounId}")
	public ResponseEntity<?> buyFavoun(@AuthenticationPrincipal User user, @PathVariable Long favounId){
		Favoun favoun = favounService.getFavoun(favounId);
		user.buyFavoun(favoun);
		user = userService.saveUser(user);
		
		HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Expose-Headers", "*, Authorization");
        
		return new ResponseEntity<User>(user, responseHeaders, HttpStatus.OK);
	}
}

