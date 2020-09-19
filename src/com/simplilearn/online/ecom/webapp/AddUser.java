package com.simplilearn.online.ecom.webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.online.ecom.model.Address;
import com.simplilearn.online.ecom.model.User;
import com.simplilearn.online.ecom.util.HibernateUtil;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/add-user")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddUser() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		// user object
		User user = new User();
		user.setName("John Smith");
		user.setEmail("john.smith@gmail.com");

		// address object
		Address address = new Address();
		address.setStreet("ABC Street");
		address.setCity("Hyderbad");

		// Associate address to user
		address.setUser(user);

		// open a connection
		try {
			SessionFactory sFactory = HibernateUtil.buildSessionFactory();
			Session session = sFactory.openSession();
		    Transaction tx = session.beginTransaction();
		    
		    session.save(user);
		    session.save(address);
		   
		    
		    tx.commit();
		    
		    out.print("<h1> Trasaction is Completed</h1>");
		    out.print("User Id "+user.getUserId());
		    out.print("Address Id "+address.getAddId());
		    
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
