package com.toumb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toumb.dao.CodeDAO;
import com.toumb.entity.Code;


@Service
public class CodeServiceImpl implements CodeService {
	// Need to inject the Code DAO
	@Autowired
	private CodeDAO codeDAO;
	
	@Override
	@Transactional
	public List<Code> getCode() {
		return codeDAO.getCode();
	}

	@Override
	@Transactional
	public void saveCode(Code code) {
		codeDAO.saveCode(code);
	}
	
	@Override
	@Transactional
	public void updateCode(Code code) {
		codeDAO.updateCode(code);
	}

	@Override
	@Transactional
	public Code getCode(int id) {
		return codeDAO.getCode(id);
	}

	@Override
	@Transactional
	public void deleteCode(int id) {
		codeDAO.deleteCode(id);
	}

	@Override
	@Transactional
	public List<Code> searchCode(String keyword) {
		return codeDAO.searchCode(keyword);
	}

}
