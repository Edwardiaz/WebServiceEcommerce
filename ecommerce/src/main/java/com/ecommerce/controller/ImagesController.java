package com.ecommerce.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.entity.ProductsImage;
import com.ecommerce.service.IGenericService;
import com.ecommerce.service.IRetrieveImageService;

//import com.example.filedemo.payload.UploadFileResponse;
//import com.example.filedemo.service.FileStorageService;

@RestController
@RequestMapping("/api")
public class ImagesController {

	private IRetrieveImageService retrieveService;
	private IGenericService genS;
	
	@Autowired
	public ImagesController(IRetrieveImageService retrieveService, IGenericService genS) {
		this.retrieveService = retrieveService;
		this.genS = genS;
	}
	
// ********************************************************************************************************************* \\
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	@ResponseBody
    public String findListImage() {
        return "uploadfile";
    }
 
    @RequestMapping(value = "/imagen", method = RequestMethod.POST)
    @ResponseBody
    public String saveImage(@RequestBody ProductsImage proImage) throws IllegalStateException, IOException {
        String saveDirectory = "C:/Users/Jorge.Diaz/Documents/GitHub/WebServiceEcommerce/ecommerce/src/main/resources/";
 
        List<MultipartFile> imageList = retrieveService.getFiles();
 
        List<String> fileNames = new ArrayList<String>();
 
        if (null != imageList && imageList.size() > 0) {
            for (MultipartFile multipartFile : imageList) {
 
                String fileName = multipartFile.getOriginalFilename();
                if (!"".equalsIgnoreCase(fileName)) {
                    // Handle file content - multipartFile.getInputStream()
                    multipartFile.transferTo(new File(saveDirectory + fileName));
                    fileNames.add(fileName);
                }
            }
        }
        return "uploadfile success";
    }
	
	// https://crunchify.com/spring-mvc-tutorial-how-to-upload-multiple-files-to-specific-location/
    
    // https://www.callicoder.com/spring-boot-file-upload-download-rest-api-example/
    
    //
// ********************************************************************************************************************* \\
	
//	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
//
//    @Autowired
//    private FileStorageService fileStorageService;
//    
//    @PostMapping("/uploadFile")
//    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
//        String fileName = fileStorageService.storeFile(file);
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName)
//                .toUriString();
//
//        return new UploadFileResponse(fileName, fileDownloadUri,
//                file.getContentType(), file.getSize());
//    }
//
//    @PostMapping("/uploadMultipleFiles")
//    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//        return Arrays.asList(files)
//                .stream()
//                .map(file -> uploadFile(file))
//                .collect(Collectors.toList());
//    }
	
// ********************************************************************************************************************** \\	
	
	//conversor de url a byte array
//	@RequestMapping(value = "/imagen", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
//	@ResponseBody
//	public static byte[] convertImageByte(URL url) throws IOException {
//	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
//	    InputStream is = null;
//	    try {
//	        is = new BufferedInputStream(url.openStream());
//	        byte[] byteChunk = new byte[4096];
//	        int n;
//	        while ( (n = is.read(byteChunk)) > 0 ) {
//	            baos.write(byteChunk, 0, n);
//	        }   
//	        return baos.toByteArray();
//	    }
//	    catch (IOException e) {e.printStackTrace ();
//	    }
//	    finally {
//	        if (is != null) { is.close(); }
//	    }
//	    return null;
//	}
	
	
//	//Metodo predeterminado
//	@RequestMapping(value = "/imagen", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
//	@ResponseBody
//	public ResponseEntity<?> saveProImage(@RequestBody ProductsImage proima) {
//		if(proima.getIdImageProduct() == null || proima.getIdImageProduct() == 0) {
//		return new ResponseEntity<>(genS.saveObject(proima), HttpStatus.CREATED);
//		}else {
//			return new ResponseEntity<>("Error creating...", HttpStatus.BAD_REQUEST);
//		}
//	}
	
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping(value = "/imagen", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public List<ProductsImage> findAllProImage() {
		List<ProductsImage> listProIma = retrieveService.findAllProImage();
		return listProIma;
	}
	
	@RequestMapping(value = "/imagen/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public ResponseEntity<?> userById(@PathVariable("id") Long id) {
		
		ProductsImage ima = retrieveService.findByIdImage(id);
	
		if (ima != null) {
			return new ResponseEntity<>(ima, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
}
