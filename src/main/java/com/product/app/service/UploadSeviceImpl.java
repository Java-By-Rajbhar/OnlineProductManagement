package com.product.app.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.product.app.dto.UploadFileResponseDto;
import com.product.app.util.ExcelImportToDB;

@Service
public class UploadSeviceImpl implements UploadService {

	@Autowired
	private ExcelImportToDB excelImport;

	@Override
	public UploadFileResponseDto uploadFile(MultipartFile file) {

		
		return excelImport.loadDataToDB(file);
	}

}
