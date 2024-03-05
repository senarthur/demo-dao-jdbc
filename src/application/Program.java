package application;

import model.dao.DaoFactory;
import model.dao.ModelDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		ModelDao<Seller> sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("--- TEST 1: seller findById ---");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
	}

}
