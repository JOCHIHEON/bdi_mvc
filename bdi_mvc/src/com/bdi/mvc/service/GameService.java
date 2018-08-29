package com.bdi.mvc.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.bdi.mvc.vo.Game;

public interface GameService {
	public List<Game> getGameList(Game game) throws SQLException;
	public Game getGame(Game game)throws SQLException;
	public Map<String, Object> insertGame(Game game)throws SQLException;
	public Map<String, Object> updateGame(Game game)throws SQLException;
	public Map<String, Object> deleteGame(Game game)throws SQLException;
}
