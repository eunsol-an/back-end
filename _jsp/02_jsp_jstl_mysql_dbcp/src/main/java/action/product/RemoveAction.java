package action.product;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import action.Action;
import service.ProductServiceImpl;
public class RemoveAction implements Action {
	private static Logger log = LoggerFactory.getLogger(RemoveAction.class);

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		int isUp = new ProductServiceImpl().remove(Integer.parseInt(req.getParameter("pno")));
		log.info(">>> Product Remove {}", isUp > 0 ? "Success" : "Fail");
	}
}
