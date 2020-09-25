package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {
	
	private Connection connection;

	public SellerDaoJDBC(Connection connection) {
		this.connection = connection;
	}
	
	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department department;
		
		department = new Department();
		department.setId(rs.getInt("DepartmentId"));
		department.setName(rs.getString("DepName"));
		return department;
	}
	private Seller instantiateSeller(ResultSet rs, Department department) throws SQLException {
		Seller seller;
		
		seller = new Seller();
		seller.setId(rs.getInt("Id"));
		seller.setName(rs.getString("Name"));
		seller.setEmail(rs.getString("Email"));
		seller.setBirthDate(rs.getDate("BirthDate"));
		seller.setBaseSalary(rs.getDouble("BaseSalary"));
		seller.setDepartment(department);
		return seller;
	}

	@Override
	public void insert(Seller seller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller Seller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = connection.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				Department department;
				Seller seller;
				
				department = instantiateDepartment(rs);
				seller = instantiateSeller(rs, department);
				return seller;
			}				
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet();
			DB.closeStatement();
		}
	}
	
	@Override
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement ps;
		ResultSet rs;
		List<Seller> sellers;
		Map<Integer, Department> map;
		
		try {
			ps = connection.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE DepartmentId = ? "
					+ "ORDER BY Name");
			ps.setInt(1, department.getId());
			rs = ps.executeQuery();
			sellers = new ArrayList<>();
			map = new HashMap<>();
			while (rs.next()) {
				Seller seller;
				
				if (!map.containsKey(rs.getInt("DepartmentId"))) {
					department = instantiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), department);
				}
				department = map.get(rs.getInt("DepartmentId"));
				seller = instantiateSeller(rs, department);
				sellers.add(seller);
			}
			return sellers;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet();
			DB.closeStatement();
		}
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
