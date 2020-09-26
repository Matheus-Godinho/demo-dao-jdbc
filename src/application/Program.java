package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao;
		Seller seller;
		List<Seller> sellers;
		int id;
		
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
		
		System.out.printf("===== TEST 4: seller insert =====%n");
		seller = new Seller(null, "Greg", "greg@gmail.com",
				new Date(), 4000.00, new Department(2, null));
		sellerDao.insert(seller);
		System.out.printf("Inserted! New id = %d%n", seller.getId());
		
		System.out.printf("===== TEST 5: seller update =====%n");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.printf("Update completed!%n");
		
		System.out.printf("===== TEST 6: seller deleteById =====%n");
		System.out.printf("Enter id for delete test: ");
		id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.printf("Deletion completed!%n");
		
		sc.close();

	}

}
