import java.util.List;

import se.masv.jpa.model.Address;
import se.masv.jpa.model.Department;
import se.masv.jpa.model.Employee;
import se.masv.jpa.model.ParkingSpot;
import se.masv.jpa.model.Phone;
import se.masv.jpa.query.EmployeeByEmployeeNumber;
import se.masv.jpa.service.JpaManager;

public class Main 
{	
	public static void main(String[] args) 
	{
		Address address = new Address("Street", "Postal", "zip");
		Department department = new Department("IT");
		Department otherDepartment = new Department("Sales");
		ParkingSpot parkingSpot = new ParkingSpot("A25");
		
		JpaManager.persistEntity(department);
		JpaManager.persistEntity(otherDepartment);
		
		// Add first employee
		Employee employee = new Employee("EmployeeNumber1", "Marcus", "Svensson", address, department, parkingSpot);
		Phone phone = new Phone("0704450723", employee);
		addEmployee(employee, phone);
		
		// Add second employee
		Employee secondEmployee = new Employee("EmployeeNumber2", "Patrik", "Appelqvist", 
				new Address("Other street", "new Postal", "new zip"), department, new ParkingSpot("A26"));
		Phone phone2 = new Phone("0709326858", secondEmployee);
		addEmployee(secondEmployee, phone2);
		
		// Add third employee
		Employee thirdEmployee = new Employee("EmployeeNumber3", "Jimmy", "Mitra", 
				new Address("new street", "other Postal", "bajs zip"), otherDepartment, new ParkingSpot("A27"));
		Phone phone3 = new Phone("0705366222", thirdEmployee);
		addEmployee(thirdEmployee, phone3);
		
		EmployeeByEmployeeNumber query = new EmployeeByEmployeeNumber("EmployeeNumber1");
		List<Employee> employees = JpaManager.getEntity(query, Employee.class);
		
		for (Employee employee2 : employees) 
		{
			System.out.println("BY EMPLOYEENUMBER: " + employee2);
		}
		
		// Remove Employee
//		JpaManager.removeEntity(secondEmployee);
		
		// Update Employee
		// employee.setFirstName("Not Marcus");
		// JpaManager.updateEntity(employee);

	}
	
	private static void addEmployee(Employee employee, Phone phone)
	{
		employee.addPhone(phone);
		JpaManager.persistEntity(employee);
	}
}
