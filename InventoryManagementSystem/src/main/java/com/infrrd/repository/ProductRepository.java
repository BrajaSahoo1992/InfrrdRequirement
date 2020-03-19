package com.infrrd.repository;

import java.util.Date;
import java.util.List;

import com.infrrd.entity.Product;
import com.infrrd.exception.NoSuchRecordException;

public interface ProductRepository {
	public void addProduct(Product prod);
	
	public String deleteProduct(int id) throws NoSuchRecordException;
	
	public List<Product> getAllProductDetails();
	
	public List<Product> getAllProductsdetails(String date);

}
