package com.railway.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.railway.model.Train;
import com.railway.repository.TrainRepository;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {
	
	@Autowired
	private TrainRepository trainRepository;
	
	public void  exportReport(String reportFormat) throws FileNotFoundException, JRException {
		
		String path="D:\\WorkSpace\\Spring Workspace\\Railway\\Reports";
		
		List<Train> trains = trainRepository.findAll();
		
		File file = ResourceUtils.getFile("classpath:Trains.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(trains);
		
		Map<String, Object> parameters = new HashMap<>();
		
		parameters.put("createdBy", "IngroInfo");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		if(reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint,path +"\\trains.html");
			
		}
		if(reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint,path +"\\trains.pdf");
			
		}
		
		
	}

}
