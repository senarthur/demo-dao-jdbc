package model.dao;

import business.BaseBusiness;
import business.DepartmentBusiness;
import business.SellerBusiness;
import db.DB;
import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class DaoFactory {
	
	private static SellerDaoJDBC createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
	
	public static BaseBusiness<Seller> createSellerBusiness() {
		SellerDaoJDBC dao = createSellerDao();
		return new SellerBusiness(dao, dao.getConn());
	}
	
	private static DepartmentDaoJDBC createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}
	
	public static BaseBusiness<Department> createDepartmentBusiness() {
		DepartmentDaoJDBC dao = createDepartmentDao();
		return new DepartmentBusiness(dao, dao.getConn());
	}
}
