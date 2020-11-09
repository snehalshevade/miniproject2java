
package com.cybage.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybage.pojos.Sports;
import com.cybage.pojos.Users;
import com.cybage.services.CustomerServiceI;
import com.cybage.services.CustomerServiceImpl;
import com.mysql.cj.Session;


//@ServletSecurity(
//		value = @HttpConstraint(
//				rolesAllowed = {"customer"}
//				)
//		)
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerServiceI cs = new CustomerServiceImpl();

	public CustomerServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getPathInfo();
		System.out.println("path"+path);
		if(path.equals("/listsports")) {			
			try {
				List<Sports> sportlist =  cs.getSports();
				request.setAttribute("sports", sportlist);
				request.getRequestDispatcher("/member/member-home.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(path.equals("/adduser")) { 
			try {
				cs.adduser(request.getParameter("username"), request.getParameter("address"),
						request.getParameter("password"), request.getParameter("phone"), request.getParameter("email"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    doGet(request, response);
	}
	}
	
