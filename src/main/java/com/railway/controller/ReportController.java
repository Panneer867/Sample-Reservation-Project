package com.railway.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.railway.service.ReportService;

import net.sf.jasperreports.engine.JRException;

@RestController
public class ReportController {
	
	 
    @Autowired
    private ReportService reportService;
	
	 @GetMapping("/report/{format}")
	    public String generatedReport(@PathVariable String format) throws FileNotFoundException, JRException {
		 
		 String path="D:\\WorkSpace\\Spring Workspace\\Railway\\Reports";
		  reportService.exportReport(format);
			if(format.equalsIgnoreCase("html")) {
				return "<center><b>Report has been generated in this location as HTML file</p>" +path;
			}
			if(format.equalsIgnoreCase("pdf")) {
				return "<center><b>Report has been generated in this location as PDF file</p>" +path;
			}
			return"Report not Generated"; 
	    	
	    }

}
