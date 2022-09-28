package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import service.BoardService;
import service.BoardServiceImpl;

@WebServlet("/brd/*")
public class BoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(BoardCtrl.class);
	private RequestDispatcher rdp;
	private BoardService bsv;
	private int isUp;
	private String destPage;
       
    public BoardCtrl() {
    	bsv = new BoardServiceImpl();
    }

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		log.info(">>> path : {}", path);
		
		switch (path) {
		case "register":
			destPage = "/board/register.jsp";
			break;
		case "insert":
			isUp = bsv.register(new BoardVO(
					req.getParameter("title"), 
					Integer.parseInt(req.getParameter("price")), 
					req.getParameter("made_by"), 
					req.getParameter("writer"), 
					req.getParameter("category"), 
					req.getParameter("description")));
			log.info(">>> BoardCtrl > Insert > {}", isUp > 0 ? "Success" : "Fail");
			req.setAttribute("msg_reg", isUp);
			destPage = "list";
			break;
		case "list":
			req.setAttribute("list", bsv.getList());
			destPage = "/board/list.jsp";
			break;
		case "detail":
			req.setAttribute("bvo", bsv.getDetail(Long.parseLong(req.getParameter("bno"))));
			destPage = "/board/detail.jsp";
			break;
		case "modify":
			req.setAttribute("bvo", bsv.getDetail(Long.parseLong(req.getParameter("bno"))));
			destPage = "/board/modify.jsp";
			break;
		case "update":
			isUp = bsv.modify(new BoardVO(
					Long.parseLong(req.getParameter("bno")), 
					req.getParameter("title"), 
					Integer.parseInt(req.getParameter("price")), 
					req.getParameter("made_by"), 
					req.getParameter("category"),
					req.getParameter("description")));
			log.info(">>> BoardCtrl > Update > {}", isUp > 0 ? "Success" : "Fail");
			req.setAttribute("msg_mod", isUp);
			destPage = "detail?bno="+req.getParameter("bno");
			break;
		case "remove":
			isUp = bsv.remove(Long.parseLong(req.getParameter("bno")));
			log.info(">>> BoardCtrl > Remove > {}", isUp > 0 ? "Success" : "Fail");
			req.setAttribute("msg_del", isUp);
			destPage = "list";
			break;
			
		default:
			break;
		}
		
		rdp = req.getRequestDispatcher(destPage);
		rdp.forward(req, res);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.getWriter().append("Served at: ").append(req.getContextPath());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
