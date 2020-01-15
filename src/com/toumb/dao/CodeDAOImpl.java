package com.toumb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.toumb.entity.Code;

@Repository
public class CodeDAOImpl implements CodeDAO {
	// Need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Code> getCode() {
		// Get the current Hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// Create a query sort by title
		Query<Code> query = session.createQuery("FROM Code ORDER BY title", Code.class);
		
		// Execute and get a list of code records
		List<Code> codeList = query.getResultList();
		
		return codeList;
	}

	@Override
	public void saveCode(Code code) {
		// Get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Save the code record
		currentSession.save(code);
	}
	
	@Override
	public void updateCode(Code code) {
		// Get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Update the code record
		currentSession.update(code);
	}

	@Override
	public Code getCode(int id) {
		// Get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Retrieve from database with primary key 
		Code code = currentSession.get(Code.class, id);
		
		return code;
	}

	@Override
	public void deleteCode(int id) {
		// Get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Delete the code record
		Query query = currentSession.createQuery("DELETE FROM Code WHERE id=:codeId");
		query.setParameter("codeId", id);
		
		query.executeUpdate();
	}

	@Override
	public List<Code> searchCode(String keyword) {
		// Get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = null;
		
		// Search only if query isn't empty
		if(keyword != null && keyword.trim().length() > 0) {
			query = currentSession.createQuery("FROM Code WHERE LOWER(title) LIKE :keyword OR LOWER(category) LIKE :keyword OR "
					+ "LOWER(date) like :keyword OR LOWER(description) like :keyword", Code.class);
			query.setParameter("keyword", "%" + keyword.toLowerCase() + "%");
		} else {
			query = currentSession.createQuery("FROM Code", Code.class);
		}
		
		List<Code> codeList = query.getResultList();
		
		return codeList;
	}
	
	public void saveFile(Code code) {
		sessionFactory.getCurrentSession().save(code);
	}

}
