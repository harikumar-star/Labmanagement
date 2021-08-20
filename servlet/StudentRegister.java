package com.lab.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lab.dao.UserDao;
import com.lab.model.Allregister;

/**
 * Servlet implementation class StudentRegister
 */
public class StudentRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		try {
			PrintWriter out = response.getWriter();
			
			int id = Integer.parseInt(request.getParameter("id"));
		
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String department = request.getParameter("department");
			String semester = request.getParameter("semester");
			String year = request.getParameter("years");
			
			System.out.println(id+""+name+""+email+""+department+""+semester+""+year);
			System.out.println("year====>"+year);
		
			
			System.out.println("year====>"+year);
			//Allregister stureg = Allregister(id,name,email,department,semester,year);
			Allregister stureg= new Allregister(id, name, email, department, semester, year);
			boolean stuReg = UserDao.createUser(stureg);
			if(!stuReg){
				request.setAttribute("msg", UserDao.msg);
				RequestDispatcher rd=request.getRequestDispatcher("sturegister.jsp");  
				rd.forward(request, response);
				System.out.println("Registration Failed!");	

			}
			else
			{
				request.setAttribute("success", "Register Success");
				RequestDispatcher rd=request.getRequestDispatcher("sturegister.jsp");  
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
