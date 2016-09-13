package com.Answer.Servlet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class filedownload extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String FilePAth = (request.getParameter("path"));

		File f = new File(FilePAth);

		response.setContentType("text/plain");
		response.setHeader("Location", URLEncoder.encode(f.getName(), "UTF-8"));
		response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(f.getName(), "UTF-8"));
		response.addHeader("Content-Length", (new Long(f.length())).toString());// 设置大小
		ServletOutputStream outs = response.getOutputStream();
		FileInputStream fin = new FileInputStream(f);
		BufferedInputStream bin = new BufferedInputStream(fin);

		byte[] data = new byte[2048];
		int datasize = 0;

		while ((datasize = bin.read(data)) != -1) {
			outs.write(data, 0, datasize);
		}
		bin.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
