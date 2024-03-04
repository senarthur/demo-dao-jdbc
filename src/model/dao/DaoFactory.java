package model.dao;

import db.DB;
import model.entities.Seller;

public class DaoFactory {
	
	public static ModelDao<Seller> createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
}
