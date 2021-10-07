package hzyc.com.hw.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hzyc.com.hw.model.Vip;
import hzyc.com.hw.service.CreateVipService;

/**
 * Servlet implementation class AddVipServlet
 */
public class AddVipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVipServlet() {
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
		request.setCharacterEncoding("UTF-8");
		
		Vip v = new Vip();
		String name = request.getParameter("name");
		
		Date todayDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(todayDate);
		
		CreateVipService cvs = new CreateVipService();
		
		String id = cvs.createVipByName(name, date);
		int length = id.length();
		String prefix = "3";
		if(length <= 8){
			
			int numberOfZeros = 8 - length;
			for(int i = 0; i < numberOfZeros; i++){
				prefix += "0";
			}
		}
		String cardNumber = prefix + id;
		request.setAttribute("cardNumber", cardNumber);
		
		request.getRequestDispatcher("success/vipSuccess.jsp").forward(request, response);
	}

}
