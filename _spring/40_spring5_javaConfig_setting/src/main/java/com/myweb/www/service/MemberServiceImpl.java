package com.myweb.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myweb.www.domain.MemberVO;
import com.myweb.www.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAO mdao;

	@Override
	public int register(MemberVO mvo) {
		return mdao.insert(mvo);
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		return mdao.selectOne(mvo);
	}

	@Override
	public List<MemberVO> getList() {
		return mdao.selectList();
	}

	@Override
	public MemberVO getDetail(String email) {
		return mdao.selectDetail(email);
	}

	@Override
	public int modify(MemberVO mvo) {
		return mdao.update(mvo);
	}

	@Override
	public int remove(String email) {
		return mdao.delete(email);
	}

	@Override
	public int dupleCheck(String email) {
		return mdao.selectEmail(email);
	}

}
