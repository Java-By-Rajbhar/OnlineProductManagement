package com.product.app.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.app.dto.ProductCategoryResponse;
import com.product.app.entity.ProductCategory;
import com.product.app.repository.ProductCategoryRepository;
/**
 * 
 * @author Sushil
 *
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductCategoryServiceImpl.class);
	@Autowired
	ProductCategoryRepository productCategoryRepository;
	@Override
	public List<ProductCategoryResponse> getAllProductCategory() {
		LOGGER.info("Inside getAllProductCategory method of ProductCategoryServiceImpl class");
		List<ProductCategoryResponse> listCategoryResponse = new ArrayList<ProductCategoryResponse>();
		List<ProductCategory> listCategory = productCategoryRepository.findAll();
		for (ProductCategory productCategory : listCategory) {
			ProductCategoryResponse response = new ProductCategoryResponse();
			response.setCategoryId(productCategory.getCategoryId());
			response.setCategoryName(productCategory.getCategoryName());
			
			listCategoryResponse.add(response);
			
		}
		return listCategoryResponse;
	}

}
