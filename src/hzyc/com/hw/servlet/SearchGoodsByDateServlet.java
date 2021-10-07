package hzyc.com.hw.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hzyc.com.hw.service.SearchGoodsByDateService;
import hzyc.com.hw.service.SearchGoodsByNameService;

/**
 * Servlet implementation class SearchGoodsByDateServlet
 */
public class SearchGoodsByDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchGoodsByDateServlet() {
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
		String goodsName = request.getParameter("goodsName");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		if((!startDate.equals("")) && (!endDate.equals("")) && goodsName.equals("")) {
			SearchGoodsByDateService sgbds = new SearchGoodsByDateService();
			
			List<HashMap<String, String>> list = sgbds.searchGoodsByDate(startDate, endDate);
	//		System.out.println("This is Servlet 层");
			request.setAttribute("list", list);
			request.getRequestDispatcher("restock/restockRecord.jsp").forward(request, response);
		}
		if(!goodsName.equals("")) {
//			System.out.println("Servlet层");
			SearchGoodsByNameService sgbns = new SearchGoodsByNameService();
			List<HashMap<String, String>> list = sgbns.searchGoodsByName(goodsName);
			request.setAttribute("list", list);
			request.getRequestDispatcher("restock/restockRecord.jsp").forward(request, response);
		}
	}

}
