package com.bdi.mvc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdi.mvc.service.GameService;
import com.bdi.mvc.service.Impl.GameServiceImpl;
import com.bdi.mvc.vo.Game;

public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private GameService gs = new GameServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = "/views" +request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		try {
			if(cmd.equals("gameList")) {
				request.setAttribute("gameList", gs.getGameList(null));
			}else if(cmd.equals("gameView")||cmd.equals("gameUpdate")){
				String GcNumStr = request.getParameter("gcNum");
				Game game = new Game();
				game.setGcNum(Integer.parseInt(GcNumStr));
				request.setAttribute("game", gs.getGame(game));
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
			if(cmd.equals("gameInsert")) {
				String gcName = request.getParameter("gcName");
				String gcVendor = request.getParameter("gcVendor");
				String gcDesc = request.getParameter("gcDesc");
				String gcImg = request.getParameter("gcImg");
				Game game = new Game(null,gcName,Integer.parseInt(request.getParameter("gcPrice")),gcVendor,
						Integer.parseInt(request.getParameter("gcOrder")), gcDesc, gcImg);
				request.setAttribute("rMap", gs.insertGame(game));
			}else if(cmd.equals("gameUpdate")){
				String gcName = request.getParameter("gcName");
				String gcPrice = request.getParameter("gcPrice");
				String gcVendor = request.getParameter("gcVendor");
				String gcOrder = request.getParameter("gcOrder");
				String gcDesc = request.getParameter("gcDesc");
				String gcImg = request.getParameter("gcImg");
				Game game = new Game(Integer.parseInt("gcNum"),gcName,Integer.parseInt(request.getParameter(gcPrice)),gcVendor,
						Integer.parseInt(request.getParameter(gcOrder)), gcDesc, gcImg);
				request.setAttribute("rMap", gs.updateGame(game));
			}else if(cmd.equals("gameDelete")){
				Game game = new Game(Integer.parseInt("gcNum"),null,0,null,0, null, null);
				request.setAttribute("rMap", gs.deleteGame(game));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

}