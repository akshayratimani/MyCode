package com.slk.dao;

import java.util.Comparator;

import com.slk.entity.Products;

public class RatingComparator implements Comparator<Products> {

	@Override
	public int compare(Products o1, Products o2) {

		if (o1.getRating() == o2.getRating())
			return 0;
		else if (o1.getRating() > o2.getRating())
			return -1;
		else
			return 1;
	}
}
