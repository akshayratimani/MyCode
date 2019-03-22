package com.slk.entity;

public class Products {
	
	int id;
	String name;
	float price;
	float rating;
	String img;
	
	
	public Products() {

	}

	public Products(int id, String name, float price, float rating, String img) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.rating = rating;
		this.img = img;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", price=" + price + ", rating=" + rating + ", img=" + img
				+ "]";
	}

	

	
	
}
