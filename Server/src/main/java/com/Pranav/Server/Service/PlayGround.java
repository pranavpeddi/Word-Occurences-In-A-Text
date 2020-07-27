package com.Pranav.Server.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.csv.*;

import com.Pranav.Server.Model.Data;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;



public class PlayGround {
	
	


	public HashMap<String, Integer> hm;
	List<Data> dataList=new ArrayList<Data>();
	public void countNofWords(String text)
	{
		
		// //s is used for white spaces
		String [] words=text.split("\\s");
	   
	     hm=new HashMap<>();
	    		 
	   // HashMap<String, Integer> ocMap=new HashMap<String,Integer>();
List<Data> dataList=new ArrayList<Data>();

	     for(int i=0;i<words.length;i++)
	    {
	    	
	    	
	    	 String key=words[i];
	    	 int freq=hm.getOrDefault(key,0);
	    	 hm.put(key, ++freq);
	    	
	    }
	     
	 
	     System.out.println(dataList);
	 
	 
	 
	// System.out.println(hm);
	 
	   
	}
	
	public static List<Object> readObjectsFromCsv(File f1) throws IOException
	{
		
		CsvSchema bootstrap=CsvSchema.emptySchema().withHeader();
		CsvMapper csvMapper=new CsvMapper();
	
	 List<Object> readAll=csvMapper.readerFor(Map.class).with(bootstrap).readValues(f1).readAll();
	 //ObjectMapper mapper=new ObjectMapper();
	// String out="";
	return readAll;
	 
	 
	
	}
	
	public static void main(String [] args) throws IOException
	{
		PlayGround pg=new PlayGround();	
		pg.countNofWords("this is prnav peddi this this this");
		String text="\"Id\",\"UserName\"\r\n" + 
				"\"1\",\"Sam Smith\"\r\n" + 
				"\"2\",\"Fred Frankly\"\r\n" + 
				"\"1\",\"Zachary Zupers\"";
		 File f1=new File("uploads/Book1.csv");
          List<Object> result=pg.readObjectsFromCsv(f1);
          System.out.println(result);
          
	}

	
}
