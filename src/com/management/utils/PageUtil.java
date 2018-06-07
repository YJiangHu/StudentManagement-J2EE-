package com.management.utils;

import java.util.List;

import com.management.pojo.Student;

/**
 * 页面信息工具类
 */
public class PageUtil {
	
	public int page; //当前页数
	public int max; //每页显示记录数
	public int total; //总页数
	public int begin; //每页开始元素在list中索引
	public int end; //每页结束元素在list中索引
	public int size; //总记录数
	public int[] navigatepageNums; //有效页码数组
	public List<Student> list; //学生列表
	
	public PageUtil(List<Student> list, int page, int max) {
		this.list = list;		
		this.max = max;
		this.total = list.size() % max == 0?
				list.size() / max : list.size() / max + 1;
		this.size = list.size();
		this.begin = (page - 1) * max;
		this.page = judgePage(page);
		this.end = (page - 1) * max + 4;
		this.navigatepageNums = new int[total];
		for(int i = 1; i <= total; i++) {
			navigatepageNums[i-1] = i;
		}
	}
	/**
	 * 当页码小于1时，置为1；当页码大于最大页码时，置为最大页码
	 * @param page 页数
	 */
	public int judgePage(int page) {
		if(page > total) {
			return total;
		}
		if(page < 1) {
			return 1;
		}
		return page;
	}
	/**
	 * 是否有前一页
	 */
	public boolean hasPrevious() {
		if(page  > 1) {
			return true;
		}
		return false;
	}
	/**
	 * 是否有后一页
	 */
	public boolean hasNext() {
		if(page < total) {
			return true;
		}
		return false;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int[] getNavigatepageNums() {
		return navigatepageNums;
	}

	public void setNavigatepageNums(int[] navigatepageNums) {
		this.navigatepageNums = navigatepageNums;
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	
}
