package com.personal.core.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;

@Component(service = Servlet.class, property = {
		Constants.SERVICE_DESCRIPTION + "=Airtel Path Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths="+ "/bin/searchServlet",
})
public class SearchServlet extends SlingAllMethodsServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	String count;

	@Inject
	ResourceResolver resourceResolver;
	
	List<String> refrenceList = new ArrayList<String>();
	
	@PostConstruct
	@Override
	protected void doPost(final SlingHttpServletRequest request,
            final SlingHttpServletResponse response) throws ServletException, IOException {
			
		Map<String,String> map = new HashMap<String,String>();
		String fulltext;
		
		fulltext= request.getParameter("fulltext").toString();
		
		
		map.put("path","/content/airtelnewpage");
		map.put("type","cq:Page");
		map.put("property","jcr:title");
		map.put("property.value",fulltext);
		
		PredicateGroup predicateGroup= PredicateGroup.create(map);
		
		QueryBuilder queryBuilder = resourceResolver.adaptTo(QueryBuilder.class);
		Session session = resourceResolver.adaptTo(Session.class);
		Query query =  queryBuilder.createQuery(predicateGroup, session);
		
		SearchResult searchResult = query.getResult();
		for(Hit hit: searchResult.getHits()) {
			
			try {
				refrenceList.add(hit.getResource().getValueMap().get("fileReference",String.class));
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	
	}
	
	public String getCount() {
		return count;
	}

	public List<String> getRefrenceList() {
		return refrenceList;
	}	
	
	
	
}
