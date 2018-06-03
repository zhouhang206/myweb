package com.lore.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.lore.dao.IEmpDAO;
import com.lore.dao.impls.EmpDAO;

@WebServlet("/empsave.do")
@MultipartConfig(maxFileSize=1024*1024*2)//进行文件上传处理的
public class EmpSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IEmpDAO dao = new EmpDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String phone = request.getParameter("phone");
		String job = request.getParameter("job");
		String addr = request.getParameter("addr");
		Part part = request.getPart("photo");
		String  dis =part.getHeader("content-dispositon");
		String  ps[]=dis.split(",");
		String  p = ps[2];
		String s = p.split("=")[1];
		s = s.replaceAll("\"","");
		InputStream is =part.getInputStream();
		File dir=new File("D:\\EEE");
		if(!dir.exists()) {
			dir.mkdir();
		}
		OutputStream os  =new FileOutputStream("D:\\EEE\\"+s);
		byte[] b=new byte[512];
		while(is.read(b)!=-1) {
			os.write(b);
		}
		is.close();
		os.flush();
		os.close();
	}

}
