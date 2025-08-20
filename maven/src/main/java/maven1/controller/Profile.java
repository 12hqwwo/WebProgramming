package maven1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns= {"/profile"})
public class Profile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false); // false để không tạo mới
        if(session!=null){
        	String name=(String)session.getAttribute("name");
        	out.print("Chào bạn "+name+" đã đến với trang quản lý tài khoản");
        	}
        	else {
        	out.print("Xin vui lòng đăng nhập");
        	response.sendRedirect("Login1.html");
    
        	}
        }
}
