package hzyc.com.hw.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hzyc.com.hw.service.BackGoodsService;

/**
 * Servlet implementation class BackGoodsServlet
 */
public class BackGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackGoodsServlet() {
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
		String type = request.getParameter("type");
		
		String orderId = request.getParameter("orderId");
		String changeCount = request.getParameter("changeCount");
		String reason = request.getParameter("reason");
		String processor = request.getParameter("processor");
		
		BackGoodsService bgs = new BackGoodsService();
		
		bgs.addBackGoods(type, orderId, changeCount, reason, processor);
		
		if(type.equals("退货")) {
			request.getRequestDispatcher("success/backGoods.jsp").forward(request, response);
		}
		if(type.equals("换货")) {
			request.getRequestDispatcher("success/changeGood.jsp").forward(request, response);
		}
		
	}

}
