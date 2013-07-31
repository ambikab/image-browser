package com.image.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.image.dao.ImageDao;
import com.image.model.Image;

/**
 * Fetches the image with a given name to the view 
 * Content sent as jpeg
 * @author ambika_b
 *
 */
public class ImageViewController extends HttpServlet {

	private ImageDao dao;

	public ImageViewController() {
		super();
		dao = new ImageDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("imgId");
		String contentType = "image/jpg";
		BufferedInputStream bis;
		try {
			Image image = dao.getImageByName(name);
			bis = new BufferedInputStream(image.getImage());
			response.setContentType(contentType);
			response.setHeader("Content-Disposition", "inline; filename=\"" + image.getName() + ".jpeg\"");
			BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream());
			for (int data; (data = bis.read()) > -1;) {
				output.write(data);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}             
	}

}