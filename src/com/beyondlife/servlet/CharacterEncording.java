package com.beyondlife.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class CharacterEncording implements Filter {

	
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		if(request.getCharacterEncoding() == null){
			request.setCharacterEncoding("gb2312");
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		

	}

}
