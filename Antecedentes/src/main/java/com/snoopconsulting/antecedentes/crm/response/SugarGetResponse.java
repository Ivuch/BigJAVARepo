package com.snoopconsulting.antecedentes.crm.response;

import com.google.gson.annotations.SerializedName;
import com.snoopconsulting.antecedentes.crm.SugarBean;

public class SugarGetResponse {

	@SerializedName("entry_list")
	protected SugarBean[] entryList;

	public SugarBean[] getEntryList() {
		return entryList;
	}

}
