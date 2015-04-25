package com.hnkj.hm.bean;

/**

 */
public class PageBean {

	private int currentPage = 0; // ��ǰҳ

	private int pageSize = 0; // ÿһҳ��ʾ������

	private int totalPage = 0; // ��ҳ��

	private int totalRows = 0; // ������

	private int startNum = 0; // ��ʼָ�����

	private int endNum = 0; // ����ָ�����

	// private static final int PAGESIZE = 10; // ÿҳ��ʾ������

	private boolean hasNextPage = false; // �Ƿ�����һҳ

	private boolean hasPrevPage = false; // �Ƿ�����һҳ

	private int prevPage = 0; // ��һҳ

	private int nextPage = 0; // ��һҳ

	/**
	 * ��ʼ����ҳBean
	 */
	public PageBean(int totalRows, int currentPage, int pageSize) {

		this.totalRows = totalRows;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.countTotalPage();
		this.initNum();
	}

	/**
	 * ���㹲�ж���ҳ
	 */
	public void countTotalPage() {

		if (totalRows % pageSize == 0) {
			this.totalPage = totalRows / pageSize;
		} else {
			this.totalPage = totalRows / pageSize + 1;
		}
	}

	/**
	 * ����
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
	 * �ж��Ƿ���ǰһҳ
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
	 * �ж��Ƿ��к�һҳ
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
