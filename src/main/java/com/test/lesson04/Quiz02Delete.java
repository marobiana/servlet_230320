package com.test.lesson04;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.MysqlService;

@WebServlet("/lesson04/quiz02_delete")
public class Quiz02Delete extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// request paramter  -> id
		int id = Integer.parseInt(request.getParameter("id"));
		
		// DB 연결
		MysqlService mysqlService = MysqlService.getInstance(); 
		mysqlService.connect(); // DB 연결
		
		// DELETE 수행
		String deleteQuery = "delete from `bookmark` where id=" + id;
		try {
			mysqlService.update(deleteQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// DB 연결 해제
		mysqlService.disconnect(); // DB 해제
		
		// 북마크 목록 화면 이동 (Redirect)
		response.sendRedirect("/lesson04/quiz02/bookmarkList.jsp");
	}
}









