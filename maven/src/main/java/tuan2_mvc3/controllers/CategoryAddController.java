package tuan2_mvc3.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.eclipse.tags.shaded.org.apache.bcel.classfile.Constant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Import cho file upload Jakarta

import tuan2_mvc3.models.Category;
import tuan2_mvc3.models.User;
import tuan2_mvc3.services.CategoryService;
import tuan2_mvc3.services.impl.CategoryServiceImpl;


@WebServlet(urlPatterns = "/category/add")
public class CategoryAddController extends HttpServlet {
    private static final long serialVersionUID = 1L; // Thêm dòng này
    private CategoryService service = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("account");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/trangchu");
            return;
        }
        req.getRequestDispatcher("/views/add-category.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User user = (User) req.getSession().getAttribute("account");
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        int userId = user.getId();

        String cateName = req.getParameter("cateName");
        String icons = req.getParameter("icons");

        Category category = new Category();
        category.setCatename(cateName);
        category.setIcon(icons);
        category.setCateid(userId);
        service.insert(category);

        resp.sendRedirect(req.getContextPath() + "/category/list");
    }
}