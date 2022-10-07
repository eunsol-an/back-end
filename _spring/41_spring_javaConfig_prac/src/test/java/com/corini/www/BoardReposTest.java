package com.corini.www;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.corini.www.config.RootConfig;
import com.corini.www.domain.BoardVO;
import com.corini.www.repository.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class BoardReposTest {
	private static Logger log = LoggerFactory.getLogger(BoardReposTest.class);
	
	@Inject
	private BoardDAO bdao;
	
	@Test
	public void deleteBoardTest() throws Exception {
		int isUp = bdao.delete(1);
		log.info(">>> Test of delete Board : {}", isUp > 0? "OK" : "FAIL");
	}
	
	@Test
	public void updateBoardTest() throws Exception {
		int isUp = bdao.update(new BoardVO(1, "test1-1", "this is test 1-1"));
		log.info(">>> Test of update Board : {}", isUp > 0? "OK" : "FAIL");
	}
	
	@Test
	public void selectOneBoardTest() throws Exception {
		BoardVO bvo = bdao.selectOne(1);
		log.info(">>> {}", bvo);
	}
	
	@Test
	public void selectListBoardListTest() throws Exception {
		List<BoardVO> list = bdao.selectList();
		for (BoardVO bvo : list) {
			log.info(">>> {}", bvo);
		}
	}
	
	@Test
	public void insertBoardTest() throws Exception{
		int isUp = bdao.insert(new BoardVO("test", "this is test", "tester"));
		log.info(">>> Test of insert Board : {}", isUp > 0? "OK" : "FAIL");
	}
}
