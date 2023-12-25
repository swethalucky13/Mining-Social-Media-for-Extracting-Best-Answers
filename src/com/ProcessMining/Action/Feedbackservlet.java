package com.ProcessMining.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ProcessMining.dao.RegistrationDao;
import com.ProcessMining.dto.Profilebean;

public class Feedbackservlet extends HttpServlet {

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
			HttpSession session = request.getSession();
			DateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
	    	String dateString2 = dateFormat2.format(new Date()).toString();
	     Profilebean pb=new Profilebean();
	     pb.setQ_id(Integer.parseInt(request.getParameter("qid")));
	     pb.setLoginid((String)session.getAttribute("uname"));
	     pb.setUsername((String) session.getAttribute("username"));
	     pb.setComments(request.getParameter("comment"));
	     pb.setCommentdate(dateString2);
	     
	     RegistrationDao rdo=new RegistrationDao();
	     int i=rdo.comments(pb);
	     if(i!=0){
				RequestDispatcher rd=request.getRequestDispatcher("ViewQueansservlet?status=Comment Added Successfully Completed");
				rd.include(request, response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("ViewQueansservlet?status=Comment Not Added Faild Plz Try Again");
				rd.include(request, response);
			}
			}
			catch (Exception e) {
				e.printStackTrace();
				RequestDispatcher rd=request.getRequestDispatcher("ViewQueansservlet?status=Comment Not Added Faild Plz Try Again");
				rd.include(request, response);
			}
			}
		}
