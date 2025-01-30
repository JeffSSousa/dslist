package com.jeffersonSousa.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.jeffersonSousa.dslist.dto.GameDTO;
import com.jeffersonSousa.dslist.dto.GameMinDTO;
import com.jeffersonSousa.dslist.entities.Game;
import com.jeffersonSousa.dslist.projections.GameMinProjection;
import com.jeffersonSousa.dslist.repositories.GameRepository;



@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(@PathVariable Long listId) {
		Game result = gameRepository.findById(listId).get();
		return new GameDTO(result);
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		return result.stream().map(GameMinDTO::new).toList();
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByGameList(Long listId) {
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(GameMinDTO::new).toList();
	}
}

