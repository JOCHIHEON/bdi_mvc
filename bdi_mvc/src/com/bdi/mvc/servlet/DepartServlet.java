package com.bdi.mvc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdi.mvc.service.DepartService;
import com.bdi.mvc.service.Impl.DepartServiceImpl;
import com.bdi.mvc.vo.Depart;

public class DepartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DepartService ds = new DepartServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		try {
			if(cmd.equals("departList")) {
				uri = "/views" + uri;
				request.setAttribute("departList", ds.getDepartList(null));
			}else if(cmd.equals("departView")){
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "/views" + request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		request.setCharacterEncoding("utf-8");
		try {
			if(cmd.equals("departInsert")) {
				String diName = request.getParameter("diName");
				String diDesc = request.getParameter("diDesc");
				Depart depart = new Depart(null, diName, diDesc, null);
				request.setAttribute("rMap", ds.insertDepart(depart));
			}else if(cmd.equals("departUpdate")){
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

}
