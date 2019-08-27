package com.sdze.form;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sdze.beans.Client;

public class Form {
	
	String resultat;
	private String champ_mail="email";
	private String champ_nom="nom";
	private static final String champ_pass="pass";
	private static final String champ_conf="conf";
	Map<String,String>erreurs=new HashMap<String,String>();
	
	public Client clt(HttpServletRequest request) {
		Client us= new Client();
		String nom=request.getParameter(champ_nom);
		String email=request.getParameter(champ_mail);
		String pass=request.getParameter(champ_pass);
		String conf=request.getParameter(champ_conf);
		
		
		try {
			validEmail(email);
		} catch (Exception e) {
			erreurs.put("err_email", e.getMessage());	
		}
		us.setEmail(email);
		
		try {
			validNom(nom);
		} catch (Exception e) {
			erreurs.put("err_nom", e.getMessage());
		}
		us.setNom(nom);
		
		try {
			validationMotsDePasse(pass,conf);
		} catch (Exception e) {
			erreurs.put("err_pass", e.getMessage());
		}
		
		us.setPass(pass);
		
		if(erreurs.isEmpty()) {
			
			resultat="succes d'inscription";
		}else {
			resultat="echec d'inscripion";
		}
		
		
		
		
		return us ;
		
	}
	
	public Map<String,String> getErreurs(){
		return erreurs;
		
		
	}
	private void validEmail(String email)throws Exception {
		
		if(email!=null && email.trim().length()!=0) {
			
			if( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" )){
				throw new Exception("entre un mail valid");
			}
			
		}else {
			throw new Exception("entre Un mail");
		}
	}
private void validNom(String nom) throws Exception{
	
	if(nom!=null && nom.trim().length()!=0) {
		
		if(nom.length()<3) {
			throw new Exception("entrer un nom sup 3");
			
			
		}
		
	}else {
		throw new Exception("le champ est vide");
	}
}
	public void validationMotsDePasse(String pass,String conf)throws Exception {
		if (pass.trim().length()!=0  && pass!= null) {
			if(pass.length()<3) {
			
			throw new Exception("le mot pass et faible");
			
		}else if(!pass.equals(conf)) {
			throw new Exception("le mot de passe n'est pas compatible");
		}
			
		}else {
			throw new Exception("le champ est vide");
		}
		
}
 public String getResultat() {
    return resultat;
}
}
