package hzyc.com.hw.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hzyc.com.hw.model.GoodOnshelfInfo;
import hzyc.com.hw.service.ShowGoodsOnShelfService;

/**
 * Servlet implementation class ShowGoodsForCashier
 */
public class ShowGoodsForCashierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowGoodsForCashierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ShowGoodsOnShelfService sgoss = new ShowGoodsOnShelfService();
		
		List<GoodOnshelfInfo> list = sgoss.showGoodsOnShelf();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("cashier/shopping.jsp").forward(request, response);
	}

}
