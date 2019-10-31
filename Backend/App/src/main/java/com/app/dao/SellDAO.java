package com.app.dao;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SellDAO {
	@Autowired
	private DataSource datasource;
	
	

}
