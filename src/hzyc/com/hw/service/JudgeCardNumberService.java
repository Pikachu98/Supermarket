package hzyc.com.hw.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import hzyc.com.hw.dao.JudgeCardNumberDao;

public class JudgeCardNumberService {
	JudgeCardNumberDao jcnd = new JudgeCardNumberDao();
	public ArrayList<HashMap<String, String>> findVipById(String id){
		return jcnd.findVipById(id);
		
	}
}
