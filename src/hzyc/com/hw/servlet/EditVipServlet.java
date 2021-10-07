package hzyc.com.hw.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hzyc.com.hw.service.EditVipService;

/**
 * Servlet implementation class EditVipServlet
 */
public class EditVipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditVipServlet() {
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
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		//剩下的不用再提取，因为都是固定的，内部有算法
		//对取到的id进行处理：给用户显示的是经过处理的id，也就是他们的卡号
		
//		System.out.println("用户id是" + id + "用户名字是" +name );
	 	String realId = null;
		for(int i = 1; i < (id.length() - 1); i ++){
			if(id.charAt(i) == '0' && id.charAt(i+1) != '0'){
				realId = id.substring(i+1);
				break;
			}
		}
		
		
		EditVipService evs = new EditVipService();
		
		evs.editById(realId, name);
		
		request.getRequestDispatcher("VipShowServlet").forward(request, response);
		
//		System.out.println("realid is " + realId);
	}

}
