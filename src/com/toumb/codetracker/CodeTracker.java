package com.toumb.codetracker;

import java.sql.Date;

public class CodeTracker {
	private int id;
	private String title;
	private String category;
	private Date dateOfBirth;
	private String description;
	
	public CodeTracker(int id, String title, String category, Date dateOfBirth, String description) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.dateOfBirth = dateOfBirth;
		this.description = description;
	}

	public CodeTracker(String title, String category, Date dateOfBirth, String description) {
		this.title = title;
		this.category = category;
		this.dateOfBirth = dateOfBirth;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "CodeTracker [id=" + id + ", title=" + title + ", category=" + category + ", dateOfBirth=" + dateOfBirth
				+ ", description=" + description + "]";
	}	
	
}
