package tuan2_mvc3.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import tuan2_mvc3.models.Category;
import tuan2_mvc3.services.CategoryService;
import tuan2_mvc3.services.impl.CategoryServiceImpl;

@WebServlet(urlPatterns = "/admin/category/add")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024, // 1MB
    maxFileSize = 5 * 1024 * 1024,   // 5MB
    maxRequestSize = 10 * 1024 * 1024
)
public class CategoryAddController extends HttpServlet {
    private CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // show form
        req.getRequestDispatcher("/views/add-category.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String catename = req.getParameter("catename");

        Part filePart = req.getPart("icon"); // may be null if no file chosen
        String fileName = null;

        if (filePart != null && filePart.getSize() > 0) {
            // get submitted filename (sanitize) and create unique filename
            String submitted = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String ext = "";
            int i = submitted.lastIndexOf('.');
            if (i > 0) ext = submitted.substring(i); // including dot

            // generate unique name to avoid collisions
            fileName = System.currentTimeMillis() + "_" + UUID.randomUUID().toString().substring(0,8) + ext;

            // resolve upload folder inside webapp: <app>/image/
            String uploadPath = req.getServletContext().getRealPath("/image");
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) uploadDir.mkdirs();

            // Full path to save
            String fullPath = uploadPath + File.separator + fileName;
            filePart.write(fullPath); // write absolute path (Tomcat allows it)
        }

        // create and save category
        Category category = new Category();
        category.setCatename(catename);
        category.setIcon(fileName); // may be null if no file
        cateService.insert(category);

        // redirect back to list
        resp.sendRedirect(req.getContextPath() + "/admin/category/list");
    }
}
