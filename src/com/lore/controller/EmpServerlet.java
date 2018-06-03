package com.lore.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.lore.dao.IEmpDAO;
import com.lore.dao.impls.EmpDAO;
import com.lore.model.Emp;

/**
 * Servlet implementation class EmpServerlet
 */
@WebServlet("/emps.do")
public class EmpServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IEmpDAO dao=new EmpDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Emp> emps=this.dao.select();
		request.setAttribute("emps", emps);
		RequestDispatcher rd=request.getRequestDispatcher("emps.jsp");
		rd.forward(request, response);
	}

}
