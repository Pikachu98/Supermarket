package hzyc.com.hw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hzyc.com.hw.service.JudgeCardNumberService;
import hzyc.com.hw.service.SearchVipService;

/**
 * Servlet implementation class JudgeCardNumberServlet
 */
public class JudgeCardNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JudgeCardNumberServlet() {
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
		String cardNumber = request.getParameter("cardNumber");
//		SearchVipService svs = new SearchVipService();
		
//		System.out.println(cardNumber);
		String id = null;
		String excludePrefix = cardNumber.substring(1);
//		System.out.println(excludePrefix);
		
		if(excludePrefix.length() == 8) {
			for(int i = 0; i < excludePrefix.length(); i++) {
//				char x = excludePrefix.charAt(i);
				if(!(excludePrefix.charAt(i) == '0'))  {
					id = excludePrefix.substring(i);
//					System.out.println(id);
					break;
				}
			}
		}
		
		JudgeCardNumberService jcns = new JudgeCardNumberService();
		
		List<HashMap<String, String>> list = jcns.findVipById(id);
		
		//默认没找到找到VIP
		double status = 0;
		if(!(list.size() == 0 || list == null) ){
//			System.out.println(Integer.parseInt(list.get(0).get("authority")));
			status = 10 - Double.parseDouble(list.get(0).get("authority"));
		}
		
		PrintWriter out = response.getWriter();
		out.print(status);
		out.flush();
		out.close();
		
//		List<HashMap<String, String>> list = svs.findVipById(id);
//		
//		
		
	}

}
