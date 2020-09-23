package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Department department;
		Seller seller;
		SellerDao sellerDao;
		
		department = new Department(1, "Books");
		seller = new Seller(21, "Bob", "bob@gmail.com", 
				new Date(), 3000.00, department);
		sellerDao = DaoFactory.createSellerDao();
		System.out.printf("%s%n", seller);

	}

}
