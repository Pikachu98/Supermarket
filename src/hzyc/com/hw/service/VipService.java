package hzyc.com.hw.service;

import java.util.ArrayList;

import hzyc.com.hw.dao.VipDao;
import hzyc.com.hw.model.Vip;

public class VipService {
	public ArrayList<Vip> getAllVip(){
		VipDao vd = new VipDao();
		
//		System.out.println("������Service��");
		
		//�����������һ������������
		ArrayList<Vip> list = vd.getAllVip();
		return list;
		
	}
}
