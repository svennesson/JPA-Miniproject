package se.masv.jpa.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import se.masv.jpa.query.EmployeeByEmployeeNumber;
import se.masv.jpa.query.EmployeesByDepartmentId;

@Entity
@Table(name = "tblEmployee")
@NamedQueries({
	@NamedQuery(name = EmployeeByEmployeeNumber.NAME, query = EmployeeByEmployeeNumber.QUERY),
	@NamedQuery(name = EmployeesByDepartmentId.NAME, query = EmployeesByDepartmentId.QUERY)
})
public class Employee extends AbstractEntity
{
	@Column(name = "emp_number", unique = true)
	private String employeeNumber;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column
	private Address address;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
	@OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(unique = true)
	private ParkingSpot parkingSpot;
	
	@OneToMany(mappedBy = "employee", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.EAGER)
	private Collection<Phone> phones;

	public Employee(String employeeNumber, String firstName, String lastName, Address address, Department department,
			ParkingSpot parkingSpot) {
		this.employeeNumber = employeeNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.department = department;
		this.parkingSpot = parkingSpot;
		this.phones = new ArrayList<>();
	}
	
	protected Employee(){}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Address getAddress() {
		return address;
	}

	public Department getDepartment() {
		return department;
	}

	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}

	public Collection<Phone> getPhones() {
		return phones;
	}
	
	public Employee addPhone(Phone phone)
	{
		phones.add(phone);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=");
		builder.append(getId());
		builder.append(", employeeNumber=");
		builder.append(employeeNumber);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", address=");
		builder.append(address);
		builder.append(", department=");
		builder.append(department);
		builder.append(", parkingSpot=");
		builder.append(parkingSpot);
		builder.append(", phones=");
		builder.append(phones);
		builder.append("]");
		return builder.toString();
	}
	
}
