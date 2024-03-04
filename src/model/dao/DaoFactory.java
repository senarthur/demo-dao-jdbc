package model.dao;

import model.entities.Seller;

public class DaoFactory {
	
	public static ModelDao<Seller> createSellerDao() {
		return new SellerDaoJDBC();
	}
}
