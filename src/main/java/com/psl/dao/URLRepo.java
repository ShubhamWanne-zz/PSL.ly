package com.psl.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psl.model.URL;

public interface URLRepo extends JpaRepository<URL, String>{
	public URL findByUrl(String url);
}
