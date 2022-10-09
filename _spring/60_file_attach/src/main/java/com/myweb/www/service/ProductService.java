package com.myweb.www.service;

import java.util.List;

import com.myweb.www.domain.PagingVO;
import com.myweb.www.domain.ProductDTO;
import com.myweb.www.domain.ProductVO;

public interface ProductService {
	int write(ProductDTO pdto);
	List<ProductVO> getList(PagingVO pgvo);
	ProductDTO getDetail(long pno);
	int modify(ProductDTO pdto);
	int remove(long pno);
	int getTotalCount(PagingVO pgvo);
	int removeFile(String uuid);
}
