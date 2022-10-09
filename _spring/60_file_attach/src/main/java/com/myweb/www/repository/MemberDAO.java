package com.myweb.www.repository;

import java.util.List;

import com.myweb.www.domain.MemberVO;
import com.myweb.www.domain.PagingVO;

public interface MemberDAO {
	int insert(MemberVO mvo); // register
	MemberVO selectOne(MemberVO mvo); // login
	List<MemberVO> selectList(PagingVO pgvo); // list
	MemberVO selectDetail(String email); // detail
	int update(MemberVO mvo); // modify
	int delete(String email); // remove
	int selectEmail(String email); // id 증복확인
	int selectTotalCount(PagingVO pgvo); // 페이지네이션 할 멤버 총인원
	String selectLastEmail();
}
