package com.bdi.mvc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdi.mvc.service.UserService;
import com.bdi.mvc.service.Impl.UserServiceImpl;
import com.bdi.mvc.vo.User;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "/views"+request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		try {
			if(cmd.equals("userList")) {
				List<User> userList = us.getUserList(null);
				request.setAttribute("list", userList);
			}if(cmd.equals("userView") || cmd.equals("userUpdate")) {
				String uiNoStr = request.getParameter("uiNo");
				if(uiNoStr==null) {
					request.setAttribute("msg", "유저 넘버 없이 화면 요청은 불가능 합니다.");
					response.sendError(HttpServletResponse.SC_NOT_FOUND);
					return;
				}
				int uiNo = Integer.parseInt(uiNoStr);
				request.setAttribute("user", us.getUser(uiNo));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "/views"+request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		request.setCharacterEncoding("UTF-8");
		try {
			if(cmd.equals("userUpdate")) {
				String uiNo = request.getParameter("uiNo");
				String uiName = request.getParameter("uiName");
				String uiId = request.getParameter("uiId");
				String uiPwd = request.getParameter("uiPwd");
				String uiDesc = request.getParameter("uiDesc");
				String uiAge = request.getParameter("uiAge");
				String diNo = request.getParameter("diNo");
				User ui = new User(Integer.parseInt(uiNo), uiName, uiId, uiPwd, uiDesc, Integer.parseInt(uiAge), Integer.parseInt(diNo));
				request.setAttribute("rMap", us.updateUser(ui));
			} else if(cmd.equals("userInsert")) {
				String uiNo = request.getParameter("uiNo");
				String uiName = request.getParameter("uiName");
				String uiId = request.getParameter("uiId");
				String uiPwd = request.getParameter("uiPwd");
				String uiDesc = request.getParameter("uiDesc");
				String uiAge = request.getParameter("uiAge");
				String diNo = request.getParameter("diNo");
				User ui = new User(0, uiName, uiId, uiPwd, uiDesc, Integer.parseInt(uiAge), Integer.parseInt(diNo));
				request.setAttribute("rMap", us.insertUser(ui));
			} else if(cmd.equals("userDelete")) {
				String uiNo = request.getParameter("uiNo");
				User ui = new User(Integer.parseInt(uiNo), null, null, null, null, 0, 0);
				request.setAttribute("rMap", us.deleteUser(ui));
				uri = "/views/user/userView";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}
}
