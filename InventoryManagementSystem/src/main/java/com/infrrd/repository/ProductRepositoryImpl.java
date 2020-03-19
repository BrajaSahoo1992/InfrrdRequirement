package com.infrrd.repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.infrrd.entity.Product;
import com.infrrd.exception.NoSuchRecordException;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
	
	int count =1;
	HashMap<Integer, Product> map= new HashMap<>();
	
	HashMap<String, List<Product>> addDelProduct=new HashMap<>();
	 ArrayList<Product> prodList=new ArrayList<>();
     Date curDate=new Date();
     SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
     String strDate= formatter.format(curDate);
	@Override
	public void addProduct(Product prod) {
		count++;
		prod.setProductID(count);
		map.put(prod.getProductID(), prod);
		
		if(addDelProduct.containsKey(strDate)){
		//	List<Product> products=addDelProduct.get(strDate);
			prodList.add(prod);
		//	prodList.addAll(products);
			addDelProduct.put(strDate, prodList);
			}
		else{
			prodList.add(prod);
			addDelProduct.put(strDate, prodList);
		}
		System.out.println("Prod details"+map.get(prod.getProductID()));
		System.out.println("addDelProductvalues after add"+addDelProduct);
	}

	@Override
	public String deleteProduct(int id) throws NoSuchRecordException {
		if (map.get(id)!=null){
			if(addDelProduct.containsKey(strDate)){
			//	List<Product> products=addDelProduct.get(strDate);
				
				prodList.add(map.get(id));
				//prodList.addAll(products);
				addDelProduct.put(strDate, prodList);
				}
			else{
				prodList.add(map.get(id));
				addDelProduct.put(strDate, prodList);
			}
			map.remove(id);
			System.out.println("addDelProductvalues after delete"+addDelProduct);
			return "record "+id+"deleted sucessfully";
		}
		else{
			throw new NoSuchRecordException();
		}
		
	}

	@Override
	public List<Product> getAllProductDetails() {
		// TODO Auto-generated method stub
		ArrayList<Product> productdetails=new ArrayList<>();
		for(Map.Entry<Integer, Product> prod:map.entrySet()){
			productdetails.add(prod.getValue());
			
		}
		return productdetails;
	}

	@Override
	public List<Product> getAllProductsdetails(String date) {
		
		// TODO Auto-generated method stub
		return addDelProduct.get(date);
	}

}
