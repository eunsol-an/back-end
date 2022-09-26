package action.emp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import action.Action;
import domain.EmpVO;
import service.EmpService;
import service.EmpServiceImpl;

public class LoginAction implements Action {
	private static Logger log = LoggerFactory.getLogger(LoginAction.class);

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		int empno = Integer.parseInt(req.getParameter("empno"));
		String pwd = req.getParameter("pwd");
		
		EmpService esv = new EmpServiceImpl();
		EmpVO evo = esv.login(empno, pwd);
		
		if(evo != null) { // 로그인이 되면,
			HttpSession ses = req.getSession(); // 세션 객체 생성
			ses.setAttribute("ses", evo); // 세션에 evo 객체 정보를 저장
			ses.setMaxInactiveInterval(60 * 10); // 세션 만료시간 설정 (초단위)
		}else { // 로그인이 되지 않으면,
			req.setAttribute("msg_login", 0); // 리퀘스트 객체로 0을 보냄
		}
	}

}