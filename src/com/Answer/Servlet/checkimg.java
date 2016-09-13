package com.Answer.Servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class checkimg
 */
@WebServlet("/checkimg")
public class checkimg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public checkimg() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String password=NoCache(true, response);
		request.getSession().setAttribute("checkNum", password);
	}

	/**
	 * 取消缓存
	 * 
	 * @param NO_or_YES
	 * @param response
	 */
	private String  NoCache(boolean NO_or_YES, HttpServletResponse response) {
		String password="";
		if (NO_or_YES) {
			response.setDateHeader("Expires", -1);// 缓存保存时间，（-1则是不使用缓存，单位：毫秒）
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Pragma", "no-cache");
		}
		try {
			password = checkImg(response);//制作验证码，方法返回验证码
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return password;
	}

	/**
	 * 创建验证码图
	 * 
	 * @return
	 * @throws Exception
	 */
	private String checkImg(HttpServletResponse response) throws Exception {
		int width = 120;
		int height = 30;
		String password = "";
		// 创建密码库
		char[] passwords = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', '1',
				'h', 'i', 'j', '0', 'k', 'l', '2', 'm', 'n', '3', 'o', '4',
				'p', 'q', 'r', '5', 's', 't', 'u', '6', 'v', 'w', '7', 'x',
				'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
				'M', 'N', 'O', 'P', 'Q', 'R', 'R', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z', '8', 'y', '9', 'z' };
		// 创建图片
		BufferedImage img = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		// 从该图获取画布
		Graphics2D g = (Graphics2D) img.getGraphics();
		// 设置背景色
		// 随机产生背景颜色
		Color bg = new Color(Rn(155), Rn(155), Rn(155));
		g.setColor(bg);
		g.fillRect(0, 0, width - 1, height - 1);
		// 绘制干扰线条
		for (int i = 0; i < Rn(3); i++) {
			g.setColor(new Color(Rn(255), Rn(255), Rn(255)));
			g.drawLine(Rn(10), Rn(height), width - 10 + Rn(10), Rn(height));
			g.drawLine(Rn(width), Rn(5), Rn(width), height - 5 + Rn(5));
		}
		// 绘制干扰点
		for (int i = 0; i < 20 + Rn(10); i++) {
			g.setColor(new Color(Rn(255), Rn(255), Rn(255)));
			g.fillOval(Rn(width), Rn(height), Rn(10), Rn(10));
		}
		// *绘制验证码
		for (int i = 0; i < 4; i++) {
			char c = passwords[Rn(passwords.length)];
			g.setColor(new Color(100 + Rn(155), 100 + Rn(155), 100 + Rn(155)));
			Font f = new Font("", Font.BOLD, 23 + Rn(5));
			g.setFont(f);
			double r = Double.parseDouble(Rn(50) + "") / 180 * Math.PI;
			if (Rn(5) < 2) {
				r *= -1;
			}
			int x = 10 + i * 28;
			int y = 20 + Rn(5);
			g.rotate(r, x, y);
			g.drawString("" + c, x, y);
			g.rotate(-r, x, y);
			password += c;
		}
		System.out.println("验证码：" + password);
		try{ImageIO.write(img, "png", response.getOutputStream());}catch(Exception e){};
		return password;
	}

	private int Rn(int max) {
		return new Random().nextInt(max);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
