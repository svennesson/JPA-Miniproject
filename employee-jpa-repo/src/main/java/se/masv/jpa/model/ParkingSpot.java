package se.masv.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tblParkingSpot")
public class ParkingSpot extends AbstractEntity
{
	@Column(name = "number")
	private String number;
	
	protected ParkingSpot(){}

	public ParkingSpot(String number) 
	{
		this.number = number;
	}
	
	public String getNumber() 
	{
		return number;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ParkingSpot [number=");
		builder.append(number);
		builder.append("]");
		return builder.toString();
	}
	
	
}
