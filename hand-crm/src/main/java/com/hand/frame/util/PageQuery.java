package com.hand.frame.util;

import java.util.HashMap;
import java.util.Map;

public class PageQuery<T> {
	private T entity;//分页查询结果或者分页参训参数
	private int start;//开始行数
	private int end;//结束行数
	private int currentPage;//当前页
	private int pageSize;//每页页数
	private int totalPage;//总页数
	private int count;//总行数
	
	public PageQuery(T entity,int currentPage,int pageSize){
		if(currentPage<=0 ) {
            this.start = 1;
        } else {
            this.start = (currentPage-1)*pageSize;
        }
		
		this.end = this.start+pageSize+1;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.entity = entity;
	}
	
	public Map<String, Object> getMapOfPageQuery(){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("currentPage", this.currentPage);
		map.put("totalPage", getTotalPage());
		map.put("count", this.count);
		map.put("pageSize", this.pageSize);
		return map;
	}
	
	public T getEntity() {
		return entity;
	}
	public void setEntity(T entity) {
		this.entity = entity;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
