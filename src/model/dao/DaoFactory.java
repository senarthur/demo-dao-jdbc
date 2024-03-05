package model.dao;

import business.BaseBusiness;
import business.SellerBusiness;
import db.DB;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Seller;

public class DaoFactory {
	
	private static SellerDaoJDBC createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
	
	public static BaseBusiness<Seller> createSellerBusiness() {
		SellerDaoJDBC dao = createSellerDao();
		return new SellerBusiness(dao, dao.getConn());
	}
}
