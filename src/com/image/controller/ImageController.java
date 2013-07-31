package com.image.controller;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.image.dao.ImageDao;
import com.image.model.Image;

/**
 * Handles the crud operation on the image object
 * @author ambika_b
 *
 */
@MultipartConfig
public class ImageController extends HttpServlet {

	private static String IMAGES = "/listImages.jsp";
	private ImageDao dao;

	public ImageController() {
		super();
		dao = new ImageDao();
	}

	/**
	 * fetches all the list of images from the database
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("listImages")){
			forward = IMAGES;
			request.setAttribute("images", dao.getAllImages());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	/**
	 * Adds new image to the database
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Image image = new Image();
		image.setName(request.getParameter("imageName"));
		InputStream inputStream = null;
        Part filePart = request.getPart("image");
        if (filePart != null) {
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            inputStream = filePart.getInputStream();
        }
		image.setImage(inputStream);
		dao.addImage(image);
		RequestDispatcher view = request.getRequestDispatcher(IMAGES);
		request.setAttribute("images", dao.getAllImages());
		view.forward(request, response);
	}

}
