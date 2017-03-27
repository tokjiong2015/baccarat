package org.du.tech.dto;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String street;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
}
