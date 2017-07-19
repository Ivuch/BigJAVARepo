package com.snoopconsulting.antecedentes.web;

import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.EncoderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.snoopconsulting.antecedentes.crm.SugarCRMClient;

@Controller
public class CRMController {

	@Autowired
	private SugarCRMClient crmClient;

	private Gson json = new GsonBuilder().create();

	@RequestMapping(value = "getCuentas", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getCuentas(@RequestParam("query") String query, Model uiModel) throws
			NoSuchAlgorithmException, EncoderException, Exception {

		return json.toJson(crmClient.getCuentas(query));
	}

	@RequestMapping(value = "getContacto", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getContacto(@RequestParam("id") String idContacto, Model uiModel) throws
			NoSuchAlgorithmException, EncoderException,	Exception {

		return json.toJson(crmClient.getContacto(idContacto));
	}
}
