package com.yuan.www.main.mvc;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuan.www.main.dao.PersonDao;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	PersonDao personDao;
	final Logger logger=Logger.getLogger(HomeController.class);
	@RequestMapping(value="/index")
	public String home(){
		
			personDao.print();
		
		return "index";
	}
	
	
}
