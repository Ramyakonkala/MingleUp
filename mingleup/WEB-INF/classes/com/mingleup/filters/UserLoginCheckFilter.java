package com.mingleup.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLoginCheckFilter implements Filter {

	public void destroy() {
		System.out.println("UserLoginCheckFilter destroy()");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hRequest =(HttpServletRequest)request;
		HttpServletResponse hResponse = (HttpServletResponse)response;
		HttpSession hs = hRequest.getSession();
		String user = (String)hs.getAttribute("sname");
		//int user_id = (Integer) hs.getAttribute("suser_id");
		if(user == null) {
			hResponse.sendRedirect("login.jsp?error=please login to continue");
		}
		else{
		chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("UserLoginCheckFilter init()");
	}

}
