package com.personal.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import com.personal.core.beans.Bean;
import com.google.gson.Gson;

@Component(service = Servlet.class, property = {
		Constants.SERVICE_DESCRIPTION + "=Airtel Path Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths="+ "/bin/calculatorServlet",
}) 
public class AirtelPathServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(final SlingHttpServletRequest request,
            final SlingHttpServletResponse response) throws ServletException, IOException {
		
		int firstValue;
		int secondValue;
		int totalValue;
		
		// ResourceResolver resourceResolver = request.getResourceResolver();
		
		firstValue= Integer.parseInt(request.getParameter("firstVal"));
		secondValue= Integer.parseInt(request.getParameter("secondVal"));
		
		totalValue= firstValue + secondValue;
		
		Bean jsonBean = new Bean();
		jsonBean.setFirstVal(firstValue);
		jsonBean.setSecondVal(secondValue);
		jsonBean.setTotalValue(totalValue);
		
		Gson gson = new Gson();
		String jsonData = gson.toJson(jsonBean);
		
		response.setContentType("application/json");
		response.getWriter().write(jsonData.toString());
		
		
    }

}
