package com.psl.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class KeyGenService {
	private static final String KEYHASH="0123456789ABCDFEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstvuwxyz"; 
	public static String generateKey(String url){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy/HH/mm/ss");
		String dateString = formatter.format(new Date());
		StringBuilder result = new StringBuilder();
		for(String s : dateString.split("/")){
			if(Integer.parseInt(s) > 62){
				result.append(KEYHASH.charAt(Integer.parseInt(s)/100));
				result.append(KEYHASH.charAt(Integer.parseInt(s)%100));
				continue;
			}
			result.append(KEYHASH.charAt(Integer.parseInt(s)));
		}
		return result.toString();
	}
}
