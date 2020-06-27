package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.AccountBeans;
import com.dao.AddAccountDao;

/**
 * Servlet implementation class AddAccount
 */
@WebServlet("/AddAccount")
public class AddAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddAccount() {
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
		String borrowerId = request.getParameter("id");
		String amount = request.getParameter("amount");
		String deduction = request.getParameter("deduction");
		String duration = request.getParameter("duration");
		String emi = request.getParameter("emi");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String status = "pending";

		AccountBeans ab = new AccountBeans(borrowerId, amount, deduction, emi, duration, startDate.replace(",", ""), endDate.replace(",", ""), status);
		System.out.println(ab.toString());

		int result = AddAccountDao.addAccount(ab);

		if (result == 1) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Account Created Successfully!!');");
			out.println("location='add_account.jsp';");
			out.println("</script>");
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Something went wrong!!');");
			out.println("location='add_account.jsp';");
			out.println("</script>");
		}

	}

}
