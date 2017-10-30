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
@ExcelSheet(Address.XLS_SHEET)
@Table(name = Address.DB_TABLE)
public class Address extends AbstractResumeObject {
	private static final String DB_COL_ID = "ADDRESS_ID";
	private static final String DB_COL_STREET1 = "STREET1_TXT";
	private static final String DB_COL_STREET2 = "STREET2_TXT";
	private static final String DB_COL_STREET3 = "STREET3_TXT";
	private static final String DB_COL_CITY = "CITY_TXT";
	private static final String DB_COL_ZIP5 = "ZIP5_NUM";
	private static final String DB_COL_ZIP4 = "ZIP4_NUM";
	private static final String DB_SEQ = "ADDRESS_SQ";
	private static final String XLS_COL_STREET1 = "Street 1";
	private static final String XLS_COL_STREET2 = "Street 2";
	private static final String XLS_COL_STREET3 = "Street 3";
	private static final String XLS_COL_CITY = "City";
	private static final String XLS_COL_ZIP5 = "Zip 5";
	private static final String XLS_COL_ZIP4 = "Zip 4";
	static final String DB_TABLE = "ADDRESS";
	static final String XLS_SHEET = "Address";

	@Column(name = DB_COL_ID, unique = true)
	@GeneratedValue(strategy = AUTO, generator = DB_SEQ)
	@Id
	@SequenceGenerator(name = DB_SEQ, sequenceName = DB_SEQ)
	private Long id;
	@Column(name = DB_COL_STREET1, nullable = false)
	@ExcelColumn(XLS_COL_STREET1)
	@ExcelColumnOrder(5)
	private String street1;
	@Column(name = DB_COL_STREET2)
	@ExcelColumn(XLS_COL_STREET2)
	@ExcelColumnOrder(6)
	private String street2;
	@Column(name = DB_COL_STREET3)
	@ExcelColumn(XLS_COL_STREET3)
	@ExcelColumnOrder(7)
	private String street3;
	@Column(name = DB_COL_CITY, nullable = false)
	@ExcelColumn(XLS_COL_CITY)
	@ExcelColumnOrder(8)
	private String city;	
	@Column(name = DB_COL_ZIP5, nullable = false)
	@ExcelColumn(XLS_COL_ZIP5)
	@ExcelColumnOrder(9)
	private int zip5 = 0;
	@Column(name = DB_COL_ZIP4)
	@ExcelColumn(XLS_COL_ZIP4)
	@ExcelColumnOrder(10)
	private int zip4 = 0;
	
	@ManyToOne(cascade = REFRESH, targetEntity = Person.class)
	private Person person;
	
	@ManyToOne(cascade = REFRESH, targetEntity = Organization.class)
	private Organization organization;
	
	@ManyToOne(cascade = REFRESH, targetEntity = State.class)
	private State state;

	@ManyToOne(cascade = REFRESH, targetEntity = Country.class)
	private Country country;
	
	public final Person getPerson() {
		return person;
	}

	public final void setPerson(final Person person) {
		this.person = person;
	}

	public final Organization getOrganization() {
		return organization;
	}

	public final void setOrganization(final Organization organization) {
		this.organization = organization;
	}

	public final String getStreet1() {
		return street1;
	}
	
	public final void setStreet1(final String street1) {
		this.street1 = street1;
	}
	
	public final String getStreet2() {
		return street2;
	}
	
	public final void setStreet2(final String street2) {
		this.street2 = street2;
	}
	
	public final String getStreet3() {
		return street3;
	}
	
	public final void setStreet3(final String street3) {
		this.street3 = street3;
	}
	
	public final String getCity() {
		return city;
	}
	
	public final void setCity(final String city) {
		this.city = city;
	}
	
	public final State getState() {
		return state;
	}
	
	public final void setState(final State state) {
		this.state = state;
	}
	
	public final int getZip5() {
		return zip5;
	}
	
	public final void setZip5(final int zip5) {
		this.zip5 = zip5;
	}
	
	public final int getZip4() {
		return zip4;
	}
	
	public final void setZip4(final int zip4) {
		this.zip4 = zip4;
	}
	
	public final Country getCountry() {
		return country;
	}
	
	public final void setCountry(final Country country) {
		this.country = country;
	}
}
