package com.psl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.psl.service.KeyGenService;

@Entity
@Table(name="URL")
public class URL {
	@Id
	private String key;
	@Column
	private String url;

	public URL(String url) {
		this.url = url;
		this.key = KeyGenService.generateKey(url);
	}

	public URL() {
	}
	
	public String getUrl() {
		return url;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = "http://localhost:8080/psl.ly/"+key;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "URL [key=" + key + ", url=" + url + "]";
	}	

}
