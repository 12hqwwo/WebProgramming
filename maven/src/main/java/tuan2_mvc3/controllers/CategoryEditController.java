package tuan2_mvc3.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Import cho file upload
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jakarta.servlet.annotation.WebServlet;
import tuan2_mvc3.models.Category;
import tuan2_mvc3.services.CategoryService;
import tuan2_mvc3.services.impl.CategoryServiceImpl;


@WebServlet(urlPatterns = "/admin/category/edit")
public class CategoryEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Định nghĩa DIR constant hoặc sử dụng từ Constant class
	private static final String DIR = "D:\\upload";
	// Hoặc nếu có class Constant: private static final String DIR = Constant.DIR;

	CategoryService categoryService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Category category = categoryService.get(id);
		req.setAttribute("category", category);

		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/category-edit.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);

		try {
			List<FileItem> formItems = upload.parseRequest(req);
			FileItem fileItem = null;

			String categoryId = "";
			String categoryName = "";
			String status = "";

			for (FileItem item : formItems) {
				if (item.isFormField()) {
					String fieldName = item.getFieldName();
					String fieldValue = item.getString("UTF-8");

					switch (fieldName) {
					case "cateid":
						categoryId = fieldValue;
						break;
					case "catename":
						categoryName = fieldValue;
						break;
					case "status":
						status = fieldValue;
						break;
					}
				} else {
					fileItem = item;
				}
			}

			Category category = new Category();
			category.setCateid(Integer.parseInt(categoryId));
			category.setCatename(categoryName);

			// Xử lý file upload
			if (fileItem != null && fileItem.getSize() > 0) {
				String fileName = System.currentTimeMillis() + "_" + fileItem.getName();
				String uploadPath = DIR + File.separator + "category";

				// Tạo thư mục nếu chưa tồn tại
				File uploadDir = new File(uploadPath);
				if (!uploadDir.exists()) {
					uploadDir.mkdirs();
				}

				// Lưu file
				File storeFile = new File(uploadPath + File.separator + fileName);
				fileItem.write(storeFile);

				category.setIcon(fileName);
			}

			categoryService.edit(category);
			resp.sendRedirect(req.getContextPath() + "/admin/categories");

		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error uploading file: " + e.getMessage());
		}
	}
}