package com.lab.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lab.dao.UserDao;
import com.lab.model.FacRegis;

/**
 * Servlet implementation class FacRegister
 */
public class FacRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("Faculty");
	
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String mobno = request.getParameter("mobno");
			
			FacRegis fac = new FacRegis(id,name,email,mobno);
			boolean facreg = UserDao.createFac(fac);
			if(!facreg)
			{
				request.setAttribute("msg", UserDao.msg);
				RequestDispatcher rd=request.getRequestDispatcher("facregister.jsp");  
				rd.forward(request, response);
				System.out.println("Registration Failed!");	
			}
			else
			{
				request.setAttribute("success", "Register Success");
				RequestDispatcher rd=request.getRequestDispatcher("facregister.jsp");  
				rd.forward(request, response);
				System.out.println("register success");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
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
