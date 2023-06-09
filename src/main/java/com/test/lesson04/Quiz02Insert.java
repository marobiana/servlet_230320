package com.test.lesson04;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.MysqlService;

@WebServlet("/lesson04/quiz02_insert")
public class Quiz02Insert extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// request parameter 꺼냄
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		
		// DB 연결
		MysqlService mysqlService = MysqlService.getInstance(); // DB 연결을 위한 객체 생성(싱글턴이라 한개만 생성됨)
		mysqlService.connect(); // DB 연결
		
		// insert db
		String insertQuery = "insert into `bookmark`(`name`, `url`, `createdAt`, `updatedAt`)"
				+ "values ('" + name + "', '" + url + "', now(), now());";
		try {
			mysqlService.update(insertQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// DB 연결 해제
		mysqlService.disconnect();
		
		// 북마크 리스트 이동(Redirect)
		response.sendRedirect("/lesson04/quiz02/bookmarkList.jsp");
	}
}





