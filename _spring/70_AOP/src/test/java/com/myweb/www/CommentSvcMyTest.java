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
@ContextConfiguration(classes = { com.myweb.www.config.RootConfig.class })
public class CommentSvcMyTest {
	private static Logger log = LoggerFactory.getLogger(CommentSvcMyTest.class);
	
	@Inject
	private CommentService csv;
	
	@Test
	public void postCommentTest() throws Exception {
		int isUp = csv.post(new CommentVO(5, "TESTER2", "comment service test"));
		log.info(">>> Test of post Comment : {} ", isUp > 0 ? "OK" : "FAIL");
	}
	
	@Test
	public void postCommentDummiesTest() throws Exception {
		for (int i = 0; i < 25; i++) {
			csv.post(new CommentVO(260, "tester" + i + "@tester.com", "Comment Dummy"));
		}
	}
}
