package com.itgfirm.hr.resumes.models;

import java.sql.Timestamp;

public class Person {

	private final Long id;
	private String first;
	private String last;
	private final String email;
	private String summary;
	private Timestamp startYear;
	
	public Person(final Long id, final String first, final String last, final String email, final String summary, final Timestamp startYear) {
		this.id = id;
		this.first = first;
		this.last = last;
		this.email = email;
		this.summary = summary;
		this.startYear = startYear;
	}

	public final String getEmail() {
		return email;
	}

	public final String getFirst() {
		return first;
	}

	public final Long getId() {
		return id;
	}

	public final String getLast() {
		return last;
	}

	public final Timestamp getStartYear() {
		return startYear;
	}

	public final String getSummary() {
		return summary;
	}

	public final void setFirst(String first) {
		this.first = first;
	}

	public final void setLast(String last) {
		this.last = last;
	}

	public final void setStartYear(Timestamp startYear) {
		this.startYear = startYear;
	}

	public final void setSummary(String summary) {
		this.summary = summary;
	}	
}