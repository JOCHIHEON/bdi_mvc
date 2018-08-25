package com.bdi.mvc.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bdi.mvc.common.DBCon;
import com.bdi.mvc.dao.UserDAO;
import com.bdi.mvc.vo.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public List<User> selectUserList(User us) {
		List<User> list = new ArrayList<User>();
		Connection con = DBCon.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from user_info";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				us = new User(rs.getInt("uiNo"),
						rs.getString("uiName"),
						rs.getString("uiId"),
						rs.getString("uiPwd"),
						rs.getString("uiDesc"),
						rs.getInt("uiAge"),
						rs.getInt("diNo"));
				list.add(us);
			}
		} catch (SQLException e) {
			
		} finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			DBCon.close();
		}
		return list;
	}

	@Override
	public User getUser(int uiNo) {
		Connection con = DBCon.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select uiNo,uiName,uiId,uiPwd,uiDesc,uiAge,diNo from user_info where uiNo=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1,uiNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				User us = new User(rs.getInt("uiNo"),
						rs.getString("uiName"),
						rs.getString("uiId"),
						rs.getString("uiPwd"),
						rs.getString("uiDesc"),
						rs.getInt("uiAge"),
						rs.getInt("diNo"));
				return us;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					
					ps.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			DBCon.close();
		}
		return null;
	}

	@Override
	public int insertUser(User us) {
		Connection con = DBCon.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into user_info(uiName,uiId,uiPwd,uiDesc,uiAge,diNo) values(?,?,?,?,?,?)";
		int cnt= 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, us.getUiname());
			ps.setString(2, us.getUiid());
			ps.setString(3, us.getUipwd());
			ps.setString(4, us.getUidesc());
			ps.setInt(5, us.getUiage());
			ps.setInt(6, us.getDino());
			cnt = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			DBCon.close();
		}
		return cnt;
	}

	@Override
	public int updateUser(User us) {
		Connection con = DBCon.getCon();
		String sql = "update user_info set uiName=?,uiId=?,uiPwd=?,uiDesc=?,uiAge=?,diNo=? where uiNo=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, us.getUiname());
			ps.setString(2, us.getUiid());
			ps.setString(3, us.getUipwd());
			ps.setString(4, us.getUidesc());
			ps.setInt(5, us.getUiage());
			ps.setInt(6, us.getDino());
			ps.setInt(7, us.getUino());
			return ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			DBCon.close();
		}
		return 0;
	}

	@Override
	public int deleteUser(int uiNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
