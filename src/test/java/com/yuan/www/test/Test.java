package com.yuan.www.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yuan.www.config.spring.SpringConfig;
import com.yuan.www.main.dao.PersonDao;
import com.yuan.www.main.dao.impl.PersonDaoImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] string=new String []{"com.yuan.www.main","com.yuan.www.config.spring.springConfig"};
		Class [] classes=new Class[]{SpringConfig.class};
		ApplicationContext context =new AnnotationConfigApplicationContext(classes);
		PersonDao personDao= (PersonDao) context.getBean(PersonDao.class);
		
			personDao.print();
		
		
	}

}
