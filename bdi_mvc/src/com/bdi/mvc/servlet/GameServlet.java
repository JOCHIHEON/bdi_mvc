package com.bdi.mvc.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdi.mvc.common.UploadFiles;
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
//				game.setGcNum(Integer.parseInt(request.getParameter("gcNum")));
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
				Map<String,String> param = UploadFiles.saveFileList(request);
				if(param.isEmpty()) {
					new ServletException("파일 저장이 실패하였습니다.");
				}
				String gcName = param.get("gcName");
				String gcVendor = param.get("gcVendor");
				String gcDesc = param.get("gcDesc");
				String gcImg = param.get("gcImg");
				int gcPrice = Integer.parseInt(param.get("gcPrice"));
				int gcOrder = Integer.parseInt(param.get("gcOrder"));
				Game game = new Game(null,gcName,gcPrice,gcVendor,gcOrder, gcDesc, gcImg);
				request.setAttribute("rMap", gs.insertGame(game));
			}else if(cmd.equals("gameUpdate")){		
				Map<String,String> param = UploadFiles.saveFileList(request);
				if(param.isEmpty()) {
					new ServletException("파일 수정이 실패하였습니다.");
				}
				String gcName = param.get("gcName");				
				String gcVendor = param.get("gcVendor");				
				String gcDesc = param.get("gcDesc");
				String gcImg = param.get("gcImg");
				int gcNum = Integer.parseInt(param.get("gcNum"));
				int gcPrice = Integer.parseInt(param.get("gcPrice"));
				int gcOrder = Integer.parseInt(param.get("gcOrder"));
				Game game = new Game(gcNum,gcName,gcPrice,gcVendor,gcOrder, gcDesc, gcImg);
				request.setAttribute("rMap", gs.updateGame(game));
			}else if(cmd.equals("gameDelete")){
				Map<String,String> param = UploadFiles.saveFileList(request);
				if(param.isEmpty()) {
					new ServletException("파일 삭제가 실패하였습니다.");
				}
				Game game = new Game(Integer.parseInt(param.get("gcNum")),null,0,null,0, null, null);
				request.setAttribute("rMap", gs.deleteGame(game));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

}
