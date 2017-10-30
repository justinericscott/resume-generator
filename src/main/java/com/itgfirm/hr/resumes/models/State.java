package com.itgfirm.hr.resumes.models;

import static javax.persistence.CascadeType.*;
import static javax.persistence.GenerationType.*;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.github.justinericscott.docengine.annotation.ExcelColumn;
import com.github.justinericscott.docengine.annotation.ExcelColumnOrder;
import com.github.justinericscott.docengine.annotation.ExcelSheet;

@Entity
@ExcelSheet(State.XLS_SHEET)
@Table(name = State.DB_TABLE)
public class State extends AbstractResumeObject {
	private static final String DB_COL_ID = "STATE_ID";
	private static final String DB_COL_ABBRV = "ABBRV_TXT";
	private static final String DB_SEQ = "STATE_SQ";
	private static final String JPA_MAPPED_BY_STATE = "state";
	private static final String XLS_COL_ABBRV = "Abbreviation";
	static final String DB_TABLE = "STATE_R";
	static final String XLS_SHEET = "State";
	
	@Column(name = DB_COL_ID, unique = true)
	@GeneratedValue(strategy = AUTO, generator = DB_SEQ)
	@Id
	@SequenceGenerator(name = DB_SEQ, sequenceName = DB_SEQ)
	private Long id;
	@Column(name = DB_COL_ABBRV, length = 100)
	@ExcelColumn(XLS_COL_ABBRV)
	@ExcelColumnOrder(5)
	private String abbreviation;

	@OneToMany(cascade = REFRESH, mappedBy = JPA_MAPPED_BY_STATE, targetEntity = Address.class)
	@OrderColumn(name = DB_COL_ORDER)
	private Collection<Address> addresses = new ArrayList<Address>(); 

	public final Long getId() {
		return id;
	}

	public final void setId(final Long id) {
		this.id = id;
	}

	public final String getAbbreviation() {
		return abbreviation;
	}

	public final void setAbbreviation(final String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public final Collection<Address> getAddresses() {
		return addresses;
	}

	public final void setAddresses(final Collection<Address> addresses) {
		this.addresses = addresses;
	}
}
