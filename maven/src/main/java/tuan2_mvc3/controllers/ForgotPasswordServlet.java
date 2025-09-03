package tuan2_mvc3.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tuan2_mvc3.dao.UserDao;
import tuan2_mvc3.dao.impl.UserDaoImp;

@WebServlet(urlPatterns = { "/forgot" })
public class ForgotPasswordServlet extends HttpServlet {
	private UserDao userDAO = new UserDaoImp();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Khi bấm link "Quên mật khẩu", hiển thị form forgot.jsp
		request.getRequestDispatcher("/views/forgot.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");

		if (userDAO.checkExistEmail(email)) {
			request.getSession().setAttribute("resetEmail", email);
			request.getRequestDispatcher("/views/reset.jsp").forward(request, response);
		} else {
			request.setAttribute("alert", "Email không tồn tại!");
			request.getRequestDispatcher("/views/forgot.jsp").forward(request, response);
		}
	}
}
