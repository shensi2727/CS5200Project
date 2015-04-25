package com.hnkj.hm.bean;

/**

 */
public class PageBean {

	private int currentPage = 0; // 当前页

	private int pageSize = 0; // 每一页显示数据行

	private int totalPage = 0; // 总页数

	private int totalRows = 0; // 总行数

	private int startNum = 0; // 开始指针控制

	private int endNum = 0; // 结束指针控制

	// private static final int PAGESIZE = 10; // 每页显示的行数

	private boolean hasNextPage = false; // 是否有下一页

	private boolean hasPrevPage = false; // 是否有上一页

	private int prevPage = 0; // 下一页

	private int nextPage = 0; // 上一页

	/**
	 * 初始化分页Bean
	 */
	public PageBean(int totalRows, int currentPage, int pageSize) {

		this.totalRows = totalRows;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.countTotalPage();
		this.initNum();
	}

	/**
	 * 计算共有多少页
	 */
	public void countTotalPage() {

		if (totalRows % pageSize == 0) {
			this.totalPage = totalRows / pageSize;
		} else {
			this.totalPage = totalRows / pageSize + 1;
		}
	}

	/**
	 * 数据
	 */
	public void initNum() {

		if (currentPage > 0 && currentPage < totalPage) {
			this.endNum = pageSize * currentPage;
			this.startNum = (currentPage - 1) * pageSize + 1;
			this.hasNextPage = true;
			this.hasPrevPage = true;
		}
		if (currentPage <= 0) {
			currentPage = 1;
			this.endNum = pageSize;
			this.startNum = 1;
			// this.endNum = currentPage*pageSize;
			// this.startNum = (currentPage-1)*pageSize+1;
			this.hasPrevPage = false;
			this.hasNextPage = true;
		}
		if (currentPage >= totalPage) {
			this.endNum = totalRows;
			this.startNum = pageSize * (totalPage - 1) + 1;
			this.hasNextPage = false;
			this.hasPrevPage = true;
		}
	}

	public void setCurrentPage(int currentPage) {

		this.currentPage = currentPage;
	}

	public int getCurrentPage() {

		return currentPage;
	}

	public void setTotalPage(int totalPage) {

		this.totalPage = totalPage;
	}

	public int getTotalPage() {

		return totalPage;
	}

	public void setPageSize(int pageSize) {

		this.pageSize = pageSize;
	}

	public int getPageSize() {

		return pageSize;
	}

	public void setStartNum(int startNum) {

		this.startNum = startNum;
	}

	public int getStartNum() {

		return startNum;
	}

	public void setEndNum(int endNum) {

		this.endNum = endNum;
	}

	public int getEndNum() {

		return endNum;
	}

	public void setHasNextPage(boolean hasNextPage) {

		this.hasNextPage = hasNextPage;
	}

	public boolean isHasNextPage() {

		return hasNextPage;
	}

	public void setHasPrevPage(boolean hasPrevPage) {

		this.hasPrevPage = hasPrevPage;
	}

	public boolean isHasPrevPage() {

		return hasPrevPage;
	}

	/**
	 * 判断是否有前一页
	 * 
	 * @return
	 */
	public int getPrevPage() {

		if (this.isHasPrevPage()) {
			prevPage = this.currentPage - 1;
		} else {
			prevPage = this.currentPage;
		}
		return prevPage;
	}

	/**
	 * 判断是否有后一页
	 * 
	 * @return
	 */
	public int getNextPage() {

		if (this.isHasNextPage()) {
			nextPage = this.currentPage + 1;
		} else {
			nextPage = this.currentPage;
		}
		return nextPage;
	}

}
