package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import data.Post;

@WebServlet("/user/list")
public class listController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int p;
		if (req.getParameter("page") == null) {
			p = 1;
		} else {
			p = Integer.parseInt(req.getParameter("page"));
		}
		
		

		SqlSessionFactory factory = (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");
		SqlSession sqlSession = factory.openSession();
			
		Map<String, Object> map = new HashMap<>();
		map.put("a", (p - 1) * 10 + 1); // "a" , p*6 - 5;
		map.put("b", 10 * p);
		
		List<Post> list = sqlSession.selectList("posts.seachAll", map);
		req.setAttribute("list", list);
		
//		int total = sqlSession.selectList("Posts.countDatas", list);
//		sqlSession.close();
//
//		int lastPage = total / 6 + (total % 6 > 0 ? 1 : 0);
//

//
//		
//		int last = (int) Math.ceil(p / 5.0) * 5;
//		int start = last -4;
//		
//		last = last > lastPage ? lastPage : last;
//		
//		req.setAttribute("start", start); // (1~5) ==> 1 / (6~10) ==>6 / (11~15) ==> 11
//		req.setAttribute("last", last); // (1~5) ==> 5 / (6~10) ==>10 / (11~15) ==> 15
//		
//		boolean existPrev = p >=6;
//		boolean existNext = lastPage - start > 4;
//		req.setAttribute("existPrev", existPrev);
//		req.setAttribute("existNext", existNext);
		
		
		req.getRequestDispatcher("/WEB-INF/views/user/list.jsp").forward(req, resp);
	}	
	
}
