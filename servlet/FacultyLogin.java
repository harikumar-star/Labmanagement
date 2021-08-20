package com.lab.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lab.bussiness.LoginApp2;
import com.lab.model.FacRegis;

/**
 * Servlet implementation class FacultyLogin
 */
public class FacultyLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		
		FacRegis fac = null;
		fac = LoginApp2.authenticate(id, name);
		if(fac == null)
		{
			request.setAttribute("msg", "Id or Pass Incorrect");
			RequestDispatcher rd=request.getRequestDispatcher("facultylog.jsp");  
			//servlet2 is the url-pattern of the second servlet  
			  
			rd.forward(request, response);
			
			System.out.println("Not succes");

		}
		else{
			HttpSession session=request.getSession();  
			session.setAttribute("id", fac.getId());
			session.setAttribute("name", fac.getName());

			System.out.println("success");
			response.sendRedirect("faculty.jsp");
		}






		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
