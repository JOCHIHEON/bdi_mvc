package com.bdi.mvc.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdi.mvc.common.DBCon;
import com.bdi.mvc.dao.GameDAO;
import com.bdi.mvc.vo.Game;

public class GameDAOImpl implements GameDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	@Override
	public List<Game> selectGameList(Game game) throws SQLException {
		List<Game> gameList = new ArrayList<Game>();
		String sql = "select * from game_chart";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Game gm = new Game(rs.getInt("gcNum"), 
						rs.getString("gcName"),
						rs.getInt("gcPrice"),
						rs.getString("gcVendor"),
						rs.getInt("gcOrder"),
						rs.getString("gcDesc"),
						rs.getString("gcImg"));
				gameList.add(gm);
			}
		}catch(SQLException e) {
			throw e;
		}
		return gameList;
	}
	@Override
	public void setConnection(Connection con) {
		this.con = con;
		
	}
	@Override
	public int insertGame(Game game) throws SQLException {
		String sql = "insert into game_chart(gcName,gcPrice,gcVendor,gcOrder,gcDesc,gcImg) values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, game.getGcName());
			ps.setInt(2, game.getGcPrice());
			ps.setString(3, game.getGcVendor());
			ps.setInt(4, game.getGcOrder());
			ps.setString(5, game.getGcDesc());
			ps.setString(6, game.getGcImg());
			return ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}
	@Override
	public Game selectGame(Game game) throws SQLException {
		String sql = "select * from game_chart where gcNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, game.getGcNum());
			rs = ps.executeQuery();
			if(rs.next()) {
				return new Game(rs.getInt("gcNum"), 
						rs.getString("gcName"),
						rs.getInt("gcPrice"),
						rs.getString("gcVendor"),
						rs.getInt("gcOrder"),
						rs.getString("gcDesc"),
						rs.getString("gcImg"));
			}
			
		}catch(SQLException e) {
			throw e;
		}
		return null;
	}
	@Override
	public int deleteGame(Game game) throws SQLException {
		String sql = "delete from game_chart where gcNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, game.getGcNum());
			return ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}
	@Override
	public int updateGame(Game game) throws SQLException {
		String sql = "update game_chart set gcName=?,gcPrice=?,gcVendor=?,gcOrder=?,gcDesc=?,gcImg=? where gcNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, game.getGcName());
			ps.setInt(2, game.getGcPrice());
			ps.setString(3, game.getGcVendor());
			ps.setInt(4, game.getGcOrder());
			ps.setString(5, game.getGcDesc());
			ps.setString(6, game.getGcImg());
			ps.setInt(7, game.getGcNum());
			return ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}
}
