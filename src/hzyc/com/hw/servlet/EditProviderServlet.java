package hzyc.com.hw.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hzyc.com.hw.model.Provider;
import hzyc.com.hw.service.EditProviderService;

/**
 * Servlet implementation class EditProviderServlet
 */
public class EditProviderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProviderServlet() {
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
		String address = request.getParameter("address");
		String contactName = request.getParameter("contactName");
		String contactNum = request.getParameter("contactNum");
		String contactEmail = request.getParameter("contactEmail");
		
		Provider pro = new Provider();
		
		pro.setProviderId(id);
		pro.setProviderName(name);
		pro.setProviderAddress(address);
		pro.setContact(contactName);
		pro.setContactNum(contactNum);
		pro.setContactEmail(contactEmail);
		
		EditProviderService eps = new EditProviderService();
		
		eps.editProvider(pro);
		request.getRequestDispatcher("ShowProvidersServlet").forward(request, response);
	}

}
