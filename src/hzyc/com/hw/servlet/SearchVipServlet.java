package hzyc.com.hw.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hzyc.com.hw.model.Vip;
import hzyc.com.hw.service.SearchVipService;

/**
 * Servlet implementation class SearchVipServlet
 */
public class SearchVipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchVipServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String currentId = request.getParameter("id");
		SearchVipService svs = new SearchVipService();
//		System.out.println("在sevlet里呢");
		
		ArrayList<HashMap<String, String>> list = svs.findVipById(currentId);
		
		Vip v = new Vip();
		
		String id = list.get(0).get("id");
		String name = list.get(0).get("name");
		
		int length = id.length();
		String prefix = "3";
		if(length <= 8){
			
			int numberOfZeros = 8 - length;
			for(int i = 0; i < numberOfZeros; i++){
				prefix += "0";
			}
		}
		String newId = prefix + id;
		
		String authority = list.get(0).get("authority");
		int auth = Integer.parseInt(authority);
		int discount = 10 - auth;
		
		
		String cost = list.get(0).get("cost");
		//����
		String integral = list.get(0).get("integral");
		String createdDate = list.get(0).get("createdDate");
		
		v.setId(newId);
		v.setName(name);
		v.setAuthority(""+discount);
		v.setCost(cost);
		v.setIntegral(integral);
		v.setCreatedDate(createdDate);
		
		request.setAttribute("user", v);
		
		request.getRequestDispatcher("vip/editVip.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
