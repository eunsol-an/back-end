package com.myweb.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myweb.www.domain.CommentVO;
import com.myweb.www.repository.CommentDAO;

@Service
public class CommentServiceImpl implements CommentService {

	@Inject
	private CommentDAO cdao;
	
	@Override
	public int post(CommentVO cvo) {
		return cdao.insert(cvo);
	}

	@Override
	public List<CommentVO> getList(long pno) {
		return cdao.selectList(pno);
	}

	@Override
	public int modify(CommentVO cvo) {
		return cdao.update(cvo);
	}

	@Override
	public int remove(long cno) {
		return cdao.delete(cno);
	}

	@Override
	public int removeAll(long pno) {
		return cdao.deleteAll(pno);
	}

}
