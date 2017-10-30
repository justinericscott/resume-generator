package com.itgfirm.hr.resumes.models;

import static javax.persistence.CascadeType.*;
import static javax.persistence.GenerationType.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.github.justinericscott.docengine.annotation.ExcelColumn;
import com.github.justinericscott.docengine.annotation.ExcelColumnOrder;
import com.github.justinericscott.docengine.annotation.ExcelSheet;

@Entity
@ExcelSheet(Education.XLS_SHEET)
@Table(name = Education.DB_TABLE)
public class Education extends AbstractResumeObject {
	private static final String DB_COL_ID = "EDUCATION_ID";
	private static final String DB_COL_DOCUMENT = "DOCUMENT_TXT";
	private static final String DB_COL_MAJOR = "MAJOR_TXT";
	private static final String DB_COL_MINOR = "MINOR_TXT";
	private static final String DB_COL_MONTH = "MONTH_NUM";
	private static final String DB_COL_YEAR = "YEAR_NUM";
	private static final String DB_SEQ = "EDUCATION_SQ";
	private static final String XLS_COL_DOCUMENT = "Document";
	private static final String XLS_COL_MAJOR = "Major";
	private static final String XLS_COL_MINOR = "Minor";
	private static final String XLS_COL_MONTH = "Month Obtained";
	private static final String XLS_COL_YEAR = "Year Obtained";
	static final String DB_TABLE = "EDUCATION";
	static final String XLS_SHEET = "Education";
	
	@Column(name = DB_COL_ID, unique = true)
	@GeneratedValue(strategy = AUTO, generator = DB_SEQ)
	@Id
	@SequenceGenerator(name = DB_SEQ, sequenceName = DB_SEQ)
	private Long id;
	@Column(name = DB_COL_DOCUMENT, nullable = false)
	@ExcelColumn(XLS_COL_DOCUMENT)
	@ExcelColumnOrder(5)
	private String document;
	@Column(name = DB_COL_MAJOR, nullable = false)
	@ExcelColumn(XLS_COL_MAJOR)
	@ExcelColumnOrder(6)
	private String major;
	@Column(name = DB_COL_MINOR)
	@ExcelColumn(XLS_COL_MINOR)
	@ExcelColumnOrder(7)
	private String minor;
	@Column(name = DB_COL_MONTH, nullable = false)
	@ExcelColumn(XLS_COL_MONTH)
	@ExcelColumnOrder(8)
	private int month = 0;
	@Column(name = DB_COL_YEAR, nullable = false)
	@ExcelColumn(XLS_COL_YEAR)
	@ExcelColumnOrder(9)
	private int year = 0;

	@ManyToOne(cascade = REFRESH, targetEntity = Person.class)
	private Person person;
	
	@ManyToOne(cascade = REFRESH, targetEntity = Organization.class)
	private Organization organization;

	public final Organization getOrganization() {
		return organization;
	}
	
	public final void setOrganization(final Organization organization) {
		this.organization = organization;
	}
	
	public final String getDocument() {
		return document;
	}
	
	public final void setDocument(final String document) {
		this.document = document;
	}
	
	public final String getMajor() {
		return major;
	}
	
	public final void setMajor(final String major) {
		this.major = major;
	}
	
	public final String getMinor() {
		return minor;
	}
	
	public final void setMinor(final String minor) {
		this.minor = minor;
	}
	
	public final int getMonth() {
		return month;
	}
	
	public final void setMonth(final int month) {
		this.month = month;
	}
	
	public final int getYear() {
		return year;
	}
	
	public final void setYear(final int year) {
		this.year = year;
	}
}
