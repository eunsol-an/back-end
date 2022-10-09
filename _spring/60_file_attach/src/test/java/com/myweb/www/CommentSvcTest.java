package com.myweb.www;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.www.domain.CommentVO;
import com.myweb.www.domain.MemberVO;
import com.myweb.www.domain.ProductVO;
import com.myweb.www.repository.ProductDAO;
import com.myweb.www.service.CommentService;
import com.myweb.www.service.MemberService;
import com.myweb.www.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.myweb.www.config.RootConfig.class })
public class CommentSvcTest {

	@Inject
	private CommentService csv;

	@Test
	public void insertCommentDummiesTest() throws Exception {
		for (int j = 1; j <= 256; j++) {
			int x = (int) (Math.random() * 256);
			for (int i = 0; i < x; i++) {
				csv.post(new CommentVO(j,
						"tester" + ((int) (Math.random() * 256)) + "@tester.com",
						"Comment Dummy Content for" + j));
			}
		}
	}
}
