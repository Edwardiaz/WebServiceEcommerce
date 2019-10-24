package com.ecommerce.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.exception.StorageException;

@Service
public class ImpStorageService implements IntStorageService {
	
	private final Path rootLocation;
	
	@Autowired
	public ImpStorageService(StorageProperties properties)

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
		try {
			if(file.isEmpty()) {
				throw new StorageException("ERROR: failed to stores empty file: "+ fileName);
			}
			//security check...
			if(fileName.contains("..")) {
				throw new StorageException(
				"Couldn't store file with path outside current directory..."+fileName);
			}
			try(InputStream inputStream = file.getInputStream()) {
				Files.copy(inputStream, this.rootLocation.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
			}
			
		} catch (IOException e) {
			throw new StorageException("ERROR: an error ocurred when trying to store file "+fileName);
		}
	}

	@Override
	public Stream<Path> loadAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Path load(String filename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource loadAsResource(String filename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
}
