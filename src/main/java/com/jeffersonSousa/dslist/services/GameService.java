package com.jeffersonSousa.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeffersonSousa.dslist.dto.GameMinDTO;
import com.jeffersonSousa.dslist.entities.Game;
import com.jeffersonSousa.dslist.repositories.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository  gameRepository;
	
	public List<GameMinDTO> findAll(){
		List <Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
		
	}
}

