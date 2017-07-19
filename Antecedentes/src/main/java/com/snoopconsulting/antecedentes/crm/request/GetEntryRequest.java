package com.snoopconsulting.antecedentes.crm.request;

import com.google.gson.annotations.SerializedName;

public class GetEntryRequest {

	public GetEntryRequest(String session, String moduleName, String id) {
		this.session = session;
		this.moduleName = moduleName;
		this.id = id;
	}

	protected String session;

	@SerializedName("module_name")
	protected String moduleName;

	@SerializedName("id")
	protected String id;

	@SerializedName("select_fields")
	protected String[] selectFields = { "id", "first_name", "last_name",
			"phone_work", "email1", "department" };

}