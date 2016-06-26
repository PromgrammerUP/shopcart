package org.javachina.shopcart.service;

import java.util.ArrayList;

import org.javachina.shopcart.dao.GoodsInfoDao;
import org.javachina.shopcart.dto.GoodsInfoDto;

public class ShangpinService {
	/*
	 * 根据类型Id展示出所有该类型的商品
	 */
	public ArrayList<GoodsInfoDto> getAllShangpin(int lid){
		GoodsInfoDao dao = new GoodsInfoDao();
		return dao.getByTid(lid);
	}
}
