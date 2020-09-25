package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao;
		Seller seller;
		List<Seller> sellers;
		
		sellerDao = DaoFactory.createSellerDao();
		System.out.printf("===== TEST 1: seller findById =====%n");
		seller = sellerDao.findById(3);
		System.out.printf("%s%n", seller);
		System.out.printf("===== TEST 2: seller findByDepartment =====%n");
		sellers = sellerDao.findByDepartment(new Department(2, null));
		sellers.forEach(System.out::println);
		System.out.printf("===== TEST 3: seller findAll =====%n");
		sellers = sellerDao.findAll();
		sellers.forEach(System.out::println);

	}

}
