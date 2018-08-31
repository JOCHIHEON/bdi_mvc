package com.bdi.mvc.service.Impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bdi.mvc.common.DBCon;
import com.bdi.mvc.dao.GameDAO;
import com.bdi.mvc.dao.Impl.GameDAOImpl;
import com.bdi.mvc.service.GameService;
import com.bdi.mvc.vo.Game;

public class GameServiceImpl implements GameService {
	GameDAO gdao = new GameDAOImpl();

	@Override
	public List<Game> getGameList(Game game) throws SQLException {
		gdao.setConnection(DBCon.getCon());
		try {
			return gdao.selectGameList(null);
		}finally {
			DBCon.close();
		}
	}

	@Override
	public Game getGame(Game game) throws SQLException {
		gdao.setConnection(DBCon.getCon());
		try {
			return gdao.selectGame(game);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public Map<String, Object> insertGame(Game game) throws SQLException {
		gdao.setConnection(DBCon.getCon());
		try {
			int cnt = gdao.insertGame(game);
			Map<String,Object> rMap = new HashMap<String,Object>();
			rMap.put("cnt", cnt);
			rMap.put("msg", "등록 실패");
			if(cnt==1) {
				rMap.put("cnt", cnt);
				rMap.put("msg", "등록 성공");
			}
			return rMap;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public Map<String, Object> updateGame(Game game) throws SQLException {
		gdao.setConnection(DBCon.getCon());
		try {
			int cnt = gdao.updateGame(game);
			Map<String,Object> rMap = new HashMap<String,Object>();
			rMap.put("cnt", cnt);
			rMap.put("msg", "수정 실패");
			if(cnt==1) {
				rMap.put("cnt", cnt);
				rMap.put("msg", "수정 성공");
			}
			return rMap;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public Map<String, Object> deleteGame(Game game) throws SQLException {
		gdao.setConnection(DBCon.getCon());
		try {
			int cnt = gdao.deleteGame(game);
			Map<String,Object> rMap = new HashMap<String,Object>();
			rMap.put("cnt", cnt);
			rMap.put("msg", "삭제 실패");
			if(cnt==1) {
				rMap.put("cnt", cnt);
				rMap.put("msg", "삭제 성공");
			}
			return rMap;
		}finally {
			DBCon.close();
		}
	}

}
