package com.infrrd.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infrrd.entity.Product;
import com.infrrd.exception.NoSuchRecordException;
import com.infrrd.serviece.ProductServiece;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="ProductController work with product")
public class ProductController {
	
	@Autowired
	ProductServiece prodServiece;
	@PostMapping("/addProduct")
	@ApiOperation(value = "adding product", tags="addProduct")
	@ApiResponse(code = 200, message = "product added sucessfully")
	public void addProduct( @RequestBody Product product){
		prodServiece.addProduct(product);	
	}
@GetMapping("/showProducts")
@ApiOperation(value = "Fetch all the prdouct details", response = Product.class, tags="getAllProductDetails")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Fetched the products successfully"),
							 @ApiResponse(code = 404, message = "product details not found") })
public List<Product> getAllProductDetails(){
		return prodServiece.getAllProductDetails();	
	}

@DeleteMapping("/deleteProduct/{id}")
@ApiOperation(value = "Delete product by id", tags="removeProduct")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Product deleted sucessfully"),
							 @ApiResponse(code = 404, message = "product not deleted as product is not there ") })
public String removeProduct( @PathVariable int id) throws NoSuchRecordException{
	return prodServiece.removeProduct(id);
	
}
@ApiOperation(value = "get added and removed products ", tags="getAdedproductRemovedProducts")
@ApiResponses(value = { @ApiResponse(code = 200, message = "Added or removed products fetched   sucessfully"),
							 @ApiResponse(code = 404, message = "Added products or removed products is not in this time ") })
@GetMapping("/getProducts/{time}")
public List<Product> getAdedproductRemovedProducts(@PathVariable("time")
  @DateTimeFormat(pattern = "dd.MM.yyyy") String date) {
	return prodServiece.getAllRemovedAddedproduts(date);
    // ...
}
	
	

}
