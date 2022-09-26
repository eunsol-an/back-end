package action.emp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import action.Action;
import domain.EmpVO;
import service.EmpService;
import service.EmpServiceImpl;
public class InsertAction implements Action {
	private static Logger log = LoggerFactory.getLogger(InsertAction.class);

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		EmpService esv = new EmpServiceImpl();
		int isUp = esv.register(new EmpVO(Integer.parseInt(req.getParameter("empno")), 
				req.getParameter("pwd"), 
				req.getParameter("ename")));
		log.info(">>> Emp Register {}", isUp > 0 ? "Success" : "Fail");
		
	}
}
