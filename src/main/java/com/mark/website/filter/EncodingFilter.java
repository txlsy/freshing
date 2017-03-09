package com.mark.website.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

	private String charset = null;
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		req.setCharacterEncoding(charset);
		res.setCharacterEncoding(charset);
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		charset = config.getInitParameter("CharSet");
		if(null == charset) charset = "UTF-8";
	}

}
