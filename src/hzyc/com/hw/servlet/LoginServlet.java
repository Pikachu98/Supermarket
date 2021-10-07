package hzyc.com.hw.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hzyc.com.hw.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		request.setCharacterEncoding("UTF-8");
		
		//getParameter引号里的内容是属性name里的内容
		String userInput = request.getParameter("userInput");
		String password = request.getParameter("pwd");
		
//		System.out.println(userInput +"\t" + password);
		
		LoginService ls = new LoginService();
		
		List<HashMap<String, String>> list = ls.hasUser(userInput, password);
//		System.out.println(list.size());
		
		int flag = 0;
		
		if(list.size() != 0){
			HashMap<String, String> map = list.get(0);
			if(map.get("authority").equals("0")){
				flag = 2;
			}else{
				flag = 1;
			}
		}
		
		PrintWriter out = response.getWriter();
		out.print(flag);
		out.flush();
		out.close();
		
	}

}
