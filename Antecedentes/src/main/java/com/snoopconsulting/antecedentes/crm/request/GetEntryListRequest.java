package com.snoopconsulting.antecedentes.crm.request;

import com.google.gson.annotations.SerializedName;

public class GetEntryListRequest {

	public GetEntryListRequest(String session, String moduleName, String query) {
		this.session = session;
		this.moduleName = moduleName;
		this.query = "accounts.name LIKE '" + query + "%'";
	}

	protected String session;

	@SerializedName("module_name")
	protected String moduleName;

	@SerializedName("query")
	protected String query = "";

	@SerializedName("order_by")
	protected String orderBy = "accounts.name";

	@SerializedName("offset")
	protected String offset = "0";

	@SerializedName("select_fields")
	protected String[] selectFields = { "id", "name", "vertical_c",
			"billing_address_street", "phone_office" };

	@SerializedName("link_name_to_fields_array")
	protected String[] linkNames = { "name" };

	@SerializedName("max_results")
	protected String maxResult = "10";

	@SerializedName("deleted")
	protected String deleted = "false";

}