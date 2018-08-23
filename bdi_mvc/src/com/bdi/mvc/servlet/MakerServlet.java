package com.bdi.mvc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdi.mvc.service.MakerService;
import com.bdi.mvc.service.Impl.MakerServiceImpl;
import com.bdi.mvc.vo.Maker;

public class MakerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MakerService ms = new MakerServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri ="/views" + request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		try {
			if(cmd.equals("makerList")) {
				List<Maker> makerList = ms.getMakerList(null);
				request.setAttribute("list", makerList);
			}else if(cmd.equals("makerView")) {
				
			}else if(cmd.equals("insertMaker")) {
				
			}else if(cmd.equals("updateMaker")) {
				
			}else if(cmd.equals("deleteMaker")) {
				
			}
		} catch (Exception e) {

		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
