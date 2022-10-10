package com.myweb.www.service;

import java.util.List;

import com.myweb.www.domain.MemberVO;
import com.myweb.www.domain.PagingVO;

public interface MemberService {
	int register(MemberVO mvo);
	MemberVO login(MemberVO mvo);
	List<MemberVO> getList(PagingVO pgvo);
	MemberVO getDetail(String email);
	int modify(MemberVO mvo);
	int remove(String email);
	int dupleCheck(String email);
	int getTotalCount(PagingVO pgvo);
}
