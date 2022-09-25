package action.product;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import action.Action;
import domain.ProductVO;
import service.ProductService;
import service.ProductServiceImpl;
public class InsertAction implements Action {
	private static Logger log = LoggerFactory.getLogger(InsertAction.class);

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {		
		int isUp = new ProductServiceImpl().register(new ProductVO(
						req.getParameter("pname"), 
						Double.parseDouble(req.getParameter("price")), 
						req.getParameter("madeby")));
		log.info(">>> Product Register {}", isUp > 0 ? "Success" : "Fail");
	}
}