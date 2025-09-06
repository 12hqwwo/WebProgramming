package tuan2_mvc3.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tuan2_mvc3.models.User;
import tuan2_mvc3.services.UserService;
import tuan2_mvc3.services.impl.UserServiceImp;
import jakarta.servlet.RequestDispatcher;

@WebServlet(urlPatterns = "/trangchu")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// hằng số
	public static final String SESSION_USERNAME = "username";
	public static final String COOKIE_REMEMBER = "username";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// check session
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
		    resp.sendRedirect(req.getContextPath() + "/admin/category/list");
		    return;
		}


		// check cookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (COOKIE_REMEMBER.equals(cookie.getName())) {
					session = req.getSession(true);
					session.setAttribute("username", cookie.getValue());
					req.getRequestDispatcher("views/waiting.jsp").forward(req, resp);
					// return;
				}
			}
		}

		RequestDispatcher rd = req.getRequestDispatcher("views/login.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");
		boolean isRememberMe = "on".equals(remember);

		String alertMsg = "";

		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("views/login.jsp").forward(req, resp);
			return;
		}

		UserService service = new UserServiceImp();
		User user = service.login(username, password);

		if (user != null) {
		    HttpSession session = req.getSession(true);
		    session.setAttribute("account", user);

		    resp.sendRedirect(req.getContextPath() + "/admin/category/list");
		}

		 else {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("views/login.jsp").forward(req, resp);
		}
	}

}
