package com.myweb.www;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.www.domain.MemberVO;
import com.myweb.www.domain.ProductVO;
import com.myweb.www.repository.ProductDAO;
import com.myweb.www.service.MemberService;
import com.myweb.www.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.myweb.www.config.RootConfig.class })
public class ProductSvcTest {
	private static Logger log = LoggerFactory.getLogger(ProductSvcTest.class);

	@Inject
	private ProductService psv;

	@Test
	public void insertProductDummyTest() throws Exception {
		for (int i = 1; i <= 256; i++) {
			psv.write(
					new ProductVO(
							"cate"+(i%10), "Product Title"+i, (int)(Math.random()*5001)+5000,
							"tester"+(int)(Math.random()*100)+"@tester.com",
							"DESC-SA", "STAKEHOLDERS"));
		}
	}
}
