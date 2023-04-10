package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

@WebServlet("/user/modify-task")
public class modifyTaskController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		SqlSessionFactory factory = (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");
		SqlSession sqlSession = factory.openSession();
		
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		
	    Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("title", title);
		map.put("content", content);
		
		sqlSession.update("posts.modify", map);
		
		sqlSession.commit();
		sqlSession.close();
		
		
		
		req.getRequestDispatcher("/WEB-INF/views/user/list.jsp").forward(req, resp);
	}
}
