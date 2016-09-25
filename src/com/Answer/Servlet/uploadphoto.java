package com.Answer.Servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;

/**
 * Servlet implementation class uploadphoto
 */
@WebServlet("/uploadphoto")
public class uploadphoto extends HttpServlet {

	private static final String DISK = "E:";

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String FileName = new String();
		InputStream stream = null;
		OutputStream outstream = null;
		// 创建工厂，deskfileitemfactory
		DiskFileItemFactory fac = new DiskFileItemFactory();
		// 生产文件上传核心类
		ServletFileUpload SfileUpload = new ServletFileUpload(fac);
		// 利用文件上传核心类进行解析requsert
		try {
			List<FileItem> parseRequest = SfileUpload.parseRequest(request);
			if (parseRequest.size() > 0) {
				File dir = new File(DISK + "/photo/");

				if (!dir.exists()) {
					dir.mkdirs();
				}

				String userdir = request.getParameter("dir");

				if (userdir != null && !userdir.equals("")) {
					dir = new File(dir, userdir);

					if (!dir.exists()) {
						dir.mkdirs();
					}
				}

				File uploadedfile = null;

				// 遍历集合
				for (FileItem f : parseRequest) {
					if (f.isFormField()) {// 普通字段信息
						String dirName = f.getFieldName();
						if ("dir".equals(dirName)) {
							String ud = f.getString("UTF-8");
							if (!ud.equals(dir.getName())) {
								dir = new File(dir, ud);
								if (!dir.exists()) {
									dir.mkdirs();
									if (uploadedfile != null) {
										uploadedfile.renameTo(new File(dir, uploadedfile.getName()));
									}
								}
							}
						}

					} else {// 文件内容
						FileName = f.getName();
						// String headname = "E:/photo/" + FileName;
						stream = f.getInputStream();

						File file = new File(dir, FileName);
						outstream = new FileOutputStream(file);
						byte data[] = new byte[2048];
						int datasize = 0;
						while ((datasize = stream.read(data)) != -1) {
							outstream.write(data, 0, datasize);
						}
						outstream.flush();

						outstream.close();
						outstream = null;
						stream.close();
						stream = null;

						uploadedfile = file;

						JSONObject jo = new JSONObject();
						jo.put("status", true);
						jo.put("msg", "文件[" + FileName + "]上传成功");
						response.getWriter().append(jo.toString()).flush();
					}
				}
			} else {
				JSONObject jo = new JSONObject();
				jo.put("status", false);
				jo.put("msg", "未发现文件");
				response.getWriter().append(jo.toString()).flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
			JSONObject joe = new JSONObject();
			try {
				joe.put("status", false);
				joe.put("msg", e.getMessage());
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			response.getWriter().append(joe.toString()).flush();
		} finally {
			if (stream != null)
				stream.close();
			if (outstream != null)
				outstream.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
