package maven1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns= {"/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		// lấy dữ liệu từ tham số của form
		String username = req.getParameter("username"); //
		String password = req.getParameter("password");
		if (username.equals("hnq") && password.equals("123")) {
			Cookie cookie = new Cookie("username", username); // khởi tạo cookie
			// thiết lập thời gian tồn tại 30s của cookie
			cookie.setMaxAge(30);
			// thêm cookie vào response
			resp.addCookie(cookie);
			// chuyển sang trang HelloServlet
			resp.sendRedirect(req.getContextPath() + "/helloCookie");
		} else {
			// chuyển sang trang LoginServlet
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter()
				.println("<form method='post' action='login'>" + "User: <input type='text' name='username'/><br/>"
						+ "Pass: <input type='password' name='password'/><br/>" + "<input type='submit' value='Login'/>"
						+ "</form>");
	}
}