package com.personal.core.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(adaptables = Resource.class,
	   defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
	  )
public class FactMultifieldModel {
	
	@ChildResource(name = "factdetails")
	Resource factdetails;
	
	private List<Map<String, String>> factMap = new ArrayList<Map<String,String>>();
	
	@PostConstruct
	private void init() {
		Iterator<Resource> iterator = factdetails.listChildren();
		String numbervalue;
		String text;
		
		while(iterator.hasNext()) {
			Map<String, String> fact = new HashMap<String, String>();
			
			Resource factchild = iterator.next();
			numbervalue = factchild.getValueMap().get("numbervalue", String.class);
			text = factchild.getValueMap().get("text", String.class);
			
			fact.put("numbervalue", numbervalue);
			fact.put("text", text);
			
			factMap.add(fact);
			
		}
	}
	
	public List<Map<String, String>> getFactMap() {
		return factMap;
	}
	

}
