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
@ExcelSheet(Skill.XLS_SHEET)
@Table(name = Skill.DB_TABLE)
public class Skill extends AbstractResumeObject {
	private static final String DB_COL_ID = "SKILLS_ID";
	private static final String DB_COL_YEARS = "YEARS_CNT";
	private static final String DB_SEQ = "SKILLS_SQ";
	private static final String XLS_COL_YEARS = "Years";
	static final String DB_TABLE = "SKILLS";
	static final String XLS_SHEET = "Skills";

	@Column(name = DB_COL_ID, unique = true)
	@GeneratedValue(strategy = AUTO, generator = DB_SEQ)
	@Id
	@SequenceGenerator(name = DB_SEQ, sequenceName = DB_SEQ)
	private Long id;
	@Column(name = DB_COL_YEARS, nullable = false)
	@ExcelColumn(XLS_COL_YEARS)
	@ExcelColumnOrder(5)
	private int years = 0;

	@ManyToOne(cascade = REFRESH, targetEntity = Person.class)
	private Person person;
	
	public final Long getId() {
		return id;
	}

	public final void setId(final Long id) {
		this.id = id;
	}

	public final int getYears() {
		return years;
	}

	public final void setYears(final int years) {
		this.years = years;
	}
}
