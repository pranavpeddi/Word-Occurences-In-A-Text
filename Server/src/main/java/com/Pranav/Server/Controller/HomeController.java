package com.Pranav.Server.Controller;

import java.io.IOException;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

import com.Pranav.Server.Model.Data;
import com.Pranav.Server.Service.OperationsService;

@RestController
public class HomeController {
	
	
	
	@Autowired
	
	OperationsService opservice;
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/stringOp/{data}")
	public List<Data> postData(@PathVariable String data){
	   
		
		return opservice.countNofWords(data);
		
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getData")
	public List<Data> getData()
	{

		return opservice.dataList;
	} 

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/csvToJson")
	public List<Object> getJson() throws IOException
	{
		//System.out.println();   
		return opservice.csvToJson();
		
	
			//e.printStackTrace();
		
		//return new ArrayList<Object>();
	} 

	}

