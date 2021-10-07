package hzyc.com.hw.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hzyc.com.hw.service.CreateGoodService;

/**
 * Servlet implementation class AddGoodServlet
 */
public class AddGoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGoodServlet() {
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
		String barcode = request.getParameter("barcode");
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String amount = request.getParameter("amount");
		String provider = request.getParameter("provider");
		String boughtPrice = request.getParameter("boughtPrice");
//		String soldPrice = request.getParameter("soldPrice");
		String buyer = request.getParameter("buyer");
		String boughtDate = request.getParameter("boughtDate");
		String expiration = request.getParameter("expiration");
		
//		System.out.println(barcode + "\t" + name + "\t" + category + "\t" + amount + "\t" + provider + "\t"
//					+ "\t" + boughtPrice + "\t" + soldPrice + "\t" + buyer + "\t" + boughtDate + "\t" + expiration);
		CreateGoodService cgs = new CreateGoodService();
		
		cgs.createGoodByInfo(barcode, name, category, amount, provider, boughtPrice, buyer, boughtDate, expiration);
		request.getRequestDispatcher("success/createGood.jsp").forward(request,response);
		
	
	}

}
