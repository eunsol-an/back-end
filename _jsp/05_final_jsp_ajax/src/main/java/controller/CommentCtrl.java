package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import service.CommentService;
import service.CommentServiceImpl;

@WebServlet("/cmt/*")
public class CommentCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CommentCtrl.class);
	private CommentService csv;
	private int isUp;
       
    public CommentCtrl() {
    	csv = new CommentServiceImpl();
    }

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		
		String uri = req.getRequestURI(); // /cmt/list/10
		String path = uri.substring("/cmt/".length()); // list/10
		log.info(">>> path : {}", path);
		
		String pathVar = "";
		if(path.contains("/")) {
			pathVar = path.substring(path.lastIndexOf("/")+1); // 10
			path = path.substring(0, path.lastIndexOf("/")); // list
		}
		
		switch (path) {
		case "post":
			try {
				StringBuffer sb = new StringBuffer();
				String line = null;
				BufferedReader br = req.getReader();
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				log.info(">>> sb : {}", sb.toString());
				
				// 여기서부터 json simple 라이브러리 이용
				JSONParser parser = new JSONParser();
				JSONObject jsonObj = (JSONObject) parser.parse(sb.toString());
				isUp = csv.post(new CommentVO(
						Long.parseLong(jsonObj.get("bno").toString()),
						jsonObj.get("writer").toString(), 
						jsonObj.get("content").toString()));
				PrintWriter out = res.getWriter();
				out.print(isUp);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			log.info(">>> Comment > post > {}", isUp > 0 ? "OK" : "Fail");
			break;
		case "list":
			try {
				List<CommentVO> list = csv.getList(Long.parseLong(pathVar));
				JSONObject[] jsonObjArr = new JSONObject[list.size()];
				JSONArray jsonObjList = new JSONArray();
				
				for (int i = 0; i < list.size(); i++) {
					jsonObjArr[i] = new JSONObject(); // key:value
					jsonObjArr[i].put("cno", list.get(i).getCno());
					jsonObjArr[i].put("bno", list.get(i).getBno());
					jsonObjArr[i].put("writer", list.get(i).getWriter());
					jsonObjArr[i].put("content", list.get(i).getContent());
					jsonObjArr[i].put("mod_at", list.get(i).getMod_at());
					
					jsonObjList.add(jsonObjArr[i]);
				}
				String jsonData = jsonObjList.toJSONString();
				
				PrintWriter out = res.getWriter();
				out.print(jsonData);
			} catch (Exception e) {
				log.info(">>> Comment > list > Error");
			}
			break;
		case "modify":
			try {
				StringBuffer sb = new StringBuffer();
				String line = null;
				BufferedReader br = req.getReader();
				while((line = br.readLine()) != null) {
					sb.append(line);
				}
				log.info(">>> sb : {}", sb.toString());
				JSONParser parser = new JSONParser();
				JSONObject jsonObj = (JSONObject) parser.parse(sb.toString());
				
				isUp = csv.modify(new CommentVO(
						Long.parseLong(jsonObj.get("cno").toString()), 
						jsonObj.get("content").toString()));
				PrintWriter out = res.getWriter();
				out.print(isUp);
			} catch (Exception e) {
				log.info(">>> Comment > modify > Error");
			}
			log.info(">>> Comment > modify > {}", isUp > 0 ? "OK" : "Fail");
			break;
		case "remove":
			try {
				isUp = csv.remove(Long.parseLong(pathVar));
				PrintWriter out = res.getWriter();
				out.print(isUp);
			} catch (Exception e) {
				log.info(">>> Comment > remove > Error");
			}
			log.info(">>> Comment > remove > {}", isUp > 0 ? "OK" : "Fail");
			break;

		default:
			break;
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
