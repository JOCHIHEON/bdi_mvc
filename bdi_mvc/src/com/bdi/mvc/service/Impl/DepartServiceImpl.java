package com.bdi.mvc.service.Impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bdi.mvc.common.DBCon;
import com.bdi.mvc.dao.DepartDAO;
import com.bdi.mvc.dao.Impl.DepartDAOImpl;
import com.bdi.mvc.service.DepartService;
import com.bdi.mvc.vo.Depart;

public class DepartServiceImpl implements DepartService {
	private DepartDAO ddao = new DepartDAOImpl();
	@Override
	public List<Depart> getDepartList(Depart depart) throws SQLException {
		ddao.setConnection(DBCon.getCon());
		// DepartDAO에 setConnection 호출  DBCon에서 Connection getCon() 호출
		// 서비스를 동시에 여러개 커넥션 걸어줄 때 사용하기 위해서
		try {
			return ddao.selectDepartList(null);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public Map<String, Object> insertDepart(Depart depart) throws SQLException {
		ddao.setConnection(DBCon.getCon());
		try {
			int cnt = ddao.insertDepart(depart);
			Map<String,Object> rMap = new HashMap<String,Object>();
			rMap.put("cnt", cnt);
			rMap.put("msg", "등록 실패");
			if(cnt==1) {
				rMap.put("cnt", cnt);
				rMap.put("msg", "등록 성공");
			}
			return rMap;
		} catch (SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public Depart getDepart(Depart depart) throws SQLException {
		ddao.setConnection(DBCon.getCon());
		try {
			return ddao.selectDepart(depart);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public Map<String, Object> updateDepart(Depart depart) throws SQLException {
		ddao.setConnection(DBCon.getCon());
		try {
			int cnt = ddao.updateDepart(depart);
			Map<String,Object> rMap = new HashMap<String,Object>();
			rMap.put("cnt", cnt);
			rMap.put("msg", "수정 실패");
			if(cnt==1) {
				rMap.put("cnt", cnt);
				rMap.put("msg", "수정 성공");
			}
			return rMap;
		} catch (SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public Map<String, Object> deleteDepart(Depart depart) throws SQLException {
		ddao.setConnection(DBCon.getCon());
		try {
			int cnt = ddao.deleteDepart(depart);
			Map<String,Object> rMap = new HashMap<String,Object>();
			rMap.put("cnt", cnt);
			rMap.put("msg", "삭제 실패");
			if(cnt==1) {
				rMap.put("cnt", cnt);
				rMap.put("msg", "삭제 성공");
			}
			return rMap;
		} catch (SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}
}
