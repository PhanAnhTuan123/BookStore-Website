package com.bookstore.entity.entity3;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class Address implements Serializable{
	@Column(name = "address",nullable = false,length = 30)
	private String address;
	@Column(name = "city",nullable = false,length = 32)
	private String city;
	@Column(name = "country",nullable = false,length = 64)
	private String country;
	@Column(name = 	"zipcode",nullable = false,length = 24)
	private String zipcode;
	
	public Address(String address, String city, String country, String zipcode) {
		super();
		this.address = address;
		this.city = city;
		this.country = country;
		this.zipcode = zipcode;
	}

	public Address() {
		super();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
}
