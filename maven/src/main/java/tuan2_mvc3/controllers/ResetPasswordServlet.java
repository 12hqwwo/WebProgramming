package tuan2_mvc3.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tuan2_mvc3.dao.UserDao;
import tuan2_mvc3.dao.impl.UserDaoImp;

@WebServlet(urlPatterns = {"/reset"})
public class ResetPasswordServlet extends HttpServlet {
	private UserDao userDAO = new UserDaoImp();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String newPassword = request.getParameter("newPassword");
		String email = (String) request.getSession().getAttribute("resetEmail");

		if (email != null && newPassword != null && !newPassword.isEmpty()) {
			userDAO.updatePassword(email, newPassword);

			request.getSession().removeAttribute("resetEmail");
			request.setAttribute("msg", "Cập nhật mật khẩu thành công. Mời bạn đăng nhập!");
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		} else {
			request.setAttribute("alert", "Có lỗi xảy ra, vui lòng thử lại!");
			request.getRequestDispatcher("/views/reset.jsp").forward(request, response);
		}
	}
}
