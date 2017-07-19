package com.snoopconsulting.antecedentes.crm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.snoopconsulting.antecedentes.crm.request.GetEntryListRequest;
import com.snoopconsulting.antecedentes.crm.request.GetEntryRequest;
import com.snoopconsulting.antecedentes.crm.request.GetRelationshipsRequest;
import com.snoopconsulting.antecedentes.crm.request.SugarLoginRequest;
import com.snoopconsulting.antecedentes.crm.response.SugarGetResponse;
import com.snoopconsulting.antecedentes.crm.response.SugarLoginResponse;
import com.snoopconsulting.antecedentes.domain.Contacto;
import com.snoopconsulting.antecedentes.domain.Cuenta;

@Component
public class SugarCRMClient {

	@Value("${crm.rest.endpoint}")
	private String endpoint;

	@Value("${crm.password}")
	private String password;

	@Value("${crm.username}")
	private String username;

	private URLCodec codec = new URLCodec();
	private Gson json = new GsonBuilder().create();

	public List<Cuenta> getCuentas(String query) throws
			NoSuchAlgorithmException, EncoderException, Exception {

		List<Cuenta> cuentas = new ArrayList<Cuenta>();

		SugarLoginResponse session = getSugarSession(new SugarCredentials(username, password));
		SugarBean[] beans = getBean(session.getSessionID(), "Accounts", query);

		if (beans != null) {
			for (SugarBean sugarBean : beans) {
				Cuenta cuenta = new Cuenta();
				cuenta.setIdCrm(sugarBean.getId());
				cuenta.setDireccion(sugarBean.get("billing_address_street"));
				cuenta.setTelefono(sugarBean.get("phone_office"));
				cuenta.setNombre(sugarBean.get("name"));
				cuenta.setVertical(sugarBean.get("vertical_c"));
				cuentas.add(cuenta);
			}
		}
		return cuentas;

	}

	public List<Contacto> getContactos(String idAccount) throws
			NoSuchAlgorithmException, EncoderException, Exception {

		List<Contacto> contacts = new ArrayList<Contacto>();

		SugarLoginResponse session = getSugarSession(new SugarCredentials(username, password));
		SugarBean[] beans = getContactsBean(session.getSessionID(), "Accounts",	idAccount);

		if (beans != null) {
			for (SugarBean bean : beans) {
				Contacto contacto = new Contacto();
				contacto.setIdCrm(bean.getId());
				contacto.setNombre(bean.get("first_name") + " "	+ bean.get("last_name"));
				contacts.add(contacto);
			}
		}
		return contacts;

	}

	public Contacto getContacto(String idContacto) throws 
			NoSuchAlgorithmException, EncoderException, Exception {
		SugarLoginResponse session = getSugarSession(new SugarCredentials(username, password));
		SugarBean bean = getContactBean(session.getSessionID(), idContacto);
		Contacto contacto = new Contacto();
		contacto.setIdCrm(bean.getId());
		contacto.setNombre(bean.get("first_name") + " " + bean.get("last_name"));
		contacto.setTelefono(bean.get("phone_work"));
		contacto.setEmail(bean.get("email1"));
		contacto.setAreaPerteneciente(bean.get("department"));
		return contacto;
	}

	private SugarBean getContactBean(String sessionId, String idAccount) throws
			EncoderException, Exception {

		GetEntryRequest req = new GetEntryRequest(sessionId, "Contacts", idAccount);
		String response = null;
		response = postToSugar(endpoint	+ "?method=get_entry&response_type=JSON&input_type=JSON&rest_data="	+
									codec.encode(json.toJson(req)));

		SugarGetResponse entryResp = json.fromJson(response, SugarGetResponse.class);
		if (entryResp.getEntryList().length > 0) {
			return entryResp.getEntryList()[0];
		} else {
			return null;
		}
	}

	private SugarBean[] getContactsBean(String sessionId, String moduleName,
			String idAccount) throws EncoderException, Exception {

		GetRelationshipsRequest req = new GetRelationshipsRequest(sessionId,
				moduleName, idAccount);
		String response = null;
		response = postToSugar(endpoint	+ "?method=get_relationships&response_type=JSON&input_type=JSON&rest_data="	+ 
									codec.encode(json.toJson(req)));

		SugarGetResponse entryResp = json.fromJson(response, SugarGetResponse.class);
		if (entryResp.getEntryList().length > 0) {
			return entryResp.getEntryList();
		} else {
			return null;
		}
	}

	private SugarBean[] getBean(String sessionId, String moduleName,
			String query) throws EncoderException, Exception {

		GetEntryListRequest req = new GetEntryListRequest(sessionId, moduleName, query);
		String response = null;
		response = postToSugar(endpoint	+ "?method=get_entry_list&response_type=JSON&input_type=JSON&rest_data=" +
									codec.encode(json.toJson(req)));

		SugarGetResponse entryResp = json.fromJson(response, SugarGetResponse.class);
		if (entryResp.getEntryList().length > 0) {
			return entryResp.getEntryList();
		} else {
			return null;
		}
	}

	private SugarLoginResponse getSugarSession(SugarCredentials credentials) throws
			EncoderException, Exception {

		SugarLoginRequest loginReq = new SugarLoginRequest();
		loginReq.setUserAuth(credentials);

		SugarLoginResponse jResp = null;
		String response = postToSugar(endpoint + "?method=login&response_type=JSON&input_type=JSON&rest_data=" +
										codec.encode(json.toJson(loginReq)));
		
		jResp = json.fromJson(response, SugarLoginResponse.class);

		return jResp;
	}

	private String postToSugar(String urlStr) throws Exception {
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setUseCaches(false);
		conn.setAllowUserInteraction(false);
		conn.setRequestProperty("Content-Type",	"application/x-www-form-urlencoded");

		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		// Buffer the result into a string
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();

		conn.disconnect();
		return sb.toString();
	}

}
