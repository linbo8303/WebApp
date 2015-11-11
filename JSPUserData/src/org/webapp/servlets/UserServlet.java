package org.webapp.servlets;

import java.io.IOException;
import javax.persistence.Entity;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.webapp.data.Gender;
import org.webapp.data.UserDetails;
import org.webapp.service.UserDetailsService;

/**
 * Servlet implementation class UserServlet
 */
@Entity
@WebServlet("UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username").trim();
		String sexString = request.getParameter("sex");
		String ageString = request.getParameter("age").trim();
		String activeString = request.getParameter("active");
		String tags = request.getParameter("tags").trim();
		
		Gender sex;
		int age;
		boolean active;
				
		if(sexString.equals("Male")) {
			sex = Gender.male;
		} else {
			sex = Gender.female;
		}
		
		try {
			age = Integer.parseInt(ageString);
		} catch (NumberFormatException ex) {
			age = 0;
		}
		if (activeString.equals("Yes")) {
			active = true;
		} else {
			active = false;
		}
		
		// add user into data base
		UserDetailsService.createUserDetails(username, sex, age, active, tags);
		
		RequestDispatcher rdp = request.getRequestDispatcher("/confirm.jsp");
		rdp.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
