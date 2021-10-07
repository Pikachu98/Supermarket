package hzyc.com.hw.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hzyc.com.hw.service.CreateUserService;

/**
 * Servlet implementation class CreateUserServlet
 */
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUserServlet() {
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
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String gender1 = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String mail = request.getParameter("mail");
		String mart1 = request.getParameter("mart");
//		System.out.println("在servlet层");
		
		System.out.println(gender1);
		int gender = 4;
		
		if(gender1 != null && gender1.equals("女")) {
			gender = 1;
		}else {
			gender = 0;
		}
		String mart = null;
		if(mart1.equals("1")) {
			mart = "1" ;
		}else {
			mart = "2";
		}
		
		CreateUserService cus = new CreateUserService();
		cus.createNewUser(name, password, gender, phone, mail, mart);
		request.getRequestDispatcher("success/user.jsp").forward(request, response);
	}

}
