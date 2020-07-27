package com.Pranav.Server.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.csv.*;

import com.Pranav.Server.Model.Data;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;




@Service
public class OperationsService {

	
	
	
	public HashMap<String, Integer> hm;
	public List<Data> dataList;
	public List<Data> countNofWords(String text)
	{
		
		// //s is used for white spaces
		String [] words=text.split("\\s");
	   
	     hm=new HashMap<>();
	    		 
	   // HashMap<String, Integer> ocMap=new HashMap<String,Integer>();
	    for(int i=0;i<words.length;i++)
	    {
	    	 String key=words[i];
	    	 int freq=hm.getOrDefault(key,0);
	    	 hm.put(key, ++freq);
	    }
	    
	    System.out.println(hm);
	    dataList=new ArrayList<Data>();
	  
	    for(Entry<String,Integer> result:hm.entrySet())
	     {
	    	 Data data=new Data();
	    	 data.setKey(result.getKey());
	    	 data.setValue(result.getValue());
	    	 dataList.add(data);
	     }
	     
	    return dataList;
	  
	}
	
	
	public List<Object> csvToJson() throws IOException
	{
 File f1=new File("uploads/util.csv");
	CsvSchema bootstrap=CsvSchema.emptySchema().withHeader();
	CsvMapper csvMapper=new CsvMapper();
    List<Object> readAll=csvMapper.readerFor(Map.class).with(bootstrap).readValues(f1).readAll();
   return readAll;	
	}
	
	}


