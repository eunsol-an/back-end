package com.myweb.www;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myweb.www.domain.MemberVO;
import com.myweb.www.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { com.myweb.www.config.RootConfig.class })
public class MemberSvcTest {
	private static Logger log = LoggerFactory.getLogger(MemberSvcTest.class);
	
	@Inject
	private MemberService msv;
	
	@Test
	public void removeMemberTest() {
		int isUp = msv.remove("tester@tester.com");
		log.info(">>> Test of remove Member : {} ", isUp > 0 ? "OK" : "FAIL");
	}
	
	@Test
	public void modifyMemberTest() {
		int isUp = msv.modify(new MemberVO("tester@tester.com", "2222", "tester1-1", 20));
		log.info(">>> Test of modify Member : {} ", isUp > 0 ? "OK" : "FAIL");
	}
	
	@Test
	public void getDetailMemberTest() {
		MemberVO mvo = msv.getDetail("tester@tester.com");
		log.info(">>> {},{},{},{},{}", 
				mvo.getEmail(), mvo.getNickName(), mvo.getLastLogin(), 
				mvo.getRegAt(), mvo.getGrade());
	}
	
	@Test
	public void loginMemberTest() {
		MemberVO mvo = msv.login(new MemberVO("tester@tester.com", "1111"));
		log.info(">>> {},{},{},{}", mvo.getEmail(), mvo.getNickName(), mvo.getLastLogin(), mvo.getGrade());
	}
	
	@Test
	public void getListMemberListTest() {
		List<MemberVO> list = msv.getList();
		for (MemberVO mvo : list) {
			log.info(">>> {},{},{},{},{}", 
					mvo.getEmail(), mvo.getNickName(), mvo.getLastLogin(), 
					mvo.getRegAt(), mvo.getGrade());
		}
	}
	
	@Test
	public void registerMemberTest() {
		int isUp = msv.register(new MemberVO("tester@tester.com", "1111", "tester"));
		log.info(">>> Test of register Member : {} ", isUp > 0 ? "OK" : "FAIL");
	}
}
