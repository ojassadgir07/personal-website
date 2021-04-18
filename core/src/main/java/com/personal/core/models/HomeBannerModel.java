package com.personal.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class,
	   defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class HomeBannerModel {

	@Inject
	private String shortdescription;
	
	@Inject
	private String briefdescription;
	
	@Inject
	private String linkdescription;
	
	@Inject
	private String fileReference;
	
	
	
	
	public String getShortdescription() {
		return shortdescription;
	}

	public String getBriefdescription() {
		return briefdescription;
	}

	public String getLinkdescription() {
		return linkdescription;
	}

	public String getFileReference() {
		return fileReference;
	}
	
}
