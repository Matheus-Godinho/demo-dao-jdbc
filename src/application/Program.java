package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao;
		Seller seller;
		
		sellerDao = DaoFactory.createSellerDao();
		seller = sellerDao.findById(3);
		System.out.printf("%s%n", seller);

	}

}
