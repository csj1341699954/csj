package com.fh.shop.api.list.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Servlet Filter implementation class WebContextFiter
 */
public class WebContextFiter implements Filter {

    /**
     * Default constructor. 
     */
    public WebContextFiter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("==============绑定doFilter");
		WebContext.setRequest((HttpServletRequest) request);
		try {
			 System.out.println("========开始doFilter");
			chain.doFilter(request, response);
			System.out.println("========结束doFilter");
		}finally{
			WebContext.remove();
			System.out.println("========销毁doFilter");
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
