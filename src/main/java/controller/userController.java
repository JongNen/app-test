package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mindrot.jbcrypt.BCrypt;


import data.User;



@WebServlet("/user/*")
public class userController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String ctxPath = req.getContextPath();
		String uri = req.getRequestURI().substring(ctxPath.length());
		HttpSession session = req.getSession();
		
		switch (uri) {

		case "/user/login" -> {
		
			
			req.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(req, resp);
		}
		case "/user/login-task" -> {
			String id = req.getParameter("id");
			String pass = req.getParameter("pass");
			
		
			
			SqlSessionFactory factory = (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");
			SqlSession sqlSession = factory.openSession();
			User found = sqlSession.selectOne("users.findById", id);

			if (found.getPass().equals(pass)) {
				
				session.setAttribute("logon", true);
				session.setAttribute("logonUser", found);
			
				// ================================================
				resp.sendRedirect("/index");
				return;
			} else {
				resp.sendRedirect("/user/login?cause=error");
				return;
			}
		}
		
		case "/user/logout" -> {
			
			session.setAttribute("logon", false);
			session.invalidate();
			resp.sendRedirect("/user/login");
		}


		}
	}
}
