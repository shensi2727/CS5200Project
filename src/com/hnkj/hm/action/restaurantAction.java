package com.hnkj.hm.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.hnkj.hm.dao.IrestaurantDAO;
import com.hnkj.hm.dao.impl.restaurantDAO;
import com.hnkj.hm.vo.restaurantVO;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**

 */
public class restaurantAction extends ActionSupport implements ModelDriven<restaurantVO> {

	private static final long serialVersionUID = -4433731364922790438L;

	restaurantVO restaurantVo = new restaurantVO();

	/**
	 * 获得restaurantVO模型驱动对象
	 */
	public restaurantVO getModel() {

		return restaurantVo;
	}

	/**
	 * 增加酒店基本信息
	 * 
	 * @return String
	 * @throws Exception
	 */

	public String addrestaurantInfo() throws Exception {

		InputStream is = new FileInputStream(restaurantVo.getImage());
		String root = ServletActionContext.getRequest().getRealPath("/upload");
		File destFile = new File(root, restaurantVo.getImageFileName());
		OutputStream os = new FileOutputStream(destFile);
		byte[] buff = new byte[400];
		while (is.read(buff) > 0) {
			os.write(buff);
		}
		os.close();
		is.close();

		IrestaurantDAO restaurantdao = new restaurantDAO();
		boolean theResult = restaurantdao.insertrestaurant(restaurantVo);

		if (theResult) {
			return SUCCESS;
		} else {
			return INPUT;
		}
	}

	public String execute() throws Exception {

		return null;
	}
}
