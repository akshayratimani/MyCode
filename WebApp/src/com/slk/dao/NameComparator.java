package com.slk.dao;

import java.util.Comparator;

import com.slk.entity.Products;

public class NameComparator implements Comparator<Products> {

	@Override
	public int compare(Products o1, Products o2) {

		return o1.getName().compareTo(o2.getName());
	}

}
