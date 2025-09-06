package tuan2_mvc3.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tuan2_mvc3.DBConnection;
import tuan2_mvc3.dao.CategoryDAO;
import tuan2_mvc3.models.Category;

public class CategoryDaoImpl extends DBConnection implements CategoryDAO {

	@Override
	public void insert(Category category) {
		String sql = "INSERT INTO Category (cate_name, icons) VALUES (?, ?)";
		try (Connection con = super.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, category.getCatename());
			ps.setString(2, category.getIcon());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Category category) {
		String sql = "UPDATE Category SET cate_name = ?, icons = ? WHERE cate_id = ?";
		try (Connection con = super.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, category.getCatename());
			ps.setString(2, category.getIcon());
			ps.setInt(3, category.getCateid());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM Category WHERE cate_id = ?";
		try (Connection con = super.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Category get(int id) {
		String sql = "SELECT cate_id, cate_name, icons FROM Category WHERE cate_id = ?";
		try (Connection con = super.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Category category = new Category();
				category.setCateid(rs.getInt("cate_id"));
				category.setCatename(rs.getString("cate_name"));
				category.setIcon(rs.getString("icons"));
				return category;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> getAll() {
		List<Category> categories = new ArrayList<>();
		String sql = "SELECT * FROM Category";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			System.out.println("=== CategoryDaoImpl.getAll() ===");
			while (rs.next()) {
				System.out.println("ID: " + rs.getInt("cate_id") + " | Name: " + rs.getString("cate_name") + " | Icon: "
						+ rs.getString("icons"));
				Category category = new Category();
				category.setCateid(rs.getInt("cate_id"));
				category.setCatename(rs.getString("cate_name"));
				category.setIcon(rs.getString("icons"));
				categories.add(category);
			}
			System.out.println("Total categories: " + categories.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public Category get(String name) {
		String sql = "SELECT cate_id, cate_name, icons FROM Category WHERE cate_name = ?";
		try (Connection con = super.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Category category = new Category();
				category.setCateid(rs.getInt("cate_id"));
				category.setCatename(rs.getString("cate_name"));
				category.setIcon(rs.getString("icons"));
				return category;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> search(String keyword) {
		List<Category> list = new ArrayList<>();
		String sql = "SELECT cate_id, cate_name, icons FROM Category WHERE cate_name LIKE ?";
		try (Connection con = super.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, "%" + keyword + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setCateid(rs.getInt("cate_id"));
				category.setCatename(rs.getString("cate_name"));
				category.setIcon(rs.getString("icons"));
				list.add(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
