package service;

import java.util.List;

import domain.RepliesVO;

public interface RepliesService {
	public int post(RepliesVO rvo);
	public List<RepliesVO> getList(int pno);
	public int modify(RepliesVO rvo);
	public int remove(long rno);
	public int removeAll(int pno);
}
