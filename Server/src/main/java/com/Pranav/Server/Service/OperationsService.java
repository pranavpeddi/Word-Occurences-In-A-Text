package com.Pranav.Server.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Pranav.Server.Model.Data;

import com.google.gson.Gson;

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
}
