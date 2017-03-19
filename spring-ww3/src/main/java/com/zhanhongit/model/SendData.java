package com.zhanhongit.model;

import java.util.List;

public class SendData<T> {
	private int total;
	private List<T> data;

	public List<T> getData() {
		return data;
	}

	public int getTotal() {
		return total;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
