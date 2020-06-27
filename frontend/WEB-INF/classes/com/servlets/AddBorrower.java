package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.BorrowerBeans;
import com.beans.GauranterBeans;
import com.dao.AddBorrowerDao;

/**
 * Servlet implementation class AddBorrower
 */
@WebServlet("/AddBorrower")
public class AddBorrower extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBorrower() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String vehicleNumber = request.getParameter("vehicleNumber");
		String address = request.getParameter("address");

		String gauranterName = request.getParameter("gauranterName");
		String gauranterMobile = request.getParameter("gauranterMobile");
		String gauranterAddress = request.getParameter("gauranterAddress");

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a");
		Date date = new Date();
		String createdDate = dateFormat.format(date);

		BorrowerBeans bb = new BorrowerBeans(Integer.parseInt(id), name, mobile, vehicleNumber, address, createdDate);
		System.out.println(bb.toString());
		int result = AddBorrowerDao.addBorrower(bb);
		if (gauranterName != null && !gauranterName.isEmpty()) {
			GauranterBeans gb = new GauranterBeans(id, gauranterName, gauranterMobile, gauranterAddress, createdDate);
			System.out.println(gb.toString());
			AddBorrowerDao.addGauranter(gb);
		}

		if (result == 1) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Registered Successfully!!');");
			out.println("location='add_account.jsp';");
			out.println("</script>");
		}else{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Something went wrong!!');");
			out.println("location='add_borrower.jsp';");
			out.println("</script>");
		}

	}

}
