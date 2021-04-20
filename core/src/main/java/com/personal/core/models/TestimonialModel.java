package com.personal.core.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import com.personal.core.beans.TestimonialBean;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TestimonialModel {

	@ChildResource(name = "testimonials")
	Resource testimonials;
	
	List<TestimonialBean> testimoniallist= new ArrayList<TestimonialBean>();
		

	@PostConstruct
	private void inti() {
	    
		Iterator<Resource> items = testimonials.listChildren();	
		
		while(items.hasNext())
		{
			Resource childNode = items.next();
			TestimonialBean testimonial= new TestimonialBean();
			testimonial.setTestimonial(childNode.getValueMap().get("testimonial", String.class));
			testimonial.setAuthor(childNode.getValueMap().get("author", String.class));
			testimonial.setDesignation(childNode.getValueMap().get("designation", String.class));
			
			testimoniallist.add(testimonial);
		}
	}
	
	public List<TestimonialBean> getTestimoniallist() {
		return testimoniallist;
	}
}
