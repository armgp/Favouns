package com.projectgp.favouns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectgp.favouns.model.Favoun;

@Repository
public interface FavounRepository extends JpaRepository<Favoun, Long>{
	
}
