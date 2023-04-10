package controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import data.Post;
import data.User;




@WebServlet("/user/write-task")
public class writeTaskController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		User logonUser = (User)session.getAttribute("logonUser");
		
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String id = UUID.randomUUID().toString().split("-")[0];
		String userId;
		
		
		if(req.getParameter("userId") != null) {
			userId = req.getParameter("userId");
		}else {
			userId = logonUser.getId();
		}
		
		
		
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("title", title);
		map.put("content", content);
		map.put("userId", userId);
		
		if(req.getParameter("userPass") != null) {
			String userPass = req.getParameter("userPass");
			map.put("userPass", userPass);
		}
		

		SqlSessionFactory factory = (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");
		SqlSession sqlSession = factory.openSession();
		
		sqlSession.insert("posts.create", map);
	
		sqlSession.commit();
		sqlSession.close();
	
		req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
	}
}
