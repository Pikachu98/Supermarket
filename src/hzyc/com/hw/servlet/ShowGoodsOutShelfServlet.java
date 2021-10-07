package hzyc.com.hw.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hzyc.com.hw.model.GoodOnshelfInfo;
import hzyc.com.hw.service.ShowGoodsOutShelfService;

/**
 * Servlet implementation class ShowGoodsOutShelfServlet
 */
public class ShowGoodsOutShelfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowGoodsOutShelfServlet() {
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
		ShowGoodsOutShelfService sgoss = new ShowGoodsOutShelfService();
		
		List<GoodOnshelfInfo> list = sgoss.showGoodsOutShelf();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("goodsManagement/goodsOutshelf.jsp").forward(request, response);
	}

}
