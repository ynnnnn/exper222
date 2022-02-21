package ynn.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


/**
 * Servlet Filter implementation class MemberOpFliter
 */
@WebFilter("/MemberOpFliter")
public class MemberOpFliter implements Filter {
    /**
     * Default constructor. 
     */
    public MemberOpFliter() {
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

		// pass the request along the filter chain
		try{
			String option=request.getParameter("option");
			String username=request.getParameter("username");
			request.setAttribute("username", username);
			
			
			System.out.println(username);
			
			if(option.length()!=0){
				if(option.equals("0")){
					request.getRequestDispatcher("mood.jsp").forward(request,response);
					
					System.out.println(username);
				}
				else if(option.equals("1")){
					request.getRequestDispatcher("upload.jsp").forward(request,response);
					
				}
				else{
					request.getRequestDispatcher("word.jsp").forward(request,response);
					
				}
				
			}
			else{
				chain.doFilter(request, response);
			}
				
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
