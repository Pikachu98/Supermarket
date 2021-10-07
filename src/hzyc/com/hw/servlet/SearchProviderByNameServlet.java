package hzyc.com.hw.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hzyc.com.hw.service.SearchProviderByNameService;
import hzyc.com.hw.model.Provider;

/**
 * Servlet implementation class SearchProviderByNameServlet
 */
public class SearchProviderByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProviderByNameServlet() {
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
		
		String name = request.getParameter("searchName");
		
		
		SearchProviderByNameService spbns = new SearchProviderByNameService();
		
		List<Provider> list = spbns.getProviderByName(name);

		
		request.setAttribute("pro", list);
		
		request.getRequestDispatcher("restock/searchResultsOfProviders.jsp").forward(request, response);
	}

}
