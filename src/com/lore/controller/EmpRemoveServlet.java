package com.lore.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lore.dao.IEmpDAO;
import com.lore.dao.impls.EmpDAO;


@WebServlet("/empdel.do")
public class EmpRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IEmpDAO dao =new EmpDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id!=null && !"".equals(id)) {
			int eid = Integer.parseInt(id);
			this.dao.delete(eid);
		}
		response.sendRedirect("emps.do");
	}

}
