package com.ecommerce.service;

//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.StringUtils;
//import com.ecommerce.configuration.ImageProperties;

import com.ecommerce.dao.InterfaceRetrieveImageDao;
import com.ecommerce.entity.ProductsImage;

@Service
public class ServiceRetrieveImageImpl implements IRetrieveImageService{

	private InterfaceRetrieveImageDao interProIma;
	
	@Autowired
	public ServiceRetrieveImageImpl(InterfaceRetrieveImageDao interProIma) {
		this.interProIma = interProIma;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<ProductsImage> findAllProImage() {
		return interProIma.findAllProImage();
	}

	@Override
	@Transactional(readOnly = true)
	public ProductsImage findByIdImage(Long id) {
		return interProIma.findByIdImage(id);
	}
	 
    public List<MultipartFile> getFiles() {
	    return interProIma.getFiles();
    }
	 
    public void setFiles(List<MultipartFile> files) {
//	    this.crunchifyFiles = files;
        List<MultipartFile> crunchifyFiles = files;
	}
    
//    private Path fileStorageLocation;
//
//    @Autowired
//    public  ResponseEntity<?> FileStorageService(ImageProperties fileStorageProperties) {
//        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
//                .toAbsolutePath().normalize();
//        try {
//            Files.createDirectories(this.fileStorageLocation);
//            return new ResponseEntity<>("Successfully saved", HttpStatus.CREATED);
//        } catch (Exception ex) {
//            return new ResponseEntity<>("Could not create the directory where the uploaded files will be stored.", HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    public ResponseEntity<?> storeFile(MultipartFile file) {
//        // Normalize file name
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
//        try {
//            // Check if the file's name contains invalid characters
//            if(fileName.contains("..")) {
//                return new ResponseEntity<>("Sorry! Filename contains invalid path sequence ", HttpStatus.BAD_REQUEST);
//            }
//
//            // Copy file to the target location (Replacing existing file with the same name)
//            Path targetLocation = this.fileStorageLocation.resolve(fileName);
//            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
//
//            return new ResponseEntity<>("Ok!", HttpStatus.OK);
//        } catch (IOException ex) {
//            return new ResponseEntity<>("Sorry! Could not store file. Please try again! ", HttpStatus.BAD_REQUEST);
//        }
//    }

}
