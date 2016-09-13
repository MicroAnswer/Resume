package com.Answer.Servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.Answer.Bean.User;
import com.Answer.Tools.Application;

/**
 * 改变头像的时候调用该Servlet
 * 
 * @author wwwfa
 * 
 */
public class changehead extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String FileName = new String();
		String FileType = new String();
		InputStream stream = null;
		OutputStream outstream = null;
		// 创建工厂，deskfileitemfactory
		DiskFileItemFactory fac = new DiskFileItemFactory();
		// 生产文件上传核心类
		ServletFileUpload SfileUpload = new ServletFileUpload(fac);
		// 利用文件上传核心类进行解析requsert
		try {
			List<FileItem> parseRequest = SfileUpload.parseRequest(request);
			// 遍历集合
			for (FileItem f : parseRequest) {
				if (f.isFormField()) {// 普通字段信息

				} else {// 文件内容
					FileName = f.getName();
					FileType = FileName.substring(FileName.indexOf(".") + 1)
							.toLowerCase();
					if (FileType.equals("jpg") || "png".equals(FileType)
							|| "bmp".equals(FileType) || "gif".equals(FileType)) {
						User u  = ((User)request.getSession().getAttribute("user"));
						String headname ="/pic/"+"head"+u.getId()+"."+FileType;
						u.setHead(headname);
						stream = f.getInputStream();
						outstream = new FileOutputStream(new File(
								getServletContext().getRealPath(headname)));
						byte data[] = new byte[2048];
						int datasize = 0;
						while ((datasize = stream.read(data)) != -1) {
							outstream.write(data, 0, datasize);
						}
						
						if(Application.getdatabaseManager(request.getSession()).UpdataUser(u)>0){
							request.setAttribute("hint", "头像修改成功");
							request.getRequestDispatcher("/me.jsp")
									.forward(request, response);
						}
					} else {
						request.setAttribute("hint", "请选择图片文件");
						request.getRequestDispatcher("/changehead.jsp")
								.forward(request, response);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stream != null)
				stream.close();
			if (outstream != null)
				outstream.close();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
