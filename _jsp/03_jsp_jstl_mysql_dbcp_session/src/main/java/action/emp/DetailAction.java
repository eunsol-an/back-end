package action.emp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import action.Action;
import domain.EmpVO;
import service.EmpService;
import service.EmpServiceImpl;
public class DetailAction implements Action {
	private static Logger log = LoggerFactory.getLogger(DetailAction.class);

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
//		EmpService esv = new EmpServiceImpl();
//		EmpVO evo = esv.detail(Integer.parseInt(req.getParameter("empno")));
//		req.setAttribute("evo", evo);
		// 한 줄로 축약 가능
		req.setAttribute("evo", new EmpServiceImpl().detail(
				Integer.parseInt(req.getParameter("empno"))));
	}
}
