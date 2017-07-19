package com.snoopconsulting.antecedentes.crm.request;

import com.snoopconsulting.antecedentes.crm.SugarCredentials;

public class SugarLoginRequest {
	protected SugarCredentials user_auth;

	public void setUserAuth(SugarCredentials auth) {
		user_auth = auth;
	}
}