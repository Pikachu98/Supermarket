package hzyc.com.hw.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hzyc.com.hw.service.SearchSoldGoodsByDateService;

/**
 * Servlet implementation class SearchSoldGoodsByDateServlet
 */
public class SearchSoldGoodsByDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchSoldGoodsByDateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		
        
        
		Date dateEnd = null, dateStart = null;
		try {
			dateEnd = sdf.parse(endDate);
			dateStart = sdf.parse(startDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endMillis = dateEnd.getTime();
		long startMillis = dateStart.getTime();	
		
//		System.out.println(startMillis);
//		System.out.println(endMillis);		
		SearchSoldGoodsByDateService ssgbds = new SearchSoldGoodsByDateService();
		List<HashMap<String, String>> list = ssgbds.getSales(startMillis, endMillis);
		
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).get("name"));
//		}
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("sale/SearchResult.jsp").forward(request, response);
	}

}
