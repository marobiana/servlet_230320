package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlMappingQuiz02 extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 한글 깨짐 방지
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		
		Date now = new Date();
		
		// 현재 시간은 14시 52분 43초 입니다.
		SimpleDateFormat sdf = new SimpleDateFormat("HH시 mm분 ss초");
		PrintWriter out = response.getWriter();
		
		out.print("현재 시간은 ");
		out.print(sdf.format(now) + " 입니다.");
	}
}





