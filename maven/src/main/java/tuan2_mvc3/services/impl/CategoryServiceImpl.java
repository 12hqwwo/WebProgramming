package tuan2_mvc3.services.impl;

import java.io.File;
import java.util.List;

import tuan2_mvc3.dao.CategoryDAO;
import tuan2_mvc3.dao.impl.CategoryDaoImpl;
import tuan2_mvc3.models.Category;
import tuan2_mvc3.services.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    CategoryDAO categoryDao = new CategoryDaoImpl();

    @Override
    public void insert(Category category) {
        categoryDao.insert(category);
    }

    @Override
    public void delete(int id) {
        categoryDao.delete(id);
    }

    // Sửa phương thức get để nhận tham số int thay vì String
    @Override
    public Category get(int id) {
        return categoryDao.get(id);
    }
    
    @Override
    public Category get(String name) {
        return categoryDao.get(name);
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public List<Category> search(String catename) {
        return categoryDao.search(catename);
    }

    @Override
    public void edit(Category newCategory) {
        Category oldCategory = categoryDao.get(newCategory.getCateid());
        if (oldCategory != null) {
            oldCategory.setCatename(newCategory.getCatename());
            if (newCategory.getIcon() != null) {
                // XOA ANH CU DI
                String fileName = oldCategory.getIcon();
                final String dir = "D:\\";
                File file = new File(dir + "/category/" + fileName);
                if (file.exists()) {
                    file.delete();
                }
                oldCategory.setIcon(newCategory.getIcon());
            }
            categoryDao.edit(oldCategory);
        }
    }
}