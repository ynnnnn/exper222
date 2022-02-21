package ynn.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


import ynn.DBdao.ConnectDB;

/**
 * Servlet Filter implementation class Three
 */
@WebFilter("/ThreeFilter")
public class ThreeFilter implements Filter {
	
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private Connection ct=null;
	

    /**
     * Default constructor. 
     */
    public ThreeFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("过滤器销毁了噢");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("过滤器working噢");
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		req.setAttribute("username", username);
		
		
		try{
			if(username!=null & password!=null)
			{
				String sql="select * from users where username = ?";
					ct=ConnectDB.getConnection();
					ps=ct.prepareStatement(sql);
					ps.setString(1, username);
					rs=ps.executeQuery();
					if(rs.next()){
						String flag=rs.getString(4).trim();
						String pwd=rs.getString(3).trim();
						if(password.equals(pwd)){//密码验证
							if("0".equals(flag)){
								//req.setAttribute("password", password);
								req.getRequestDispatcher("adminloginchoose.jsp").forward(req,resp);
								
							}else{
								//req.setAttribute("password", password);
								req.getRequestDispatcher("loginok.jsp").forward(req,resp);
								
								System.out.println(username);
							}
						}
					}else{
						req.getRequestDispatcher("login.jsp").forward(req,resp);
						
					}
			}
			else{
				chain.doFilter(req, resp);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			ConnectDB.closeAll(ct, ps, rs);
		}
		
		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤器创建了噢");
	}
	
}
