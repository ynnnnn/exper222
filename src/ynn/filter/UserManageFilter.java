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
import javax.servlet.http.HttpServletResponse;

import ynn.DBdao.ConnectDB;
import ynn.DBdao.DBManage;
import ynn.object.User;

/**
 * Servlet Filter implementation class ManageFilter
 */
@WebFilter("/UserManageFilter")
public class UserManageFilter implements Filter {
	
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private Connection ct=null;
	

    /**
     * Default constructor. 
     */
    public UserManageFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("过滤器gongzuo了噢");
		// TODO Auto-generated method stub
		// place your code here
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String choose=request.getParameter("choose");
		System.out.print(choose);
		
		HttpServletResponse resp = (HttpServletResponse) response;
        
		
			String sql="select * from users where username = ?";
			try{
				ct=ConnectDB.getConnection();
				ps=ct.prepareStatement(sql);
				ps.setString(1, username);
				rs=ps.executeQuery();
					switch(choose){
					case "0":
						if(username!=null && password!=null){
							if(!rs.next()){
								User user = new User(username,password);
								DBManage.Insertone(user);
								System.out.print("insert successfully!\n");
								System.out.println("<br/>"+"新增加的用户名是:<br/>"+"<br/>"+username+"该用户的密码是:<br/>"+password);
								request.getRequestDispatcher("manageok.jsp").forward(request,resp);
							}
							else{
								request.getRequestDispatcher("error.jsp").forward(request,resp);
								System.out.print("insert unsuccessfully\n");
							}
								
						}
						else{
							chain.doFilter(request, resp);
						}
						break;
					case "1":
						if(username!=null){
							if(rs.next()){
								String sql1="delete from users where username = ?;";
								ps=ct.prepareStatement(sql1);
								ps.setString(1, username);
								int i1= ps.executeUpdate();
								if(i1!=0){
									System.out.print("delete successfully!\n");
									System.out.println("<br/>"+"该用户"+username+"已经成功被删除");
									request.getRequestDispatcher("manageok.jsp").forward(request,response);
								}
							}
							else{
								System.out.print("delete unsuccessfully,you can validate the user is yes or no \n");
								request.getRequestDispatcher("error.jsp").forward(request,resp);
							}
						}
						else{
							chain.doFilter(request, resp);
						}
						break;
					case "2":
						if(username!=null){
							if(rs.next()){
								String sql2="select * from users where username = ?;";
								ps=ct.prepareStatement(sql2);
								ps.setString(1, username);
								rs= ps.executeQuery();
								if(rs.next()) {
									System.out.println("查询成功，该用户的信息如下：");
									System.out.println("用户名: "+username+",密码: "+rs.getString("password")+",管理员标记是:"+rs.getString("flag"));
									request.getRequestDispatcher("manageok.jsp").forward(request,response);
								}
							}
							else
							{
								System.out.print("query unsuccessfully,you can validate the user is yes or no \n");
								request.getRequestDispatcher("error.jsp").forward(request,resp);
							}
						}
						else{
							chain.doFilter(request, resp);
						}
						break;
					case "3":
						if(username!=null){
							if(rs.next()){
								String sql3="update users set flag=? where username=?;";
								ps=ct.prepareStatement(sql3);
								ps.setString(1, "0");
								ps.setString(2, username);
								int i3= ps.executeUpdate();
								if(i3!=0){
									System.out.println("<br/>"+"该用户"+username+"已经被设为管理员");
									System.out.print("update successfully!\n");
									request.getRequestDispatcher("manageok.jsp").forward(request,response);
								}
							}
							else{
								request.getRequestDispatcher("error.jsp").forward(request,resp);
								System.out.print("update unsuccessfully……\n");
							}
						}
						else{
							chain.doFilter(request, resp);
						}
						break;
					default:
			            System.out.println("未知选项");
					}
				
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					ConnectDB.closeAll(ct, ps, rs);	
				}			
		}
		

		// pass the request along the filter chain

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤器kaishi了噢");
	}

}
