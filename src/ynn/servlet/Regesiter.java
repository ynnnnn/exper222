package ynn.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ynn.DBdao.DBManage;
import ynn.object.*;

/**
 * Servlet implementation class Regesiter
 */
@WebServlet("/Regesiter")
public class Regesiter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Regesiter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("regesiter\n");
		
		//1,获取username,password1,password2
		String username=request.getParameter("username");
		String password1=request.getParameter("password1");
		String password2=request.getParameter("password2");
		
		if(!password1.equals("")){
		
			if(password1.equals(password2)){
			
				//2,进行核验
				User user=new User(username,password2);
				
				//
				try{
					request.setCharacterEncoding("utf-8");
					if(DBManage.validateReg(user)){
						request.getRequestDispatcher("regesiter.jsp").forward(request,response);
						System.out.print("注册失败，用户已经存在\n");
						//request.getRequestDispatcher("regesiterok.jsp").forward(request,response);
						
					}
					else{
						DBManage.Insertone(user);
						response.sendRedirect("regesiterok.jsp");
					}
					
					
				}catch(SQLException e){
					System.out.println("MySql出错！!");
					e.printStackTrace();
				}catch(Exception e){
					e.printStackTrace();
				}
	
			}
		}
		else{
			request.getRequestDispatcher("regesiter.jsp").forward(request,response);
			System.out.print("注册失败，请输入密码\n");
		}
	}

}
