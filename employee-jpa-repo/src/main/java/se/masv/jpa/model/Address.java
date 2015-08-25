package se.masv.jpa.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address 
{
	@Column
	private String street;
	
	@Column
	private String postal;
	
	@Column(name = "zip_code")
	private String zipCode;
	
	protected Address(){}

	public Address(String street, String postal, String zipCode) {
		this.street = street;
		this.postal = postal;
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public String getPostal() {
		return postal;
	}

	public String getZipCode() {
		return zipCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [street=");
		builder.append(street);
		builder.append(", postal=");
		builder.append(postal);
		builder.append(", zipCode=");
		builder.append(zipCode);
		builder.append("]");
		return builder.toString();
	}
	
}
