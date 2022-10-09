package com.myweb.www.service;

import java.util.List;

import com.myweb.www.domain.MemberDTO;
import com.myweb.www.domain.MemberVO;
import com.myweb.www.domain.PagingVO;

public interface MemberService {
	int register(MemberDTO mdto);
	MemberDTO login(MemberVO mvo);
	List<MemberVO> getList(PagingVO pgvo);
	MemberDTO getDetail(String email);
	int modify(MemberDTO mdto);
	int remove(String email);
	int dupleCheck(String email);
	int getTotalCount(PagingVO pgvo);
	int removeImg(String uuid);
}
