package com.guitar.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guitar.model.Guitar;
import com.guitar.model.WebService;

/**
 * Servlet implementation class DeleteGuitar
 */
@WebServlet("/DeleteGuitar")
public class DeleteGuitar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteGuitar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String s=request.getParameter("serialNumble");
		//String[] a=request.getParameterValues("Id");
		//CategoryDal category=new CategoryDal();
       WebService webService = (WebService) getServletContext()
                .getAttribute("webService");
      //  for (int i = 0; i < a.length; i++) { 
     //   	 if(s[i].equals(a[i])){
	 			Guitar   manage=new Guitar();
	 	        manage.setSerialNumble(s);
	 	        
	 	        
	 	       
	 	       webService.deleteGuitar(manage);	
	 	     // request.getRequestDispatcher("admin/Apages/usermanagement.jsp").forward(request, response);
	 	        
	 	      //request.getRequestDispatcher("guitar.jsp").forward(request, response);
        //request.getRequestDispatcher("").forward(request, response);
   response.sendRedirect("guitar2.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
