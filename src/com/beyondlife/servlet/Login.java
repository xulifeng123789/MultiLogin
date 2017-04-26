package com.beyondlife.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beyondlife.vo.User;

public class Login extends HttpServlet {

	public void doGet(HttpServletRequest req,HttpServletResponse rsp)
	                throws ServletException,IOException{
		
		rsp.setContentType("text/html;charset=gb2312");
		String uid = req.getParameter("uid");
		String name = req.getParameter("name");
		
		PrintWriter out = rsp.getWriter();
		HttpSession session = req.getSession();
		
		if(uid == null || name == null || uid.equals("") || name.equals("")){
			out.print("�Բ���,��Ĳ�����Ϊ��!");
			return;
		}
		
		User user = new User();
		user.setName(name);
		user.setUid(uid);
		//����ʱ��
		user.setTime(new Date().getTime());
		//�����������
		user.setSerial((new Date().getTime())+""+(new Random(100).nextInt(50)));
		session.setAttribute("user", user);
		rsp.sendRedirect("admin/success.jsp");
		
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse rsp)
                     throws ServletException,IOException{

		doGet(req,rsp);
   }
}
