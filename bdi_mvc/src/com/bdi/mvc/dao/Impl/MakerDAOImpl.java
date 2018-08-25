package com.bdi.mvc.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bdi.mvc.common.DBCon;
import com.bdi.mvc.dao.MakerDAO;
import com.bdi.mvc.vo.Maker;

public class MakerDAOImpl implements MakerDAO {

	@Override
	public List<Maker> selectMakerList(Maker mk) {
		List<Maker> list = new ArrayList<Maker>();
		Connection con = DBCon.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select mNum, mName, mPrice, mCnt, mTotal, mDesc from maker";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				mk = new Maker(rs.getInt("mNum"),
							rs.getString("mName"),
							rs.getInt("mPrice"),
							rs.getInt("mCnt"),
							rs.getInt("mTotal"),
							rs.getString("mDesc"));
				list.add(mk);
			}
			
		} catch (SQLException e) {
			
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
		return list;
	}

	@Override
	public Maker selectMaker(int mNum) {
		Connection con = DBCon.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select mNum, mName, mPrice, mCnt, mTotal, mDesc from maker where mNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, mNum);
			rs = ps.executeQuery();
			if(rs.next()) {
				Maker mk = new Maker(rs.getInt("mNum"),
							rs.getString("mName"),
							rs.getInt("mPrice"),
							rs.getInt("mCnt"),
							rs.getInt("mTotal"),
							rs.getString("mDesc"));
				return mk;
			}
			
		} catch (SQLException e) {
			
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
		return null;
	}

	@Override
	public int insertMaker(Maker mk) {
		Connection con = DBCon.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into maker(mName, mPrice, mCnt, mTotal, mDesc) values(?,?,?,?,?)";
		int cnt = 0;
		try {
			ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, mk.getMname());
			ps.setInt(2, mk.getMprice());
			ps.setInt(3, mk.getMcnt());
			ps.setInt(4, mk.getMtotal());
			ps.setString(5, mk.getMdesc());
			cnt += ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				int mNum = rs.getInt(1);;
				cnt += updateMakerTotal(mNum);
			}
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
	public int updateMaker(Maker mk) {
		Connection con = DBCon.getCon();
		String sql = "update maker set mName=?, mPrice=?, mCnt=?, mDesc=? where mNum=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mk.getMname());
			ps.setInt(2, mk.getMprice());
			ps.setInt(3, mk.getMcnt());
			ps.setString(4, mk.getMdesc());
			ps.setInt(5, mk.getMnum());
			return ps.executeUpdate();
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
		return 0;
	}

	@Override
	public int deleteMaker(Maker mk) {
		Connection con = DBCon.getCon();
		String sql = "delete from maker where mNum=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, mk.getMnum());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close();
		}
		return 0;
	}
	
	@Override
	public int updateMakerTotal(int mNum) {
		Connection con = DBCon.getCon();
		String sql = "update maker set mTotal=mCnt * mPrice where mNum=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, mNum);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBCon.close();
		}
		return 0;
	}

}
