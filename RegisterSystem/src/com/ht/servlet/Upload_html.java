package com.ht.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Upload_html extends HttpServlet {

	@Override
	// 客户端的连接被封装到request这个对象中，参数的提取也是从这个对象中拿
	// 而反馈给客户端的内容封装在response这个对象中，比如返回数据也是通过这个对象来完成

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		// 将接收到的数据再返回给客户端
		PrintWriter pw = response.getWriter();
		// 使用方法getParameter来获取键值对应的value值，这里的Key参数要和客户端传上来的Key值一样！\
		ServletInputStream is = request.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("收到信息："+URLDecoder.decode(sb.toString(),"UTF-8"));
		pw.println("ok");
		pw.close();

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 跳转到doGet当中去处理
		doGet(request, response);
	}

}
