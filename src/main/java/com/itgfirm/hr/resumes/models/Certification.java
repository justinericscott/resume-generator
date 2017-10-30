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
@ExcelSheet(Certification.XLS_SHEET)
@Table(name = Certification.DB_TABLE)
public class Certification extends AbstractResumeObject {
	private static final String DB_COL_ID = "CERTIFICATION_ID";
	private static final String DB_COL_YEAR = "YEAR_NUM";
	private static final String DB_SEQ = "CERTIFICATION_SQ";
	private static final String XLS_COL_YEAR = "Year Obtained";
	static final String DB_TABLE = "CERTIFICATION";
	static final String XLS_SHEET = "Certification";

	@Column(name = DB_COL_ID, unique = true)
	@GeneratedValue(strategy = AUTO, generator = DB_SEQ)
	@Id
	@SequenceGenerator(name = DB_SEQ, sequenceName = DB_SEQ)
	private Long id;
	@Column(name = DB_COL_YEAR, nullable = false)
	@ExcelColumn(XLS_COL_YEAR)
	@ExcelColumnOrder(5)
	private int year = 0;

	@ManyToOne(cascade = REFRESH, targetEntity = Person.class)
	private Person person;
	
	@ManyToOne(cascade = REFRESH, targetEntity = Organization.class)
	private Organization organization;

	public final Long getId() {
		return id;
	}

	public final void setId(final Long id) {
		this.id = id;
	}

	public final Organization getOrganization() {
		return organization;
	}
	
	public final void setOrganization(final Organization organization) {
		this.organization = organization;
	}
	
	public final int getYear() {
		return year;
	}
	
	public final void setYear(final int year) {
		this.year = year;
	}

	public final Person getPerson() {
		return person;
	}
	
	public final void setPerson(final Person person) {
		this.person = person;
	}
}
