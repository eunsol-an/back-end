package product;

import java.util.List;

public class ProductService implements Service {
	private DAO dao;
	
	public ProductService() {
		dao = new ProductDAO();
	}

	@Override
	public int register(ProductVO pvo) {
		// TODO Auto-generated method stub
		return dao.insert(pvo);
	}

	@Override
	public List<ProductVO> list() {
		// TODO Auto-generated method stub
		return dao.select();
	}

	@Override
	public ProductVO detail(int pno) {
		// TODO Auto-generated method stub
		return dao.selectOne(pno);
	}

	@Override
	public int edit(ProductVO pvo) {
		// TODO Auto-generated method stub
		return dao.update(pvo);
	}

	@Override
	public int remove(int pno) {
		// TODO Auto-generated method stub
		return dao.delete(pno);
	}

}
