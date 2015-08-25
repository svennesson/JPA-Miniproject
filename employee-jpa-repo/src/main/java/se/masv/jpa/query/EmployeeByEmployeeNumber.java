package se.masv.jpa.query;

import se.masv.jpa.model.Employee;
import se.masv.jpa.service.NamedEntityQuery;

public class EmployeeByEmployeeNumber extends NamedEntityQuery<Employee>
{
	public static final String NAME = "Employee.GetByEmployeeNumber";
	public static final String QUERY = "select e from Employee e join fetch e.phones where e.employeeNumber = :employeeNumber";
	public static final String PARAM_EMPLOYEE_NUMBER = "employeeNumber";
	
	private final String employeeNumber;
	
	public EmployeeByEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
		setParams(PARAM_EMPLOYEE_NUMBER, employeeNumber);
	}
	
	public String getEmployeeNumber() {
		return employeeNumber;
	}

	@Override
	public String getName() {
		return NAME;
	}
}
