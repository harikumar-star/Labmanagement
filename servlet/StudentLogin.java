package com.lab.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lab.bussiness.LoginApp;
import com.lab.dao.AuthStu;
import com.lab.dao.UserDao;
import com.lab.model.Allregister;

/**
 * Servlet implementation class StudentLogin
 */
public class StudentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentLogin() {
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
		
		Allregister stureg = null;
		stureg = LoginApp.authenticate(id, name);
	
		
				if(stureg == null)
				{
					request.setAttribute("msg", "Id or Pass Incorrect");
					RequestDispatcher rd=request.getRequestDispatcher("studentlog.jsp");  
					//servlet2 is the url-pattern of the second servlet  
					  
					rd.forward(request, response);
					
					System.out.println("Not succes");

				}
				else{
					HttpSession session=request.getSession();  
					session.setAttribute("id", stureg.getId());
					session.setAttribute("name", stureg.getName());

					System.out.println("success");
					response.sendRedirect("student.jsp");
				}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
