package com.snoopconsulting.antecedentes.crm;

public class SugarAccount {

	public SugarAccount(String id, String name, String address, String phone,
			String vertical) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.vertical = vertical;
	}

	private String id;
	private String name;
	private String address;
	private String phone;
	private String vertical;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getVertical() {
		return vertical;
	}
}