package com.image.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.image.model.Image;
import com.image.util.DBUtil;

/**
 * Handles the CRUD operations for the image object
 * @author ambika_b
 *
 */
public class ImageDao {

	Connection connection;

	public ImageDao() {
		connection = DBUtil.getConnection();
	}

	public void deleteImage(String imageName) {
		// TODO Auto-generated method stub

	}

	public List<Image> getAllImages() {
		List<Image> images = new ArrayList<Image>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from images");
			while (rs.next()) {
				Image image = new Image();
				image.setName(rs.getString("imageName"));
				image.setImage(rs.getBinaryStream("image"));
				images.add(image);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return images;
	}

	public Image getImageByName(String imageName) throws SQLException {
		String selectSQL = "select * from images where imageName = '" + imageName +"'";
		PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
		ResultSet rs = preparedStatement.executeQuery(selectSQL);
		rs.next();
		Image image = new Image();
		image.setImage(rs.getBinaryStream("image"));
		image.setName(rs.getString("imageName"));
		return image;
	}

	public void addImage(Image image) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into images(imageName,image) values (?, ? )");
			preparedStatement.setString(1, image.getName());
			preparedStatement.setBlob(2, image.getImage());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
