package com.slk.dao;

import java.util.Comparator;

import com.slk.entity.Products;

public class NameComparatorDesc implements Comparator<Products> {

	@Override
	public int compare(Products o1, Products o2) {

		return o2.getName().compareTo(o1.getName());
	}

}
