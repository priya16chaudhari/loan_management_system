package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AddPaymentDao;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pay = request.getParameter("emi");
		String currDate = request.getParameter("currDate");
		String fineCharge=request.getParameter("fine");
		System.out.println(id+" "+pay+" "+currDate+" "+fineCharge);
		Date d = new Date();
		String time= d.toString();
		
		
		int result = AddPaymentDao.doPayment(id, pay, currDate, time,fineCharge);
		if (result == 1) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Registered Successfully!!');");
			out.println("location='single_borrower.jsp?id="+id+"';");
			out.println("</script>");
		}else{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Something went wrong!!');");
			out.println("location='payment.jsp';");
			out.println("</script>");
		}
	}

}
