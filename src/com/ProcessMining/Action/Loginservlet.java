package com.ProcessMining.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.ProcessMining.dao.Logindao;
import com.ProcessMining.dto.Profilebean;

public class Loginservlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String uname=request.getParameter("uid");
		String password=request.getParameter("pass");
		String role=null;
		String username=null;
		String status=null;
		String mail=null;
		
		Profilebean pb=new Profilebean();
		pb.setLoginid(uname);
		pb.setPassword(password);
		

		Logindao ld=new Logindao();
		try{
		
			ArrayList<Profilebean> list=ld.cloudlogin(pb);
		for(Profilebean p:list){
			 role=p.getRole();
			 username=p.getUsername();
			 status=p.getStatus();
			 mail=p.getEmail();
		}
		 if("Admin".equals(role)){
			HttpSession session=request.getSession();
			session.setAttribute("uname", uname);
			session.setAttribute("username", username);
			session.setAttribute("mail", mail);
			RequestDispatcher rd=request.getRequestDispatcher("AdminHome.jsp");
			rd.include(request, response);
			
		}
		
				
		else if("User".equals(role) && "Active".equals(status)){
			HttpSession session=request.getSession();
			session.setAttribute("uname", uname);
			session.setAttribute("username", username);
			session.setAttribute("mail", mail);
			RequestDispatcher rd=request.getRequestDispatcher("UserHome.jsp");
			rd.include(request, response);
			
		}
				
		else{
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp?status=Invalid UserName and Password");
			rd.include(request, response);
			
		}
		}
		catch (Exception e) {
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp?status=Some Internal Problem");
			rd.include(request, response);

			
		}
		

	}

	}


