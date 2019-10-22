package com.ecommerce.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Stream;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.configuration.HibernateUtil;
import com.ecommerce.configuration.StorageProperties;
import com.ecommerce.entity.ProductsImage;
import com.ecommerce.exception.StorageException;
import com.ecommerce.exception.StorageFileNotFoundException;

@Service
public class ImpStorageService implements IntStorageService {
	
	private final Path rootLocation;
	
	@Autowired
	public ImpStorageService(StorageProperties properties) {
		this.rootLocation = Paths.get(properties.getLocation());
	}

	@Override
	public void init() {
		try {
			Files.createDirectories(rootLocation);
		} catch (IOException e) {
			throw new StorageException("sorry, cannot initialize storage", e);
		}
		
	}

	@Override
	public void store(MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		InputStream inputStream = null;
		try {
			if(file.isEmpty()) {
				throw new StorageException("ERROR: failed to stores empty file: "+ fileName);
			}
			//security check...
			if(fileName.contains("..")) {
				throw new StorageException(
				"Couldn't store file with path outside current directory..."+fileName);
			}
			if(inputStream == file.getInputStream()) {
				Files.copy(inputStream, this.rootLocation.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
			}
			
		} catch (IOException e) {
			throw new StorageException("ERROR: an error ocurred when trying to store file "+fileName);
		}
	}

	@Override
	public Stream<Path> loadAll() {
		try {
			return Files.walk(this.rootLocation, 1).filter(path -> !path.equals(this.rootLocation)).map(this.rootLocation::relativize);
		} catch (IOException e) {
			throw new StorageException("ERROR: Failed to read stored files...", e);
		}
	}
	
	public Stream<Path> findAllProImage() {
		try(Session sesion = HibernateUtil.getSessionFactory().openSession()){
//			return sesion.createQuery("from ProductsImage", ProductsImage.class).list();
			return Files.walk(this.rootLocation, 1).filter(path -> !path.equals(this.rootLocation)).map(this.rootLocation::relativize);
		} catch (IOException e) {
			throw new StorageException("ERROR: Failed to read stored files...", e);
		}
		
	}

	@Override
	public Path load(String filename) {
		return rootLocation.resolve(filename);
	}

	@Override
	public Resource loadAsResource(String filename) {
		try {
			Path file = load(filename);
			Resource resource = new UrlResource(file.toUri());
			if(resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new StorageFileNotFoundException("Error: cannot read the file: "+filename);
			}
		} catch (MalformedURLException e) {
			throw new StorageFileNotFoundException("Could not read file: " + filename, e);
		}
	}

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}
	
}
