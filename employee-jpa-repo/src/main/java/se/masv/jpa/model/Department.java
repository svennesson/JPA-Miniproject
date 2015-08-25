package se.masv.jpa.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblDepartment")
public class Department extends AbstractEntity
{	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "department")
	Collection<Employee> employees;
	
	protected Department(){}

	public Department(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Collection<Employee> getEmployees() {
		return employees;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Department [name=");
		builder.append(name);
		builder.append(", id=");
		builder.append(getId());
		builder.append("]");
		return builder.toString();
	}

	
	
}
