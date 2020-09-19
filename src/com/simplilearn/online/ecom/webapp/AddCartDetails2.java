package com.simplilearn.online.ecom.webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.online.ecom.model.Cart;
import com.simplilearn.online.ecom.model.Cart1;
import com.simplilearn.online.ecom.model.Product;
import com.simplilearn.online.ecom.model.Product1;
import com.simplilearn.online.ecom.util.HibernateUtil;

/**
 * Servlet implementation class AddCartDetails
 */
@WebServlet("/add-to-cart2")
public class AddCartDetails2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCartDetails2() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		// create a cart 
		Cart1 cart = new Cart1();	
		
		// Create Product
		Product1 product1 = new Product1("Iphone", 100000);
		Product1 product2 = new Product1("Asus", 10000);
		
		// Associate product in cacrt
		Set<Product1> productlist = new HashSet<>();
		productlist.add(product1);
		productlist.add(product2);
		
		cart.setProducts(productlist);
		cart.setTotal(product1.getPrice() +product2.getPrice());
		

		// open a connection
		try {
			SessionFactory sFactory = HibernateUtil.buildSessionFactory();
			Session session = sFactory.openSession();
			Transaction tx = session.beginTransaction();

			session.save(cart);

			tx.commit();

			out.println("<h1>Cart Detials :</h1>");	
			out.println("<style> table,th,td { border : 1px solid black ; padding :15px;} </style>");
			out.println("<table>");
			out.println("<tr>");
				out.println("<th>"); out.println("Cart Id "); out.println("</th>");
				out.println("<th>"); out.println("Product-1 Id "); out.println("</th>");
				out.println("<th>"); out.println("Product-1 Desc "); out.println("</th>");
				out.println("<th>"); out.println("Product-2 Id "); out.println("</th>");
				out.println("<th>"); out.println("Product-2 Name "); out.println("</th>");
				out.println("<th>"); out.println("Total "); out.println("</th>");
			out.println("</tr>");
			out.println("<tr>");
				out.println("<td>"); out.println(cart.getCartId()); out.println("</td>");
				out.println("<td>"); out.println(product1.getProductId()); out.println("</td>");
				out.println("<td>"); out.println(product1.getDescription()); out.println("</td>");
				out.println("<td>"); out.println(product2.getProductId()); out.println("</td>");
				out.println("<td>"); out.println(product2.getDescription()); out.println("</td>");
				out.println("<td>"); out.println(cart.getTotal()); out.println("</td>");
		   out.println("</tr>");
			out.println("</table>");

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
