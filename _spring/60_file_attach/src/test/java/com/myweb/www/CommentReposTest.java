package com.myweb.www;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.www.domain.CommentVO;
import com.myweb.www.repository.CommentDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.myweb.www.config.RootConfig.class })
public class CommentReposTest {
	private static Logger log = LoggerFactory.getLogger(CommentReposTest.class);
	
	@Inject
	private CommentDAO cdao;
	
	@Test
	public void deleteAllCommentTest() throws Exception {
		int isUp = cdao.deleteAll(4);
		log.info(">>> Test of delete all Comment : {}", isUp > 0 ? "OK" : "FAIL");
	}
	
	@Test
	public void deleteCommentTest() throws Exception {
		int isUp = cdao.delete(1);
		log.info(">>> Test of delete Comment : {}", isUp > 0 ? "OK" : "FAIL");
	}
	
	@Test
	public void updateCommentTest() throws Exception {
		int isUp = cdao.update(new CommentVO(4, "update test"));
		log.info(">>> Test of update Comment : {}", isUp > 0 ? "OK" : "FAIL");
	}
	
	@Test
	public void getListCommentListTest() throws Exception {
		List<CommentVO> list = cdao.selectList(4);
		for (CommentVO cvo : list) {
			log.info(">>> {}", cvo);
		}
	}
	
	@Test
	public void insertCommentTest() throws Exception {
//		pno, writer, content
		int isUp = 0;
		for (int i = 0; i < 100; i++) {
			isUp = cdao.insert(new CommentVO(4+i, "TESTER"+i, "comment test"+i));
		}
		log.info(">>> Test of insert Comment : {}", isUp > 0 ? "OK" : "FAIL");
	}
}
