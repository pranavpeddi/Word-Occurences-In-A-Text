package com.Pranav.Server.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.Pranav.Server.Model.Data;

import com.google.gson.Gson;

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
	
	public static void main(String [] args)
	{
		PlayGround pg=new PlayGround();
		pg.countNofWords("this is prnav peddi this this this");
				
	}

	
}
