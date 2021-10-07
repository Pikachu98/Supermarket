package hzyc.com.hw.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hzyc.com.hw.service.EditUserService;

/**
 * Servlet implementation class EditUserServlet
 */
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String gender1 = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String mail = request.getParameter("mail");
		String mart = request.getParameter("mart");
		
		int gender = 4;
		if(gender1.equals("男")) {
			gender = 0;
		}
		if(gender1.equals("女")) {
			gender = 1;
		}
		
		EditUserService eus = new EditUserService();
		
		eus.updateUser(userId, name, password, gender, phone, mail, mart);
		request.getRequestDispatcher("ShowAllUsersServlet").forward(request, response);
	}

}
