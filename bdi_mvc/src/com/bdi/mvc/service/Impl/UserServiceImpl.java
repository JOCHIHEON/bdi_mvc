package com.bdi.mvc.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bdi.mvc.dao.UserDAO;
import com.bdi.mvc.dao.Impl.UserDAOImpl;
import com.bdi.mvc.service.UserService;
import com.bdi.mvc.vo.User;

public class UserServiceImpl implements UserService {
	private UserDAO udao = new UserDAOImpl();
	@Override
	public List<User> getUserList(User us) {
		return udao.selectUserList(us);
	}

	@Override
	public User getUser(int uiNo) {
		return udao.getUser(uiNo);
	}

	@Override
	public Map<String, Object> insertUser(User us) {
		Map<String,Object> rMap = new HashMap<String,Object>();
		rMap.put("msg", "등록 실패!");
		rMap.put("success", "false");
		int cnt = udao.insertUser(us);
		if(cnt==1) {
			rMap.put("msg", "정상적으로 등록 되었습니다.");
			rMap.put("success", "true");
		}
		return rMap;
	}

	@Override
	public Map<String, Object> updateUser(User us) {
		Map<String, Object> rMap = new HashMap<String,Object>();
		rMap.put("msg", "수정 실패!");
		rMap.put("success", "false");
		int cnt = udao.updateUser(us);
		if(cnt==1) {
			rMap.put("msg", "정상적으로 수정 되었습니다.");
			rMap.put("success", "true");
		}
		return rMap;
	}

	@Override
	public Map<String, Object> deleteUserO(User us) {
		return null;
	}

}
