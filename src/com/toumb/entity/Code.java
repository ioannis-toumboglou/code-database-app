package com.toumb.entity;

import java.sql.Date;

public class Code {
	private int id;
	private String title;
	private String category;
	private Date date;
	private String description;
	
	public Code(int id, String title, String category, Date date, String description) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.date = date;
		this.description = description;
	}

	public Code(String title, String category, Date date, String description) {
		this.title = title;
		this.category = category;
		this.date = date;
		this.description = description;
	}
	
	public Code() {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "CodeTracker [id=" + id + ", title=" + title + ", category=" + category + ", date=" + date
				+ ", description=" + description + "]";
	}	
	
}
