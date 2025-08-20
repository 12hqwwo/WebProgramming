package maven1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class LoginSession
 */
@WebServlet(urlPatterns= {"/loginsession"})
public class LoginSession extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginSession() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("hnq".equals(username) && "123".equals(password)) {
            // Tạo session
            HttpSession session = request.getSession();
            session.setAttribute("name", username);

            
        } else {
            // Sai thông tin → quay lại trang Login
            request.setAttribute("errorMessage", "Thông tin bạn nhập không chính xác!");
            request.getRequestDispatcher("Login.html").forward(request, response);
        }
    }
}
