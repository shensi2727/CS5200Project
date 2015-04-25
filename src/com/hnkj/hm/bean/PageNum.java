package com.hnkj.hm.bean;

public class PageNum {

	public static int getCurrentPage(String pageNo) {

		if (pageNo == null || "".equals("pageNo")) {
			pageNo = "1";
		}
		int currentPage = Integer.parseInt(pageNo);
		if (currentPage <= 0) {
			currentPage = 1;
		}
		return currentPage;
	}
}
