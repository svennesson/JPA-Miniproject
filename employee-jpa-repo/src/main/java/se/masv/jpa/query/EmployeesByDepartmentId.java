package se.masv.jpa.query;

import se.masv.jpa.model.Employee;
import se.masv.jpa.service.NamedEntityQuery;

public class EmployeesByDepartmentId extends NamedEntityQuery<Employee>
{
	public static final String NAME = "Employee.GetAllEmployeesByDepartment";
	public static final String QUERY = "select e from Employee e where e.department.id = :departmentId";
	public static final String DEPARTMENT_ID_PARAM = "departmentId";
	
	private final Long departmentId;
	
	public EmployeesByDepartmentId(final Long departmentId)
	{
		this.departmentId = departmentId;
		setParams(DEPARTMENT_ID_PARAM, departmentId);
	}
	
	public Long getDepartmentId() 
	{
		return departmentId;
	}
	
	@Override
	public String getName() 
	{
		return NAME;
	}

}
