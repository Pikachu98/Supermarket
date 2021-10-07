package hzyc.com.hw.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hzyc.com.hw.model.Provider;
import hzyc.com.hw.service.ShowProvidersService;


/**
 * Servlet implementation class ShowProvidersServlet
 */
public class ShowProvidersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProvidersServlet() {
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
		
		ShowProvidersService sps = new ShowProvidersService();
		List<Provider> list = sps.getAllProviders();
		

		
		request.setAttribute("list", list);
		request.getRequestDispatcher("restock/provider.jsp").forward(request, response);
		
	}

}
