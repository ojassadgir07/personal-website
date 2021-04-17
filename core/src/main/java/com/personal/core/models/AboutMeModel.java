package com.personal.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AboutMeModel {
	
@ValueMapValue
String title;

@ValueMapValue
String heading;

@ValueMapValue
String description;

@ValueMapValue
String button;

@ValueMapValue
String imagepath;


public String getImagepath() {
	return imagepath;
}

public String getTitle() {
	return title;
}

public String getHeading() {
	return heading;
}

public String getDescription() {
	return description;
}

public String getButton() {
	return button;
}

}
