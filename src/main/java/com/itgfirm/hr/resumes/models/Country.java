package com.itgfirm.hr.resumes.models;

import static javax.persistence.CascadeType.*;
import static javax.persistence.GenerationType.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TimeZone;

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
@ExcelSheet(Country.XLS_SHEET)
@Table(name = Country.DB_TABLE)
public class Country extends AbstractResumeObject {
	private static final String DB_COL_ID = "COUNTRY_ID";
	private static final String DB_COL_ABBRV = "ABBRV_TXT";
	private static final String DB_COL_CODE = "CODE_TXT";
	private static final String DB_COL_TZ = "TZ_TXT";
	private static final String DB_SEQ = "COUNTRY_SQ";
	private static final String JPA_MAPPED_BY_COUNTRY = "country";
	private static final String XLS_COL_ABBRV = "Abbreviation";
	private static final String XLS_COL_CODE = "Country Code";
	private static final String XLS_COL_TZ = "Timezone";
	static final String DB_TABLE = "COUNTRY_R";
	static final String XLS_SHEET = "Country";
	
	@Column(name = DB_COL_ID, unique = true)
	@GeneratedValue(strategy = AUTO, generator = DB_SEQ)
	@Id
	@SequenceGenerator(name = DB_SEQ, sequenceName = DB_SEQ)
	private Long id;
	@Column(name = DB_COL_ABBRV)
	@ExcelColumn(XLS_COL_ABBRV)
	@ExcelColumnOrder(5)
	private String abbreviation;
	@Column(name = DB_COL_CODE)
	@ExcelColumn(XLS_COL_CODE)
	@ExcelColumnOrder(6)
	private String code;
	@Column(name = DB_COL_TZ)
	@ExcelColumn(XLS_COL_TZ)
	@ExcelColumnOrder(7)
	private TimeZone timezone;
	
	@OneToMany(cascade = REFRESH, mappedBy = JPA_MAPPED_BY_COUNTRY, targetEntity = Address.class)
	@OrderColumn(name = DB_COL_ORDER)
	private Collection<Address> addresses = new ArrayList<Address>(); 
	
	public final String getAbbreviation() {
		return abbreviation;
	}
	
	public final void setAbbreviation(final String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	public final String getCode() {
		return code;
	}
	
	public final void setCode(final String code) {
		this.code = code;
	}
	
	public final TimeZone getTimezone() {
		return timezone;
	}
	
	public final void setTimezone(final TimeZone timezone) {
		this.timezone = timezone;
	}
	
	public final Collection<Address> getAddresses() {
		return addresses;
	}
	
	public final void setAddresses(final Collection<Address> addresses) {
		this.addresses = addresses;
	}
}