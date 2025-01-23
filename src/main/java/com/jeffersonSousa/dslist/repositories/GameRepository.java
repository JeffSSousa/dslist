package com.jeffersonSousa.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeffersonSousa.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{
	

}
