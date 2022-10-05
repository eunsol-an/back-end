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
import com.myweb.www.repository.ProductDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ProductReposTest {
	private static Logger log = LoggerFactory.getLogger(ProductReposTest.class);
	
	@Inject
	private ProductDAO pdao;
	
	@Test
	public void deleteProductTest() throws Exception {
		int isUp = pdao.delete(88L);
		log.info(">>> Test of delete Product : {}", isUp > 0 ? "OK" : "FAIL");
	}
	
	@Test
	public void updateProductTest() throws Exception {
//		pno, category, pname, price, description, made_by
		int isUp = pdao.update(new ProductVO(88L, "edit", "test1-1", 20000, "It's just test-edit", "tester-edit"));
		log.info(">>> Test of update Product : {}", isUp > 0 ? "OK" : "FAIL");
	}
	
	@Test
	public void getDetailProductTest() throws Exception {
		ProductVO pvo = pdao.selectOne(99L);
		log.info(">>> {},{},{},{},{},{},{},{},{},{},{}",
				pvo.getPno(), pvo.getCategory(), pvo.getPname(), pvo.getPrice(),
				pvo.getWriter(), pvo.getDescription(), pvo.getMadeBy(),
				pvo.getRegAt(), pvo.getModAt(), pvo.getReadCount(), pvo.getCmtQty());
	}
	
	@Test
	public void getListProductListTest() throws Exception {
		List<ProductVO> list = pdao.selectList();
		for (ProductVO pvo : list) {
			log.info(">>> {},{},{},{},{},{},{}",
					pvo.getPno(), pvo.getCategory(), pvo.getPname(), pvo.getPrice(), 
					pvo.getWriter(), pvo.getModAt(), pvo.getReadCount(), pvo.getCmtQty());
		}
	}
	
	@Test
	public void insertProductDummiesTest() throws Exception {
		int isUp = 0;
		for (int i = 0; i < 100; i++) {
			isUp = pdao.insert(new ProductVO("cate"+i, "Test"+i, 10000, "tester"+i, "This is test", "tester"+i));
		}
		log.info(">>> Test of insert Product Dummies : {}", isUp > 0 ? "OK" : "FAIL");
	}
	
	@Test
	public void insertProductTest() throws Exception {
//		category, pname, price, writer, description, made_by
		int isUp = pdao.insert(new ProductVO("cate1", "Test", 10000, "tester1", "This is test", "tester1"));
		log.info(">>> Test of insert Product : {}", isUp > 0 ? "OK" : "FAIL");
	}
}
