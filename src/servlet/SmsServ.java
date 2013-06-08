package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SmsServ extends HttpServlet {

	private static final long serialVersionUID = -1793126536936145311L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String mobile = request.getParameter("mobile");
		String content = request.getParameter("content");
		content = new String(content.getBytes("ISO-8859-1"),"UTF-8");
		String Interrupt = request.getParameter("isInterrupt");
		
		StringBuffer output = new StringBuffer();
		String[] mobiles = mobile.split(",");
		
		if(content.equals("")){
			out.println("内容不能为空。");
			return;
		}
		for(String s : mobiles)
		{
			if( s.length() != 11 ){
				output.append(s+" 号码错误<br/>");
			}else{
				Boolean flag = sms.SmsMain.sendSms(mobile, content);
				if(flag){
					output.append(s+" 短信发送成功<br/>");
				}else{
					output.append(s+" 短信发送失败<br/>");
					if("true".equals(Interrupt)){
						out.println(output.append("已中断短信发送"));
						return;
					}
				}
			}
		}
		out.println(output);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
