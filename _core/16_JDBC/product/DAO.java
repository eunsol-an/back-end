package product;

import java.util.List;

public interface DAO { // Data Access Object
	int insert(ProductVO pvo);
	List<ProductVO> select();
	ProductVO selectOne(int pno);
	int update(ProductVO pvo);
	int delete(int pno);
}
