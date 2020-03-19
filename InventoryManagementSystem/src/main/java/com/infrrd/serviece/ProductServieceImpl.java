package com.infrrd.serviece;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.infrrd.entity.Product;
import com.infrrd.exception.NoSuchRecordException;
import com.infrrd.repository.ProductRepository;

@Service("prodServiece")
public class ProductServieceImpl implements ProductServiece {
    @Autowired
	ProductRepository prodRepo;
	
	@Override
	public void addProduct(Product product) {
		prodRepo.addProduct(product);
		
	}

	@Override
	public String removeProduct(int id) throws NoSuchRecordException {
		// TODO Auto-generated method stub
		return prodRepo.deleteProduct(id);
	}

	@Override
	public List<Product> getAllProductDetails() {
		// TODO Auto-generated method stub
		return prodRepo.getAllProductDetails();
	}

	@Override
	public List<Product> getAllRemovedAddedproduts(String date) {
		// TODO Auto-generated mehod stub
	    
		return prodRepo.getAllProductsdetails(date);
	}

}
