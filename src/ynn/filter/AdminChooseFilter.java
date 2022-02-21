package ynn.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import ynn.DBdao.ConnectDB;

/**
 * Servlet Filter implementation class AdminChooseFilter
 */
@WebFilter("/AdminChooseFilter")
public class AdminChooseFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminChooseFilter() {
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
		String username=request.getParameter("username");
		request.setAttribute("username", username);//传参，用户名，用于写入数据库
		String option=request.getParameter("option");
		try{
			if(option.length()!=0){
				if(option.equals("0")){//选择0，跳转游客页面
					request.getRequestDispatcher("guest1.jsp").forward(request,response);
					System.out.println("跳转游客成功");
				}
				else if(option.equals("1")){//跳转会员
					request.getRequestDispatcher("loginok.jsp").forward(request, response);
					System.out.println("跳转会员成功");
				}
				else{//跳转会员
					request.getRequestDispatcher("adminloginok.jsp").forward(request, response);
					System.out.println("跳转管理员成功");
				}
			}
			else{
				chain.doFilter(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("跳转");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
