package com.myweb.www.repository;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myweb.www.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	private final String NS = "MemberMapper.";
	
	@Inject
	private SqlSession sql;

	@Override
	public int insert(MemberVO mvo) {
		return sql.insert(NS+"reg", mvo);
	}

	@Override
	public MemberVO selectOne(MemberVO mvo) {
		return sql.selectOne(NS+"login", mvo);
	}

	@Override
	public List<MemberVO> selectList() {
		return sql.selectList(NS+"list");
	}

	@Override
	public MemberVO selectOne(String email) {
		return sql.selectOne(NS+"detail", email);
	}

	@Override
	public int update(MemberVO mvo) {
		return sql.update(NS+"mod", mvo);
	}

	@Override
	public int delete(String email) {
		return sql.delete(NS+"del", email);
	}

	@Override
	public int selectEmail(String email) {
		return sql.selectOne(NS+"duple", email);
	}

}
