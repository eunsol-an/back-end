package com.myweb.www;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.www.domain.ProductVO;
import com.myweb.www.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ProductSvcMyTest {
	private static Logger log = LoggerFactory.getLogger(ProductSvcMyTest.class);
	
	@Inject
	ProductService psv;
	
	@Test
	public void removeProductTest() throws Exception {
		int isUp = psv.remove(87L);
		log.info(">>> Test of remove Product : {}", isUp > 0 ? "OK" : "FAIL");
	}
	
	@Test
	public void modifyProductTest() throws Exception {
		int isUp = psv.modify(new ProductVO(87L, "edit", "test1-1", 20000, "It's just test-edit", "tester-edit"));
		log.info(">>> Test of modify Product : {}", isUp > 0 ? "OK" : "FAIL");
	}
	
	@Test
	public void getDetailProductTest() throws Exception {
		ProductVO pvo = psv.getDetail(2);
		log.info(">>> {},{},{},{},{},{},{},{},{},{},{}",
				pvo.getPno(), pvo.getCategory(), pvo.getPname(), pvo.getPrice(),
				pvo.getWriter(), pvo.getDescription(), pvo.getMadeBy(),
				pvo.getRegAt(), pvo.getModAt(), pvo.getReadCount(), pvo.getCmtQty());
	}
	
	@Test
	public void getListProductListTest() throws Exception {
		List<ProductVO> list = psv.getList();
		for (ProductVO pvo : list) {
			log.info(">>> {},{},{},{},{},{},{}",
					pvo.getPno(), pvo.getCategory(), pvo.getPname(), pvo.getPrice(), 
					pvo.getWriter(), pvo.getModAt(), pvo.getReadCount(), pvo.getCmtQty());
		}
	}
	
	@Test
	public void writeProductTest() throws Exception {
		int isUp = psv.write(new ProductVO("cate1-svc", "Test", 10000, "tester1", "This is test", "tester1"));
		log.info(">>> Test of write Product : {}", isUp > 0 ? "OK" : "FAIL");
	}
}
