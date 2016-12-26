package com.dhl.blahblah.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dhl.blahblah.model.Image;
import com.dhl.blahblah.model.Product;
import com.dhl.blahblah.service.IImageService;


@RestController
@RequestMapping("/api")
public class ImageRESTController {
	
	@Autowired
	IImageService imageService;
	
	@GetMapping("/images")
	public List<Image>  getTopProduct(@RequestParam("productId") int productId){
		return imageService.getImageByProductId(productId);
	}
	
	@PostMapping(value = "/images/upload", consumes = "multipart/form-data")
	public ResponseEntity<Image> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("type") String type, @RequestParam("productId") int productId, HttpServletRequest request){
		System.out.println(productId);
		if (!file.isEmpty()) {
            try {
            	// hard code for test
                String realPathtoUploads = "E:/eclipse/stupidphone_img/";
                if(! new File(realPathtoUploads).exists())
                {
                    new File(realPathtoUploads).mkdir();
                }
                String orgName = file.getOriginalFilename();
                String filePath = realPathtoUploads + orgName;
                File dest = new File(filePath);
                Image image = new Image(type, file.getBytes(), new Product(productId));
                imageService.insert(image);
                file.transferTo(dest);
                return new ResponseEntity<Image>(HttpStatus.OK);
            }catch(Exception ex){
            	ex.printStackTrace();
            	return new ResponseEntity<Image>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
		}
		return new ResponseEntity<Image>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(value="/images/download")
	public void test(@RequestParam("fileName") String fileName, HttpServletResponse response){
		response.setContentType("image/jpg");

        try {
            File file = new File("E:/eclipse/stupidphone_img/"+fileName);

            InputStream inputStream = new FileInputStream(file);
            IOUtils.copy(inputStream, response.getOutputStream());

        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}
}
