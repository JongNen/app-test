package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import data.Post;


@WebServlet("/user/detail")
public class detailController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SqlSessionFactory factory = (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");
		SqlSession sqlSession = factory.openSession();
		
		String id = req.getParameter("id");
		
		List<Post> detail = sqlSession.selectList("posts.findById", id);
		
		req.setAttribute("detail", detail);

		sqlSession.close();
		
		req.getRequestDispatcher("/WEB-INF/views/user/detail.jsp").forward(req, resp);

		
	}
}
