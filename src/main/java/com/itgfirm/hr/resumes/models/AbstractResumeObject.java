package com.itgfirm.hr.resumes.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.github.justinericscott.docengine.annotation.ExcelColumn;
import com.github.justinericscott.docengine.annotation.ExcelColumnOrder;
import com.github.justinericscott.docengine.models.AbstractJpaModel;

@MappedSuperclass
public abstract class AbstractResumeObject extends AbstractJpaModel {
	
	private static final String DB_COL_IS_ACTIVE = "IS_ACTIVE_BLN";
	private static final String XLS_COL_IS_ACTIVE = "Is Active";
	
	@Column(name = DB_COL_DESCRIPTION)
	@ExcelColumn(XLS_COL_DESCRIPTION)
	@ExcelColumnOrder(2)
	private String description;
	@Column(name = DB_COL_NAME, nullable = false)
	@ExcelColumn(XLS_COL_NAME)
	@ExcelColumnOrder(1)
	protected String name;
	@Column(name = DB_COL_ORDER, nullable = false)
	@ExcelColumn(XLS_COL_ORDER)
	@ExcelColumnOrder(3)	
	private int orderBy = 0;
	@Column(name = DB_COL_IS_ACTIVE, nullable = false)
	@ExcelColumn(XLS_COL_IS_ACTIVE)
	@ExcelColumnOrder(4)
	private boolean active = true;
	
	public final String getDescription() {
		return description;
	}

	public final void setDescription(final String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}
	
	public final void setName(final String name) {
		this.name = name;
	}

	public final int getOrderBy() {
		return orderBy;
	}

	public final void setOrderBy(final int orderBy) {
		this.orderBy = orderBy;
	}
	
	public final boolean isActive() {
		return active;
	}

	public final void setActive(final boolean active) {
		this.active = active;
	}

	protected final boolean isNotNullOrEmpty(final Object object) {
		return (object != null && !object.toString().isEmpty());
	}
}