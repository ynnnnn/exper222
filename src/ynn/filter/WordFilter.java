package ynn.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import ynn.object.Word;

/**
 * Servlet Filter implementation class WordFilter
 */
@WebFilter("/*")
public class WordFilter implements Filter {

    /**
     * Default constructor. 
     */
    public WordFilter() {
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
		// TODO Auto-generated method stub
		// place your code here
		request.setCharacterEncoding("utf-8");
		// pass the request along the filter chain
		
		MyRequest req=new MyRequest((HttpServletRequest)request);
		
		chain.doFilter(req, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
class MyRequest extends HttpServletRequestWrapper{

	public MyRequest(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getParameter(String name){
		String str=super.getParameter(name);
		List<String> list=Word.getWords();
		for(String word:list){
			str = str.replaceAll(word, "*");
		}
		return str;
		
	}
}
