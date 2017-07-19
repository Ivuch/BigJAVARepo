package com.ivuch.zionweb;


//Declaracion de la clase, (Nombre de la clase = Nombre de fichero .java)
public class Usuario {

	//Atributos de la clase
	private String id;
	private int DNI;
	private String name;
	private String pass;
	
	//Constructor
	
	public Usuario () {
	}
	/*
	public Usuario(int id, int DNI, String name, String pass ){
		
		this.id = id;
		this.DNI = DNI;
		this.name = name;
		this.pass = pass;
		
	}
	*/
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getDNI() {
		return DNI;
	}
	public void setDNI(int dNI) {
		DNI = dNI;
	}
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	
	
}
