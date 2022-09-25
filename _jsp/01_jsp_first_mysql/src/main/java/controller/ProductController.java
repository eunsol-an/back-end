package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ProductVO;
import service.ProductService;
import service.Service;

public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 상품등록, 상품리스트, 상품상세, 상품수정, 상품삭제
	// 데이터베이스 연동한 후 컨트롤러에서 모든 메뉴 분기 처리
	// 서비스는 컨트롤러에서 호출, DAO는 서비스가 호출
	private Service svc;
	
	public ProductController() {
		svc = new ProductService();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		String uri = req.getRequestURI(); // 전체 요청 경로(원하는 서비스?)
		System.out.println(">>> uri : " + uri);
		String context = req.getContextPath(); // 프로젝트 명
		System.out.println(">>> context :" + context);
		String path = uri.substring(context.length());
		System.out.println(">>> path : " +  path); // 서비스 요청 경로
		
		String destPage = "";
		if (path.equals("/product/register.pd")) {
			destPage = "/product/register.jsp";
		}
		else if (path.equals("/product/insert.pd")) {
			// service에서 필요한 pvo를 만들어 service를 호출한다
			ProductVO pvo = new ProductVO();
			pvo.setPname(req.getParameter("pname"));
			pvo.setPrice(Integer.parseInt(req.getParameter("price")));
			pvo.setMadeby(req.getParameter("madeBy"));
			
			svc.register(pvo);
			destPage = "/index.jsp";
			
//			svc.register(new ProductVO(
//					req.getParameter("pname"),
//					Integer.parseInt(req.getParameter("price")),
//					req.getParameter("madeBy")));
		}
		else if(path.equals("/product/list.pd")) {
			destPage = "/product/list.jsp";
			req.setAttribute("list", svc.list());
		}
		else if(path.equals("/product/detail.pd")) {
			destPage = "/product/detail.jsp";
			req.setAttribute("pvo",
					svc.detail(Integer.parseInt(req.getParameter("pno"))));
		}
		else if(path.equals("/product/edit.pd")) {
			destPage = "/product/edit.jsp";
			req.setAttribute("pvo",
					svc.detail(Integer.parseInt(req.getParameter("pno"))));
		}
		else if(path.equals("/product/modify.pd")) {
			destPage = "/index.jsp";
			svc.edit(new ProductVO(
					Integer.parseInt(req.getParameter("pno")),
					req.getParameter("pname"),
					Integer.parseInt(req.getParameter("price")),
					req.getParameter("madeBy")));
			
		}
		else if(path.equals("/product/remove.pd")) {
			destPage = "/index.jsp";
			svc.remove(Integer.parseInt(req.getParameter("pno")));
		}
		RequestDispatcher rdp = req.getRequestDispatcher(destPage);
		rdp.forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		service(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		service(req, resp);
	}
}
