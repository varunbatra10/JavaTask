package com.versionOne.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.versionOne.service.ExportService;

@RestController
@RequestMapping(value="/export")
public class ExportController {

	static Logger log = Logger.getLogger(ExportController.class.getName());
	@Autowired
	private ExportService exportService;
	
	@GetMapping(value = "/free-cards")
	public List<String> getFreeCards() {
		log.info("ExportController:getFreeCards() started");
		return exportService.getFreeCards();
	}
	
	@GetMapping(value = "/productive-employees")
	public List<List<Object>> getProductiveEmployees() {
		log.info("ExportController:getProductiveEmployees() started");
		return exportService.getProductiveEmployees();
	}
	
	@GetMapping(value = "/towns")
	public List<List<Object>> getTown() {
		log.info("ExportController:getTown() started");
		return exportService.getTowns();
	}
	
	@GetMapping(value = "/top-branches")
	public List<List<Object>> getTopBranches() {
		log.info("ExportController:getTopBranches() started");
		return exportService.getTopBranches();
	}

}
