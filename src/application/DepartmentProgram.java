package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentProgram {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao;
		Department department;
		List<Department> departments;
		int id;
		
		departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.printf("===== TEST 1: department findById =====%n");
		department = departmentDao.findById(3);
		System.out.printf("%s%n", department);
		
		System.out.printf("===== TEST 2: department findAll =====%n");
		departments = departmentDao.findAll();
		departments.forEach(System.out::println);
		
		System.out.printf("===== TEST 3: department insert =====%n");
		department = new Department(null, "Food");
		departmentDao.insert(department);
		System.out.printf("Inserted! New id = %d%n", department.getId());
		
		System.out.printf("===== TEST 4: department update =====%n");
		department = departmentDao.findById(1);
		department.setName("Televisions");
		departmentDao.update(department);
		System.out.printf("Update completed!%n");
		
		System.out.printf("===== TEST 5: department deleteById =====%n");
		System.out.println("Enter id for delete test: ");
		id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.printf("Deletion completed!%n");
		
		sc.close();
	
	}

}
