package controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import action.Action;
import action.emp.DetailAction;
import action.emp.InsertAction;
import action.emp.ListAction;
import action.emp.ModifyAction;
import action.emp.RemoveAction;
public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(EmpController.class);
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); // view -> java 인코딩
		resp.setCharacterEncoding("utf-8"); // java -> view 인코딩
		resp.setContentType("text/html; charset=utf-8"); // 화면 출력 담당 브라우저에 전달하는 문자코드 및 형식 지정
		
		String uri = req.getRequestURI();
		log.info(">>> uri > {}", uri);
		String context = req.getContextPath();
		log.info(">>> context > {}", context);
		String path = uri.substring(context.length());
		log.info(">>> path > {}", path);
		path = path.substring(path.lastIndexOf("/")+1);
		
		String destPage = "";
		Action action = null;
		switch (path) {
		case "register.em":
			destPage = "/emp/register.jsp";
			break;
		case "insert.em":
			action = new InsertAction();
			action.execute(req, resp);
			destPage = "list.em";
			break;
		case "list.em":
			action = new ListAction();
			action.execute(req, resp);
			destPage = "/emp/list.jsp";
			break;
		case "detail.em":
			action = new DetailAction();
			action.execute(req, resp);
			destPage = "/emp/detail.jsp";
			break;
		case "modify.em":
			action = new DetailAction();
			action.execute(req, resp);
			destPage = "/emp/modify.jsp";
			break;
		case "update.em":
			action = new ModifyAction();
			action.execute(req, resp);
			destPage = "detail.em?empno="+req.getParameter("empno");
			break;
		case "remove.em":
			action = new RemoveAction();
			action.execute(req, resp);
			destPage = "list.em";
			break;
		default:
			break;
		}
		RequestDispatcher rdp = req.getRequestDispatcher(destPage);
		rdp.forward(req, resp);
		
	}
	
	
}
