package tuan2_mvc3.controllers;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tuan2_mvc3.models.Category;
import tuan2_mvc3.services.CategoryService;
import tuan2_mvc3.services.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = { "/admin/category/list" })
public class CategoryController extends HttpServlet {
	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Category> cateList = cateService.getAll();
		req.setAttribute("cateList", cateList);


	        // thêm contentPage để layout biết include trang nào
	        req.setAttribute("contentPage", "/views/list-category.jsp");

	        // khai báo dispatcher
	        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin-layout.jsp");
	        dispatcher.forward(req, resp);
	}
	
}
