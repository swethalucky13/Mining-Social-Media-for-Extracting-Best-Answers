package com.ProcessMining.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ProcessMining.dao.RegistrationDao;
import com.ProcessMining.dto.Profilebean;

public class Registerservlet extends HttpServlet {

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
		try{
		String loginid=request.getParameter("uid");
		String password=request.getParameter("pass");
		String username=request.getParameter("uname");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mob");
		String gender=request.getParameter("gen");
		String address=request.getParameter("add");	
		String role=request.getParameter("role");
		
		Profilebean pb=new Profilebean();
		pb.setLoginid(loginid);
		pb.setPassword(password);
		pb.setUsername(username);
		pb.setEmail(email);
		pb.setMobileno(mobile);
		pb.setGender(gender);
		pb.setAddress(address);		
		pb.setRole(role);
		
		RegistrationDao rdao=new RegistrationDao();
		
		int i=rdao.register(pb);
			
		if(i!=0){
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp?status=Registration Successfully Completed");
			rd.include(request, response);
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("Register.jsp?status=Registration Faild Plz Try Again");
			rd.include(request, response);
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd=request.getRequestDispatcher("Register.jsp?status=Registration Faild Plz Try Again");
			rd.include(request, response);
		}
		}
	}


