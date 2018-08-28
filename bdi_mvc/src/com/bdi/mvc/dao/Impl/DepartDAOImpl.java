package com.bdi.mvc.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdi.mvc.common.DBCon;
import com.bdi.mvc.dao.DepartDAO;
import com.bdi.mvc.vo.Depart;

public class DepartDAOImpl implements DepartDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	@Override
	public List<Depart> selectDepartList(Depart depart) throws SQLException {
		List<Depart> departList = new ArrayList<Depart>();
		String sql = "select * from depart_info";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Depart dp = new Depart(rs.getInt("diNo"), 
						rs.getString("diName"),
						rs.getString("diDesc"),
						rs.getInt("diCnt"));
				departList.add(dp);
			}
		}catch(SQLException e) {
			throw e;
		}
		return departList;
	}
	public static void main(String[] args) {
		DepartDAO ddao = new DepartDAOImpl();
		try {
			System.out.println(ddao.selectDepartList(null));
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.close();
		}
	}
	@Override
	public void setConnection(Connection con) {
		this.con = con;
		
	}
	@Override
	public int insertDepart(Depart depart) throws SQLException {
		String sql = "insert into depart_info(diName,diDesc) values(?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, depart.getDiName());
			ps.setString(2, depart.getDiDesc());
			return ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}

}
