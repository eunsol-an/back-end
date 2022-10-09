package com.myweb.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myweb.www.domain.FileVO;
import com.myweb.www.domain.MemberDTO;
import com.myweb.www.domain.MemberVO;
import com.myweb.www.domain.PagingVO;
import com.myweb.www.repository.MemberDAO;
import com.myweb.www.repository.MemberImgDAO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	private MemberDAO mdao;
	
	@Inject
	private MemberImgDAO midao;

	@Override
	public int register(MemberDTO mdto) {
		int isUp = mdao.insert(mdto.getMvo());
		if (mdto.getFile() != null && isUp > 0) {
			FileVO fvo = mdto.getFile();
			fvo.setEmail(mdto.getMvo().getEmail());
			isUp *= midao.insertImg(fvo);
		}
		return isUp;
	}

	@Override
	public MemberDTO login(MemberVO mvo) {
		return new MemberDTO(mdao.selectOne(mvo), midao.selectImg(mvo.getEmail()));
	}

	@Override
	public List<MemberVO> getList(PagingVO pgvo) {
		return mdao.selectList(pgvo);
	}

	@Override
	public MemberDTO getDetail(String email) {
		return new MemberDTO(mdao.selectDetail(email), midao.selectImg(email));
	}

	@Override
	public int modify(MemberDTO mdto) {
		int isUp = mdao.update(mdto.getMvo());
		if (mdto.getFile() != null && isUp > 0) {
			FileVO fvo = mdto.getFile();
			fvo.setEmail(mdto.getMvo().getEmail());
			isUp *= midao.insertImg(fvo);
		}
		return isUp;
	}

	@Override
	public int remove(String email) {
		int isUp = mdao.delete(email);
		if (isUp > 0) {
			isUp = midao.deleteAllImg(email);
		}
		return isUp;
	}

	@Override
	public int dupleCheck(String email) {
		return mdao.selectEmail(email);
	}

	@Override
	public int getTotalCount(PagingVO pgvo) {
		return mdao.selectTotalCount(pgvo);
	}

	@Override
	public int removeImg(String uuid) {
		return midao.deleteImg(uuid);
	}

}
