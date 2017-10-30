package com.itgfirm.hr.resumes.models;

import static javax.persistence.CascadeType.*;
import static javax.persistence.GenerationType.*;

import java.util.Collection;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.github.justinericscott.docengine.annotation.ExcelColumn;
import com.github.justinericscott.docengine.annotation.ExcelColumnOrder;
import com.github.justinericscott.docengine.annotation.ExcelSheet;

@Entity
@ExcelSheet(Experience.XLS_SHEET)
@Table(name = Experience.DB_TABLE)
public class Experience extends AbstractResumeObject {
	private static final String DB_COL_ID = "EXPERIENCE_ID";
	private static final String DB_COL_START_MONTH = "START_MONTH_NUM";
	private static final String DB_COL_START_YEAR = "START_YEAR_NUM";
	private static final String DB_COL_END_MONTH = "END_MONTH_NUM";
	private static final String DB_COL_END_YEAR = "END_YEAR_NUM";
	private static final String DB_SEQ = "EXPERIENCE_SQ";
	private static final String JPA_MAPPED_BY_EXPERIENCE = "experience";
	private static final String XLS_COL_START_MONTH = "Start Month";
	private static final String XLS_COL_START_YEAR = "Start Year";
	private static final String XLS_COL_END_MONTH = "End Month";
	private static final String XLS_COL_END_YEAR = "End Year";
	static final String DB_TABLE = "EXPERIENCE";
	static final String XLS_SHEET = "Experience";

	@Column(name = DB_COL_ID, unique = true)
	@GeneratedValue(strategy = AUTO, generator = DB_SEQ)
	@Id
	@SequenceGenerator(name = DB_SEQ, sequenceName = DB_SEQ)
	private Long id;
	@Column(name = DB_COL_START_MONTH, nullable = false)
	@ExcelColumn(XLS_COL_START_MONTH)
	@ExcelColumnOrder(5)
	private int startMonth = 0;
	@Column(name = DB_COL_START_YEAR, nullable = false)
	@ExcelColumn(XLS_COL_START_YEAR)
	@ExcelColumnOrder(6)
	private int startYear = 0;
	@Column(name = DB_COL_END_MONTH)
	@ExcelColumn(XLS_COL_END_MONTH)
	@ExcelColumnOrder(7)
	private int endMonth = 0;
	@Column(name = DB_COL_END_YEAR)
	@ExcelColumn(XLS_COL_END_YEAR)
	@ExcelColumnOrder(8)
	private int endYear = 0;

	
	@ManyToOne(cascade = REFRESH, targetEntity = Person.class)
	private Person person;
	
	@ManyToOne(cascade = REFRESH, targetEntity = Organization.class)
	private Organization organization;

	@OneToMany(cascade = REFRESH, mappedBy = JPA_MAPPED_BY_EXPERIENCE, targetEntity = Bullet.class)
	@OrderColumn(name = DB_COL_ORDER)
	private Collection<Bullet> bullets = new TreeSet<Bullet>();
	
	public final Organization getOrganization() {
		return organization;
	}

	public final void setOrganization(final Organization organization) {
		this.organization = organization;
	}

	public final Collection<Bullet> getBullets() {
		return bullets;
	}

	public final void setBullets(final Collection<Bullet> bullets) {
		this.bullets = bullets;
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

	public final int getEndMonth() {
		return endMonth;
	}

	public final void setEndMonth(final int endMonth) {
		this.endMonth = endMonth;
	}

	public final int getEndYear() {
		return endYear;
	}

	public final void setEndYear(final int endYear) {
		this.endYear = endYear;
	}

	
	@Entity
	@ExcelSheet(Bullet.XLS_SHEET)
	@Table(name = Bullet.DB_TABLE)
	public final static class Bullet extends AbstractResumeObject {
		private static final String DB_COL_BULLET_FORMAT = "START_MONTH_NUM";
		private static final String XLS_COL_BULLET_FORMAT = "Start Month";
		static final String DB_TABLE = "BULLET";
		static final String XLS_SHEET = "Bullet";
		
		
		@Column(name = DB_COL_BULLET_FORMAT, nullable = false)
		@ExcelColumn(XLS_COL_BULLET_FORMAT)
		@ExcelColumnOrder(5)
		private BulletFormat format;
		
		@ManyToOne(cascade = REFRESH, targetEntity = Experience.class)
		private Experience experience;

		public final BulletFormat getFormat() {
			return format;
		}

		public final void setFormat(final BulletFormat format) {
			this.format = format;
		}

		public final Experience getExperience() {
			return experience;
		}

		public final void setExperience(final Experience experience) {
			this.experience = experience;
		}
	}
	
	public final static class BulletFormat extends AbstractResumeObject {
		private BulletType type;
		
		public final String getType() {
			return type.name();
		}
		
		public final void setType(final BulletType type) {
			this.type = type;
		}
		
		public static enum BulletType {
			ALPHA,
			DOT,
			NUMERIC,
			SQUARE			
		}
	}
}
