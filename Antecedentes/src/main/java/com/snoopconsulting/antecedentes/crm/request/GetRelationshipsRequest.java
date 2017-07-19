package com.snoopconsulting.antecedentes.crm.request;

import com.google.gson.annotations.SerializedName;

public class GetRelationshipsRequest {

	public GetRelationshipsRequest(String session, String moduleName,
			String accountId) {
		this.session = session;
		this.moduleName = moduleName;
		this.moduleId = accountId;
	}

	protected String session;

	@SerializedName("module_name")
	protected String moduleName;

	@SerializedName("module_id")
	protected String moduleId = "";

	@SerializedName("link_field_name")
	protected String linkFieldName = "contacts";

	@SerializedName("related_module_query")
	protected String relatedModuleQuery = "";

	@SerializedName("related_fields")
	protected String[] relatedFields = { "id", "first_name", "last_name" };

}