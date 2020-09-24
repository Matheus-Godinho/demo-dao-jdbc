package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao;
		Seller seller;
		
		sellerDao = DaoFactory.createSellerDao();
		System.out.printf("===== TEST 1: seller findById =====%n");
		seller = sellerDao.findById(3);
		System.out.printf("%s%n", seller);

	}

}
