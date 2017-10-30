package com.itgfirm.hr.resumes.models;

import static javax.persistence.CascadeType.*;
import static javax.persistence.GenerationType.*;

import java.util.Collection;
import java.util.TreeSet;

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
@ExcelSheet(Person.XLS_SHEET)
@Table(name = Person.DB_TABLE)
public class Person extends AbstractResumeObject {
	private static final String DB_COL_ID = "PERSON_ID";
	private static final String DB_COL_FIRST = "FIRST_TXT";
	private static final String DB_COL_LAST = "LAST_TXT";
	private static final String DB_COL_EMAIL = "EMAIL_TXT";
	private static final String DB_COL_START_MONTH = "START_MONTH_NUM";
	private static final String DB_COL_START_YEAR = "START_YEAR_NUM";
	private static final String DB_SEQ = "PERSON_SQ";
	private static final String JPA_MAPPED_BY_PERSON = "person";
	private static final String XLS_COL_FIRST = "First Name";
	private static final String XLS_COL_LAST = "Last Name";
	private static final String XLS_COL_EMAIL = "Email";
	private static final String XLS_COL_START_MONTH = "Start Month";
	private static final String XLS_COL_START_YEAR = "Start Year";
	static final String DB_TABLE = "PERSON";
	static final String XLS_SHEET = "Person";
	
	@Column(name = DB_COL_ID, unique = true)
	@GeneratedValue(strategy = AUTO, generator = DB_SEQ)
	@Id
	@SequenceGenerator(name = DB_SEQ, sequenceName = DB_SEQ)
	private Long id;
	@Column(name = DB_COL_FIRST, nullable = false)
	@ExcelColumn(XLS_COL_FIRST)
	@ExcelColumnOrder(5)
	private String first;
	@Column(name = DB_COL_LAST, nullable = false)
	@ExcelColumn(XLS_COL_LAST)
	@ExcelColumnOrder(6)
	private String last;
	@Column(name = DB_COL_EMAIL, nullable = false)
	@ExcelColumn(XLS_COL_EMAIL)
	@ExcelColumnOrder(7)
	private String email;
	@Column(name = DB_COL_START_MONTH, nullable = false)
	@ExcelColumn(XLS_COL_START_MONTH)
	@ExcelColumnOrder(8)
	private int startMonth = 0;
	@Column(name = DB_COL_START_YEAR, nullable = false)
	@ExcelColumn(XLS_COL_START_YEAR)
	@ExcelColumnOrder(9)
	private int startYear = 0;
	
	@OneToMany(cascade = ALL, mappedBy = JPA_MAPPED_BY_PERSON, targetEntity = Address.class)
	@OrderColumn(name = DB_COL_ORDER)
	private Collection<Address> addresses = new TreeSet<Address>();
	
	@OneToMany(cascade = ALL, mappedBy = JPA_MAPPED_BY_PERSON, targetEntity = Certification.class)
	@OrderColumn(name = DB_COL_ORDER)
	private Collection<Certification> certifications = new TreeSet<Certification>();
	
	@OneToMany(cascade = ALL, mappedBy = JPA_MAPPED_BY_PERSON, targetEntity = Education.class)
	@OrderColumn(name = DB_COL_ORDER)
	private Collection<Education> education = new TreeSet<Education>();
	
	@OneToMany(cascade = ALL, mappedBy = JPA_MAPPED_BY_PERSON, targetEntity = Experience.class)
	@OrderColumn(name = DB_COL_ORDER)
	private Collection<Experience> experience = new TreeSet<Experience>();

	@OneToMany(cascade = ALL, mappedBy = JPA_MAPPED_BY_PERSON, targetEntity = Skill.class)
	@OrderColumn(name = DB_COL_ORDER)
	private Collection<Skill> skills = new TreeSet<Skill>();

	public final Long getId() {
		return id;
	}
	
	public final void setId(final Long id) {
		this.id = id;
	}

	@Override
	public final String getName() {
		if (isNotNullOrEmpty(name)) {
			return name;
		}
		setName(first.concat(" ").concat(last));
		return name;
	}
	
	public final String getFirst() {
		return first;
	}

	public final void setFirst(final String first) {
		this.first = first;
	}

	public final String getLast() {
		return last;
	}

	public final void setLast(final String last) {
		this.last = last;
	}

	public final String getEmail() {
		return email;
	}
	
	public final void getEmail(final String email) {
		this.email = email;
	}
	
	public final int getStartMonth() {
		return startMonth;
	}
	
	public final void setStartMonth(final int startMonth) {
		this.startMonth = startMonth;
	}

	public final int getStartYear() {
		return startYear;
	}

	public final void setStartYear(final int startYear) {
		this.startYear = startYear;
	}

	public final Collection<Address> getAddresses() {
		return addresses;
	}

	public final void setAddresses(final Collection<Address> addresses) {
		this.addresses = addresses;
	}

	public final Collection<Certification> getCertifications() {
		return certifications;
	}

	public final void setCertifications(final Collection<Certification> certifications) {
		this.certifications = certifications;
	}

	public final Collection<Education> getEducation() {
		return education;
	}

	public final void setEducation(final Collection<Education> education) {
		this.education = education;
	}

	public final Collection<Experience> getExperience() {
		return experience;
	}

	public final void setExperience(final Collection<Experience> experience) {
		this.experience = experience;
	}

	public final Collection<Skill> getSkills() {
		return skills;
	}

	public final void setSkills(final Collection<Skill> skills) {
		this.skills = skills;
	}
}