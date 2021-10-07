package hzyc.com.hw.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import hzyc.com.hw.service.PayBillService;




/**
 * Servlet implementation class PayBillServlet
 */
public class PayBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayBillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String json = request.getParameter("data");
		String cardNum = request.getParameter("cardNum");
		String vipId = null;
		
		if(!cardNum.equals("0")) {
			//对卡号进行处理
			String cardNumSub = cardNum.substring(1);
			for(int i = 0; i < cardNumSub.length(); i++) {
				if(!(cardNumSub.charAt(i) == '0')) {
					vipId = cardNumSub.substring(i);
					break;
				}
			}
		}else {
			vipId = "不是VIP";
		}
		
//		System.out.println(json);
		
		JsonParser jParser = new JsonParser();
		JsonArray jArray =(JsonArray) jParser.parse(json);
		
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		
		//单次购物的总消费 @param1
		double totalCost = 0;
		
		int size = jArray.size();
		for(int i = 0; i < size; i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			JsonObject jo = (JsonObject)jArray.get(i);
			map.put("goodsId", jo.get("goodsId").toString());
			map.put("barcode", jo.get("barcode").toString());
			map.put("goodsName", jo.get("goodsName").toString());
			map.put("category", jo.get("category").toString());
			map.put("soldPrice", jo.get("soldPrice").toString());
			map.put("boughtCount", jo.get("boughtCount").toString());
			map.put("restAmount", jo.get("restAmount").toString());
			map.put("singleCost", jo.get("singleCost").toString());
			double singleCost = Double.parseDouble(jo.get("singleCost").toString());
			totalCost += singleCost;
			
			list.add(map);
		}
		
		//购买时间毫秒数，因为一个人可能一天购买了好几次 @param 2
		long time = System.currentTimeMillis();
		
		PayBillService pbs = new PayBillService();
		pbs.updateDetailsAfterShopping(list, totalCost, time, vipId);
		
		//咋没跳转呢？不知道啊
		request.getRequestDispatcher("success/buyGood.jsp").forward(request, response);
		
/**		for(HashMap<String, String> map: list) {
			System.out.println( "商品ID" + map.get("goodsId") +
								"条形码" + map.get("barcode") + 
								"商品名" + map.get("goodsName")  + 
								"类别" + map.get("category") + 
								"售价" + map.get("soldPrice") + 
								"购买数量" + map.get("boughtCount") + 
								"剩余数量" + map.get("restAmount") + 
								"单项消费"+ map.get("singleCost") );
		}

*/		
		
/**
//		JSONObject js = (JSONObject) json.get("data");
//		JSONArray channels = js.getJSONArray("channels"); 
		
//		
//		String[] records = json.split("},{");
//		System.out.println(records.length);
	//	JSONArray jsonArr = JSONArray.fromObject(json);

//		System.out.println(jsonArr.size());
*/	
		
/**		JSONArray jsonArray = JSONArray.parseArray(json);
		System.out.println(jsonArray);
		
		
//		JSONArray jsonArray = JSON.parseArray(json);
		
		
//		System.out.println("jsonArray" + jsonArray);
//		
//		System.out.println("第一个jsonArray" + jsonArray.get(0));
		
//		int size = jsonArray.size();
//		System.out.println("size是" + size);
		
//		for(int i = 0; i < size; i++) {
//			JSONObject jsonObject = jsonArray.getJSONObject(i);
//			System.out.println(jsonObject.getString("barcode"));
//		}
		
//		for(Object obj: jsonArray) {
//			JSONObject jsonObject = (JSONObject)obj;
//			System.out.println(jsonObject.getString("goodsName"));
//		}
 * 
 */
	}

}
