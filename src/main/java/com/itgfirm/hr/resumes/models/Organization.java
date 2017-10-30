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
@ExcelSheet(Organization.XLS_SHEET)
@Table(name = Organization.DB_TABLE)
public class Organization extends AbstractResumeObject {
	private static final String DB_COL_ID = "ORGANIZATION_ID";
	private static final String DB_COL_TYPE = "TYPE_TXT";
	private static final String DB_SEQ = "ORGANIZATION_SQ";
	private static final String JPA_MAPPED_BY_ORGANIZATION = "organization";
	private static final String XLS_COL_TYPE = "Type";
	static final String DB_TABLE = "ORGANIZATION";
	static final String XLS_SHEET = "Organizations";

	@Column(name = DB_COL_ID, unique = true)
	@GeneratedValue(strategy = AUTO, generator = DB_SEQ)
	@Id
	@SequenceGenerator(name = DB_SEQ, sequenceName = DB_SEQ)
	private Long id;
	@Column(name = DB_COL_TYPE, nullable = false)
	@ExcelColumn(XLS_COL_TYPE)
	@ExcelColumnOrder(5)
	private String type;

	@OneToMany(cascade = REFRESH, mappedBy = JPA_MAPPED_BY_ORGANIZATION, targetEntity = Address.class)
	@OrderColumn(name = DB_COL_ORDER)
	private Collection<Address> addresses = new ArrayList<Address>();
	
	@OneToMany(cascade = REFRESH, mappedBy = JPA_MAPPED_BY_ORGANIZATION, targetEntity = Certification.class)
	@OrderColumn(name = DB_COL_ORDER)
	private Collection<Certification> certifications = new ArrayList<Certification>();

	@OneToMany(cascade = REFRESH, mappedBy = JPA_MAPPED_BY_ORGANIZATION, targetEntity = Education.class)
	@OrderColumn(name = DB_COL_ORDER)
	private Collection<Education> education = new ArrayList<Education>();
	
	@OneToMany(cascade = REFRESH, mappedBy = JPA_MAPPED_BY_ORGANIZATION, targetEntity = Experience.class)
	@OrderColumn(name = DB_COL_ORDER)
	private Collection<Experience> experiences = new ArrayList<Experience>();

	public final String getType() {
		return type;
	}

	public final void setType(final String type) {
		this.type = type;
	}

	public final Collection<Address> getAddresses() {
		return addresses;
	}

	public final void setAddresses(final Collection<Address> addresses) {
		this.addresses = addresses;
	}
	

	public final Collection<Experience> getExperiences() {
		return experiences;
	}

	
	public final void setExperiences(final Collection<Experience> experiences) {
		this.experiences = experiences;
	}	
}
