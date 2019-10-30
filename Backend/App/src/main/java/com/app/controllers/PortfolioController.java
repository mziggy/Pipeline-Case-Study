package com.app.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.app.dao.PropertiesDAO;
import com.app.dao.SecurityDAO;
import com.dtcc.app.App.Security;

@RestController
@RequestMapping("/portfolio")
@CrossOrigin
public class PortfolioController {
	
	@Autowired
	private SecurityDAO securitydao;
	
//	@Autowired
//	private PropertiesDAO propdao;
	
	@GetMapping(value="/{customer_id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Collection<Security> getSecurityByCustId(@PathVariable("customer_id") String id) {
		return securitydao.getSecurityByCustId(id);
	}

}
