package com.yuan.www.main.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yuan.www.main.dao.PersonDao;
import com.yuan.www.main.model.Examinee;

@Repository("personDao")
@Transactional
public class PersonDaoImpl implements PersonDao {
	@Autowired
	SessionFactory sessionFactory;
	final Logger logger=Logger.getLogger(PersonDaoImpl.class);
	
	public void print() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Examinee");
		Examinee e = (Examinee) session.load(Examinee.class, 1);
		List list = query.list();
		for (Object object : list) {
			logger.info(object);
		}
		
		
		logger.info(e.getName());
	}
}
