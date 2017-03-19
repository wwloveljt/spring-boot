package com.zhanhongit.model;

public class PageDate {
	public PageDate(int pageIndex, int pageSize, String sortField, String sortOrder) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.sortField = sortField;
		this.sortOrder = sortOrder;
	}

	public PageDate() {
		super();
	}

	private int pageIndex;
	private int pageSize;
	private String sortField;
	private String sortOrder;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
}
