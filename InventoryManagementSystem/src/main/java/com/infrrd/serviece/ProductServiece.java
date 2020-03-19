package com.infrrd.serviece;

import java.util.Date;
import java.util.List;

import com.infrrd.entity.Product;
import com.infrrd.exception.NoSuchRecordException;

public interface ProductServiece {
	public void addProduct(Product product);
	
	public String removeProduct(int id) throws NoSuchRecordException;
	
	public List<Product> getAllProductDetails();
	
	public List<Product> getAllRemovedAddedproduts(String date);

}
