package com.product.app.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.product.app.dto.UploadFileResponseDto;
import com.product.app.entity.Product;
import com.product.app.entity.ProductCategory;
import com.product.app.repository.ProductCategoryRepository;
import com.product.app.repository.ProductRepository;

@Component
public class ExcelImportToDB {

	private static final Logger logger = LogManager.getLogger(ExcelImportToDB.class);
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	public UploadFileResponseDto loadDataToDB(MultipartFile file) {

		System.out.println("in service");
		
		UploadFileResponseDto response = new UploadFileResponseDto();
		FileInputStream input = null;
		XSSFSheet sheet = null;
		XSSFWorkbook workbook=null;
		try {

			
			System.out.println("in service");

			workbook =new XSSFWorkbook(file.getInputStream());

			sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();

			Row row;
			int result = 0;
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				if (result == 0) {
					result = 1;
				} else {
				
					Product product =new Product();
					ProductCategory productCategoryRepo=new ProductCategory();
					System.out.println("in service");
					String productCategory = row.getCell(1).getStringCellValue();
					String productName=row.getCell(2).getStringCellValue();
					String productCharges = row.getCell(3).getStringCellValue();
					String prodDesc =  row.getCell(4).getStringCellValue();
					
					
					System.out.println(productCharges);
					
					productCategoryRepo.setCategoryName(productCategory);
					productCategoryRepository.save(productCategoryRepo);
					
					ProductCategory responseProd=productCategoryRepository.findByCategoryName(productCategory);
					
					product.setCategoryId(responseProd.getCategoryId());
					//product.setCharges(productCharges);
					product.setProductDescription(prodDesc);
					product.setProductName(productName);
					
					
					
					response.setMessage("success");
					response.setStatusCode(200);
					
					
					
				}

			}
			
		} catch (Exception e) {
			logger.error(this.getClass().getName() + " loadDataToDB : " + e.getMessage());
		} finally {
			try {
				if(workbook!=null) {
					workbook.close();
				}
				if(input!=null) {
					input.close();
				}				
				sheet = null;
			} catch (Exception e) {
				logger.error(this.getClass().getName() + " loadDataToDB finally block : " + e.getMessage());
			}

		}
		return response;
	}

}
