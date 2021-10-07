package hzyc.com.hw.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hzyc.com.hw.service.ShowGoodsRestockRecordService;

/**
 * Servlet implementation class ShowGoodsRestockRecordServlet
 */
public class ShowGoodsRestockRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowGoodsRestockRecordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ShowGoodsRestockRecordService sgrrs = new ShowGoodsRestockRecordService();
		
		List<HashMap<String, String>> list = sgrrs.getAllGoodsInRecords();
		
		ArrayList<HashMap<String, String>> list1 = (ArrayList<HashMap<String,String>>)list;
		
//		for(HashMap<String, String> map: list1) {
//			System.out.print(map.get("barcode") +"\t");
//			System.out.println(map.get("goodsName"));
//		}
		
//		System.out.println("This is servlet !");
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("restock/restockRecord.jsp").forward(request, response);
	}

}
