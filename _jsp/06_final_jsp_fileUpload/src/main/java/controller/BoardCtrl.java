package controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import handler.FileHandler;
import net.coobird.thumbnailator.Thumbnails;
import service.BoardService;
import service.BoardServiceImpl;
import service.CommentService;
import service.CommentServiceImpl;

@WebServlet("/brd/*")
public class BoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(BoardCtrl.class);
	private final String UTF8 = "utf-8";
	private RequestDispatcher rdp;
	private BoardService bsv;
	private CommentService csv; // delete all 해보기
	private int isUp;
	private String destPage;
	private String savePath;
       
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
			try {
				savePath = getServletContext().getRealPath("/_fileUpload");
				File fileDir = new File(savePath);
				log.info(">>> savePath > {}",savePath);
				
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				fileItemFactory.setRepository(fileDir);
				fileItemFactory.setSizeThreshold(2*1024*1024); // 저장을 위한 임시 메모리 저장용량 : byte단위
				// 업로드된 파일을 저장할 저장소 준비 끝
				
				BoardVO bvo = new BoardVO();
				ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
				// request 객체를 분해해서 담을 공간
				
				List<FileItem> itemList = fileUpload.parseRequest(req);
				// parseRequest() 메서드를 수행하면 FileItem이라는 형식으로 변함
				for (FileItem item : itemList) {
					log.info(item.getFieldName());
					switch (item.getFieldName()) { // input 태그의 name값 
					case "title":
						bvo.setTitle(item.getString(UTF8));
						break;
					case "price":
						bvo.setPrice(Integer.parseInt(item.getString(UTF8)));
						break;
					case "made_by":
						bvo.setMade_by(item.getString(UTF8));
						break;
					case "writer":
						bvo.setWriter(item.getString(UTF8));
						break;
					case "category":
						bvo.setCategory(item.getString(UTF8));
						break;
					case "description":
						bvo.setDescription(item.getString(UTF8));
						break;
					case "imageFile":
						if (item.getSize() > 0) { // 파일의 크기가 0 이상이라면 = 첨부파일이라면
							String fileName = item.getName() // 경로가 포함된 전체 이름
									.substring(item.getName().lastIndexOf(File.separator)+1);
							// \로 구분된 경로 이후의 파일이름
							
							// 실제 저장될 path로 파일을 객체화
							fileName = System.currentTimeMillis() + "_" + fileName; // 중복 방지
							File UploadFilePath = new File(fileDir + File.separator + fileName);
							
							try {
								item.write(UploadFilePath); // 자바객체를 디스크에 쓰기
								bvo.setImage_file(fileName);
								log.info(">>> File Write on disk Success");
								
								// 썸네일 만드는 작업
								Thumbnails.of(UploadFilePath)
								.size(75, 75)
								.toFile(new File(fileDir + File.separator + "th_" + fileName));
								
								// 썸네일 작업 필요 : 리스트 페이지에서 트래픽 과다사용 방지
							} catch (Exception e) {
								log.info(">>> File Write on disk Fail");
								e.printStackTrace();
							}
						}
						isUp = bsv.register(bvo);
						log.info(">>> BoardCtrl > insert > {}", isUp > 0 ? "OK" : "Fail");
						destPage = "list";
						break;
// \.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\06_final_jsp_fileUpload\_fileUpload
					default:
						break;
					}
				}
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			
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
			savePath = getServletContext().getRealPath("/_fileUpload");
			File fileDir = new File(savePath);
			log.info(">>> savePath > {}",savePath);
			
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			fileItemFactory.setRepository(fileDir);
			fileItemFactory.setSizeThreshold(2*1024*1024); // 저장을 위한 임시 메모리 저장용량 : byte단위
			// 업로드된 파일을 저장할 저장소 준비 끝
			
			BoardVO bvo = new BoardVO();
			ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
			// request 객체를 분해해서 담을 공간
			
			try {
				List<FileItem> itemList = fileUpload.parseRequest(req);
				// parseRequest() 메서드를 수행하면 FileItem이라는 형식으로 변함
				String old_file = null;
				for (FileItem item : itemList) {
					log.info(item.getFieldName());
					switch (item.getFieldName()) { // input 태그의 name값 
					case "bno":
						bvo.setBno(Long.parseLong(item.getString(UTF8)));
						break;
					case "title":
						bvo.setTitle(item.getString(UTF8));
						break;
					case "price":
						bvo.setPrice(Integer.parseInt(item.getString(UTF8)));
						log.info("in price case");
						break;
					case "made_by":
						bvo.setMade_by(item.getString(UTF8));
						break;
					case "category":
						bvo.setCategory(item.getString(UTF8));
						break;
					case "description":
						bvo.setDescription(item.getString(UTF8));
						break;
					case "image_file":
						old_file = item.getString(UTF8);
						break;
					case "new_file":
						if (item.getSize() > 0) { // 파일의 크기가 0 이상이라면 = 첨부파일이라면
							
							if (old_file != null) {
								FileHandler fileHandler = new FileHandler();
								savePath = getServletContext().getRealPath("/_fileUpload");
								isUp = fileHandler.deleteFile(old_file, savePath);
							}
							
							String fileName = item.getName() // 경로가 포함된 전체 이름
									.substring(item.getName().lastIndexOf(File.separator)+1);
							// \로 구분된 경로 이후의 파일이름
							
							// 실제 저장될 path로 파일을 객체화
							fileName = System.currentTimeMillis() + "_" + fileName; // 중복 방지
							File UploadFilePath = new File(fileDir + File.separator + fileName);
							
							try {
								item.write(UploadFilePath); // 자바객체를 디스크에 쓰기
								bvo.setImage_file(fileName);
								log.info(">>> File Write on disk Success");
								
								// 썸네일 만드는 작업
								Thumbnails.of(UploadFilePath)
								.size(75, 75)
								.toFile(new File(fileDir + File.separator + "th_" + fileName));
								
								// 썸네일 작업 필요 : 리스트 페이지에서 트래픽 과다사용 방지
							} catch (Exception e) {
								log.info(">>> File Write on disk Fail");
								e.printStackTrace();
							}
						}else {
							bvo.setImage_file(old_file);
						}
						isUp = bsv.modify(bvo);
						log.info(">>> BoardCtrl > Update > {}", isUp > 0 ? "Success" : "Fail");
						req.setAttribute("msg_mod", isUp);
						destPage = "detail?bno="+bvo.getBno();
						break;
//\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\06_final_jsp_fileUpload\_fileUpload
					default:
						break;
					}
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			break;
		case "remove":
			long bno = Long.parseLong(req.getParameter("bno"));
			String imageFileName = bsv.getImgFileName(bno);
			
			isUp = bsv.remove(bno);
			log.info(">>> BoardCtrl > Remove > {}", isUp > 0 ? "Success" : "Fail");
			
			FileHandler fileHandler = new FileHandler();
			savePath = getServletContext().getRealPath("/_fileUpload");
			isUp = fileHandler.deleteFile(imageFileName, savePath);
			
			if (isUp > 0) {
				isUp = bsv.removeFile(bno);
			}
			
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
