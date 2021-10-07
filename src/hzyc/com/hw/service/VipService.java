package hzyc.com.hw.service;

import java.util.ArrayList;

import hzyc.com.hw.dao.VipDao;
import hzyc.com.hw.model.Vip;

public class VipService {
	public ArrayList<Vip> getAllVip(){
		VipDao vd = new VipDao();
		
//		System.out.println("来到了Service层");
		
		//这里必须引用一个参数来接收
		ArrayList<Vip> list = vd.getAllVip();
		return list;
		
	}
}
