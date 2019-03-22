package com.slk.dao;

import java.util.ArrayList;
import java.util.List;

import com.slk.entity.Products;

public class ShowProductsManager {

	static DaoFactory d = new DaoFactory();

	public ShowProductsManager() {

	}

	public void display() {

		for (Products a : d.getProducts()) {
			System.out.println(":" + a);
		}
	}

	public List<Products> getProducts() {

		return d.getProducts();
	}

	public int getSize() {
		return d.getSize();
	}

	public Products getProductById(int id) {

		Products temp = new Products();
		for (Products a : d.getProducts()) {

			if (id == a.getId()) {
				temp.setId(a.getId());
				temp.setName(a.getName());
				temp.setPrice(a.getPrice());
				temp.setRating(a.getRating());
				temp.setImg(a.getImg());
			}
		}
		return temp;
	}

	public void AddToCart(int id) {
		Products p = getProductById(id);
		d.AddToCart(p);
	}

	public List<Products> getCartProducts() {
		return d.getCartProducts();
	}

	public void RemoveFromCart1(int id) {
		Products p = getProductById(id);
		System.out.println("SP:" + p);
		d.RemoveFromCart(p);
	}

	public List<Products> search(String name) {

		List<Products> l = d.search(name);

		return l;
	}

	public List<Products> sortByNameAsc() {

		List<Products> li = d.sortByNameAsc();

		return li;
	}
	
	public List<Products> sortByNameDesc() {

		List<Products> li = d.sortByNameDesc();

		return li;
	}

	public List<Products> sortByPriceDesc() {

		List<Products> li = d.sortByPriceDesc();

		return li;
	}
	
	public List<Products> sortByPriceAsc() {

		List<Products> li = d.sortByPriceAsc();

		return li;
	}
	
	public List<Products> sortByRatingAsc() {

		List<Products> li = d.sortByRatingAsc();

		return li;
	}

	public List<Products> sortByRatingDesc() {

		List<Products> li = d.sortByRatingDesc();

		return li;
	}
}
