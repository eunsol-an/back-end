package com.myweb.www;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.www.domain.CommentVO;
import com.myweb.www.service.CommentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class CommentSvcTest {
	private static Logger log = LoggerFactory.getLogger(CommentSvcTest.class);
	
	@Inject
	private CommentService csv;
	
	@Test
	public void postCommentTest() throws Exception {
		int isUp = csv.post(new CommentVO(5, "TESTER2", "comment service test"));
		log.info(">>> Test of post Comment : {} ", isUp > 0 ? "OK" : "FAIL");
	}
}
