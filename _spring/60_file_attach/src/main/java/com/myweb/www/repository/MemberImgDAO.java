package com.myweb.www.repository;

import com.myweb.www.domain.FileVO;

public interface MemberImgDAO {
	int insertImg(FileVO fvo);
	FileVO selectImg(String email);
	int deleteImg(String uuid);
	int deleteAllImg(String email);
}
