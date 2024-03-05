package application;

import java.util.Date;
import java.util.List;

import business.BaseBusiness;
import business.SellerBusiness;
import model.dao.DaoFactory;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		BaseBusiness<Seller> sellerBusiness = DaoFactory.createSellerBusiness();
		
		System.out.println("--- TEST 1: seller findById ---");
		Seller seller = sellerBusiness.findById(3);
		System.out.println(seller);
		
		System.out.println("\n--- TEST 2: seller findByDepartment ---");
		Department department = new Department(2, null);
		List<Seller> list = ((SellerBusiness)sellerBusiness).findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n--- TEST 3: seller findAll ---");
		list = ((SellerBusiness)sellerBusiness).findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("--- TEST 4: seller insert ---");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerBusiness.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
	}

}
