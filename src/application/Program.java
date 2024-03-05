package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import business.BaseBusiness;
import business.SellerBusiness;
import model.dao.DaoFactory;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	
	public static Scanner sc = new Scanner(System.in);
	public static BaseBusiness<Department> departmentBusiness = DaoFactory.createDepartmentBusiness();
	public static BaseBusiness<Seller> sellerBusiness = DaoFactory.createSellerBusiness();

	public static void main(String[] args) {		
		menu();
	}

	public static void menu() {
		int op;
		do {
			System.out.printf(
					"Select what tou want to do\n"
					+ "1. Seller\n"
					+ "2. Department\n"
					+ "0. Exit\n");
			op = sc.nextInt();
			
			switch(op) {
			case 1:
				sellerOptions();
				break;
			case 2:
				departmentOptions();
				break;
			}
		} while (op != 0);
	}

	public static void departmentOptions() {
		int op;
		do {
			System.out.printf(
					"1. Insert Department\n"
					+ "2. Update Department\n"
					+ "3. Delete Department\n"
					+ "4. Find All Departments\n"
					+ "0. Back\n");
			op = sc.nextInt();
			
			switch (op) {
				case 1: 
					insertDepartment();
					break;
				case 2: 
					updateDepartment();
					break;
				case 3:
					deleteDepartment();
					break;
				case 4: 
					findAllDepartments();
					break;
				case 0:
					break;
				default:
					System.out.println("Select a valid option");
			}
		} while (op != 0);
	}

	public static void sellerOptions() {
		int op;
		do {
			System.out.printf(
					"1. Insert Seller\n"
					+ "2. Update Seller\n"
					+ "3. Delete Seller\n"
					+ "4. Find All Sellers\n"
					+ "0. back\n");
			op = sc.nextInt();
			
			switch (op) {
			case 1: 
				insertSeller();
				break;
			case 2: 
				updateSeller();
				break;
			case 3:
				deleteSeller();
				break;
			case 4: 
				findAllSellers();
				break;
			case 0:
				break;
			default:
				System.out.println("Select a valid option");
		}
		} while (op != 0);
	}

	public static void insertSeller() {
		sc.nextLine();
		System.out.print("Enter name of seller: ");
		String name = sc.nextLine();
		System.out.print("Enter email : ");
		String email = sc.nextLine();
		System.out.print("Enter salary : ");
		Double baseSalary = sc.nextDouble();
		System.out.print("Enter id of department : ");
		int id = sc.nextInt();
		
		Department department = departmentBusiness.findById(id);
		Seller newSeller = new Seller(null, name, email, new Date(), baseSalary, department);
		
		sellerBusiness.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
	}

	public static void updateSeller() {
		System.out.print("Enter the seller's id: ");
		int id = sc.nextInt();
		System.out.print("Enter name of seller: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("Enter email : ");
		String email = sc.nextLine();
		System.out.print("Enter salary : ");
		Double baseSalary = sc.nextDouble();
		System.out.print("Enter id of department : ");
		int departmentId = sc.nextInt();
		
		Seller seller = ((SellerBusiness)sellerBusiness).findById(id);
		Department department = departmentBusiness.findById(departmentId);
		
		seller.setName(name);
		seller.setEmail(email);
		seller.setBaseSalary(baseSalary);
		seller.setDepartment(department);
		
		sellerBusiness.update(seller);
		System.out.println("Update Completed");
	}

	public static void deleteSeller() {
		System.out.println("Enter id for delete: ");
		int id = sc.nextInt();
		
		sellerBusiness.deleteById(id);
		System.out.println("Delete Completed");
	}

	public static void findAllSellers() {
		List<Seller> list = ((SellerBusiness)sellerBusiness).findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
	}

	public static void insertDepartment() {
		sc.nextLine();
		System.out.print("Enter the name of department: ");
		String name = sc.nextLine();
		
		Department department = new Department(null, name);
		departmentBusiness.insert(department);
		System.out.println("Inserted! New id = " + department.getId());
	}

	public static void updateDepartment() {
		System.out.print("Enter the id of Department: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter the new Name: ");
		String name = sc.nextLine();
		
		Department department = departmentBusiness.findById(id);
		department.setName(name);
		
		departmentBusiness.update(department);
		System.out.println("Updated!");
	}

	public static void deleteDepartment() {
		System.out.println("Enter id for delete: ");
		int id = sc.nextInt();
		
		departmentBusiness.deleteById(id);
		System.out.println("Deleted!");
	}

	public static void findAllDepartments() {
		List<Department> dep = departmentBusiness.findAll();
		for (Department d : dep) {
			System.out.println(d);
		}
	}
}
