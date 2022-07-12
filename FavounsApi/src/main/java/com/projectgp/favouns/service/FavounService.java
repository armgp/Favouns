package com.projectgp.favouns.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectgp.favouns.model.Favoun;
import com.projectgp.favouns.repository.FavounRepository;

@Service
public class FavounService {
	
	@Autowired
	FavounRepository favounRepo;
	
	public List<Favoun> getAllFavouns(){
		return favounRepo.findAll();
	}

	public Favoun getFavoun(Long favounId) {
		return favounRepo.getById(favounId);
	}

	public void saveFavoun(Favoun favoun) {
		favounRepo.save(favoun);
	}
}
