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
 * Servlet Filter implementation class WordManageFilter
 */
@WebFilter("/WordManageFilter")
public class WordManageFilter implements Filter {

    /**
     * Default constructor. 
     */
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private Connection ct=null;
	
    public WordManageFilter() {
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
		String choose=request.getParameter("choose");
		System.out.println(choose+"留言选择");
		//String sql="select * from users where username = ?";//查询该用户是否存在
		try{
			ct=ConnectDB.getConnection();
	
			if(choose.length()!=0){
				if(choose.equals("0")){//进行查询
						String sql0="select time,receiver,content from word where sender=?;";//这里得到的是照片的地址，具体显示还没有实现，待定
						ps=ct.prepareStatement(sql0);
						ps.setString(1, username);
						rs=ps.executeQuery();
						System.out.println("时间\t\t\t留言对象\t\t\t留言内容<br>");
						while(rs.next()){
							System.out.println(rs.getString(1)+"\t\t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3)+"<br>");
						}
						request.getRequestDispatcher("manageok.jsp").forward(request,response);
					
				}
				else{
				    	String sql1="delete from word where sender= ?;";
						ps=ct.prepareStatement(sql1);
						ps.setString(1, username);
						int i1= ps.executeUpdate();
						if(i1!=0){
							System.out.print("delete successfully!\n");
							System.out.println("<br/>"+"该用户"+username+"此条记录已成功被删除");
							request.getRequestDispatcher("manageok.jsp").forward(request,response);
						}
				}
			}
			else{
				chain.doFilter(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			ConnectDB.closeAll(ct, ps, rs);	
		}		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
