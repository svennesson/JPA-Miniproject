package se.masv.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblPhone")
public class Phone extends AbstractEntity
{
	@Column(name = "number", unique = true)
	private String number;
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	protected Phone(){}

	public Phone(String number, Employee employee) {
		this.number = number;
		this.employee = employee;
	}

	public String getNumber() {
		return number;
	}

	public Employee getEmployee() {
		return employee;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Phone [id=");
		builder.append(getId());
		builder.append(", number=");
		builder.append(number);
		builder.append("]");
		return builder.toString();
	}
	
}
