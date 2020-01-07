package com.toumb.entity;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="code")
public class Code {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="category")
	private String category;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="date")
	private Date date;
	
	@Column(name="description")
	private String description;
	
	@Column(name="code_file")
	private byte[] data;
	
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
		java.sql.Date dateSQL = new java.sql.Date(date.getTime());
		
		// Add one day, as every time a date is updated, the system subtracts one day
		// Couldn't find a better solution
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateSQL);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		date = new Date(cal.getTimeInMillis());
		
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

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "CodeTracker [id=" + id + ", title=" + title + ", category=" + category + ", date=" + date
				+ ", description=" + description + "]";
	}	
	
}