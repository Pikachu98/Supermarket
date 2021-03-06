package hzyc.com.hw.servlet;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import hzyc.com.hw.model.GoodOnshelfInfo;
import hzyc.com.hw.service.EditGoodsPicPathService;

/**
 * Servlet implementation class EditOnshelfServlet
 */
public class EditOnshelfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOnshelfServlet() {
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
		String barcode, name, category, restockAmount, count, boughtPrice, soldPrice, pic;
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		GoodOnshelfInfo good = new GoodOnshelfInfo();
		
		try {
			FileItemIterator iter = upload.getItemIterator(request);
			
			while(iter.hasNext()) {
				FileItemStream stream = iter.next();
				InputStream input = stream.openStream();
				
				//???????????????form??????
				if(stream.isFormField()) {
					//input???????????? ???????????????????????? InputStreamReader???????????????????????????????????????
					InputStreamReader reader = new InputStreamReader(input, "UTF-8"); 
					//???????????????bufferedReader,?????????readLine?????????
					BufferedReader bf = new BufferedReader(reader);
//					System.out.println(bf.readLine());
					if(stream.getFieldName().equals("stock_id")) {
						good.setRestockId(bf.readLine());
					}
					
					if(stream.getFieldName().equals("barcode")) {
						good.setBarcode(bf.readLine());
					}
					if (stream.getFieldName().equals("goodsName")) {
						good.setGoodsName(bf.readLine());
					}
					if(stream.getFieldName().equals("category")){
						good.setCategory(bf.readLine());
					}
					if(stream.getFieldName().equals("restockAmount")) {
						good.setAmount(Integer.parseInt(bf.readLine()));
					}
					if(stream.getFieldName().equals("count")) {
						good.setCount(Integer.parseInt(bf.readLine()));
					}
					if(stream.getFieldName().equals("boughtPrice")) {
						good.setBoughtPrice(bf.readLine());
					}
					if(stream.getFieldName().equals("soldPrice")) {
						good.setSoldPrice(bf.readLine());
					}
					
					
					
					input.close(); 
				}else {
					/**????????????????????????????????????????????????????????????????????????*/
					long timeStamp = System.currentTimeMillis();
					
					//?????????????????????????????????
					String path = request.getRealPath("/");
					
					String oldName = stream.getName();
					String suffix = oldName.substring(oldName.indexOf("."));
					pic = timeStamp + suffix;

					//???????????????????????????,??????????????????
					String newPath = path + "goodspics/" + pic;
					System.out.println(newPath);
//					System.out.println(pic);
					
					if(stream.getFieldName().equals("picPath")) {
						good.setPicPath(pic);
					}
					OutputStream out = new FileOutputStream(newPath);
					//??????
					byte[] buffer = new byte[1024];
					int length = 0;
					while((length = input.read(buffer)) != -1) {
						out.write(buffer, 0, length);
					}
					input.close();
					out.close(); 
				}
			}
//			good.print();
			EditGoodsPicPathService egpps = new EditGoodsPicPathService();
			egpps.editGoodPath(good);
			request.getRequestDispatcher("ShowGoodsRestockServlet").forward(request, response);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
