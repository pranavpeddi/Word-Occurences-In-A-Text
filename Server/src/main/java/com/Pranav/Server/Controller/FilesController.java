package com.Pranav.Server.Controller;

import java.awt.PageAttributes.MediaType;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.Pranav.Server.Model.FileInfo;
import com.Pranav.Server.Model.ResponseMessage;
import com.Pranav.Server.Service.FileStorageService;
import com.Pranav.Server.Service.OperationsService;

@RequestMapping("/filecon")
@Controller
public class FilesController {
	@Autowired
	  FileStorageService storageService;
       
	
	@Autowired
	OperationsService operationService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	  @PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(/*@RequestParam("file") */ MultipartFile file) throws IOException{
	    String message = "";
	    try {
	      storageService.save(file);

	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }

	
	@CrossOrigin(origins = "http://localhost:3000")
	  @GetMapping("/files")
	  public ResponseEntity<List<FileInfo>> getListFiles() {
	    List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
	      String filename = path.getFileName().toString();
	      String url = MvcUriComponentsBuilder
	          .fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();

	      return new FileInfo(filename, url);
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
	  }

	
	@CrossOrigin(origins = "http://localhost:3000")
	  @GetMapping("/files/{filename:.+}")
	  @ResponseBody
	  public ResponseEntity<Resource> getFile(@PathVariable String filename) {
	    Resource file = storageService.load(filename);
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	  }
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(value = "/newupload")
	public ResponseEntity uploadnewfILE(@RequestParam MultipartFile file)
	{
		  String message = "";
		    try {
		    	storageService.deleteAll();
		    	storageService.init();
		   
		      storageService.save(file);

		      message = "Uploaded the file successfully: " + file.getOriginalFilename();
		     // File csv=new File("uploads/");
		  List<Object> newObj= operationService.csvToJson();
		  System.out.println(newObj);
		      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		     
		    } catch (Exception e) {
		      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
		      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		    }

	
}
}
