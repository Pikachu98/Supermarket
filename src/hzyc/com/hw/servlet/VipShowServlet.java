package hzyc.com.hw.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hzyc.com.hw.model.Vip;
import hzyc.com.hw.service.VipService;

/**
 * Servlet implementation class VipShowServlet
 */
public class VipShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VipShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request  , response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		VipService vs = new VipService();
		
		ArrayList<Vip> list = (ArrayList<Vip>) vs.getAllVip();
//		System.out.println(list.get(0).getName() + " Servlet²ã");
		request.setAttribute("vips", list);
		
		request.getRequestDispatcher("vip/showVip.jsp").forward(request, response);
//		System.out.println("Servlet²ã");
	}

}
