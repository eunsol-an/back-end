package action.product;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import action.Action;
import domain.ProductVO;
import service.ProductServiceImpl;
public class ModifyAction implements Action {
	private static Logger log = LoggerFactory.getLogger(ModifyAction.class);

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		int isUp = new ProductServiceImpl().modify(
				new ProductVO(Integer.parseInt(req.getParameter("pno")),
						req.getParameter("pname"),
						Double.parseDouble(req.getParameter("price")), 
						req.getParameter("madeby")));
		log.info(">>> Product Modify {}", isUp > 0 ? "Success" : "Fail");

	}
}
