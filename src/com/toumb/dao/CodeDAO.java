package com.toumb.dao;

import java.util.List;

import com.toumb.entity.Code;

public interface CodeDAO {
	
	public List<Code> getCode();

	public void saveCode(Code code);
	
	public void updateCode(Code code);

	public Code getCode(int id);

	public void deleteCode(int id);

	public List<Code> searchCode(String keyword);

}