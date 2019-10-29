package com.app.controllers;

import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtcc.app.App.Security;

@RestController
@CrossOrigin
@RequestMapping("/stock")
public class SecurityController {

	@Autowired
	private DataSource datasource;
	private final String sql = "SELECT * FROM SECURITIES";

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Security> goHome() {
		return new JdbcTemplate(datasource).query(sql, new BeanPropertyRowMapper<>(Security.class));
	}

}