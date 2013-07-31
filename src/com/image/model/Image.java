package com.image.model;

import java.io.InputStream;

/**
 * image model (as stored in the db)
 * @author ambika_b
 *
 */

public class Image {
	private String name;
	private InputStream image;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public InputStream getImage() {
		return image;
	}
	public void setImage(InputStream image) {
		this.image = image;
	}
}
