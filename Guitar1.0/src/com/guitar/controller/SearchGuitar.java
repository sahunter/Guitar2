package com.guitar.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guitar.model.Guitar;
import com.guitar.model.InventoryDAOImpl;
import com.guitar.model.WebService;

/**
 * Servlet implementation class SearchGuitar
 */
@WebServlet("/SearchGuitar")
public class SearchGuitar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchGuitar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("UTF-8");
		
	//	response.setCharacterEncoding("UTF-8"); // 先指定输出流的编码
	   // PrintWriter out = response.getWriter(); // 再拿到输出对象
	    response.setContentType("text/html;charset=UTF-8");
		//request.setCharacterEncoding("UTF-8"); 
		
	//	 response.setCharacterEncoding("UTF-8"); 
	//	response.setContentType("text/html;charset=UTF-8");
		
		String type=request.getParameter("type");
		String builder=request.getParameter("builder");
	    String model=request.getParameter("model");
	    String backwood=request.getParameter("backwood");
        String topwood=request.getParameter("topwood");
	//String builder="kama";
	//String model = null;
			
	//	String type= null;
			
			
	//String backwood= null;
	//	String topwood= null;
		WebService webService = (WebService) getServletContext().getAttribute("webService");
		Guitar guitar=new Guitar();
        guitar.setType(type);
		guitar.setBuilder(builder);
		guitar.setModel(model);
		guitar.setBackWood(backwood);
		guitar.setTopWood(topwood);
		
		//request.setAttribute("manages", guitar.getType());
		//request.getRequestDispatcher("guitar2.jsp").forward(request, response);
		List<Guitar> match=webService.getInventorys(guitar);
			
		
		request.setAttribute("type", type);
	    request.setAttribute("builder", builder);
	    request.setAttribute("model", model);
	    request.setAttribute("backwood", backwood);
	    request.setAttribute("topwood", topwood);
       // response.sendRedirect("guitar.jsp");
	if(match.size()!=0){
	    request.setAttribute("manages", match);
	    request.getRequestDispatcher("guitar.jsp").forward(request, response);
	}else{request.getRequestDispatcher("guitar3.jsp").forward(request, response);}
	    
	   
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
