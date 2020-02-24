package com.versionOne.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.versionOne.model.Branch;
import com.versionOne.model.Employee;
import com.versionOne.model.EmployeeCard;
import com.versionOne.model.Product;
import com.versionOne.model.Town;
import com.versionOne.service.ImportService;

/**
 * 
 * @author vabatra
 *
 */
@RestController
@RequestMapping("/import")
public class ImportController {

	static Logger log = Logger.getLogger(ExportController.class.getName());

	@Autowired
	private ImportService importService;

	/**
	 * 
	 * @param town
	 * @return String
	 */
	@PostMapping(value = "/towns")
	public String importTownData(@RequestBody List<Town> town) {
		log.info("ImportController:importTownData() started");
		return importService.saveTownData(town);
	}

	/**
	 * 
	 * @param branch
	 * @return String
	 */
	@PostMapping(value = "/branches")
	public String importBranchData(@RequestBody List<Branch> branch) {
		log.info("ImportController:importBranchData() started");
		return importService.saveBranchData(branch);
	}

	/**
	 * 
	 * @param employeeCard
	 * @return String
	 */
	@PostMapping(value = "/employee-cards")
	public String importEmployeeCardData(@RequestBody List<EmployeeCard> employeeCard) {
		log.info("ImportController:importEmployeeCardData() started");
		return importService.saveEmployeeCardData(employeeCard);
	}

	/**
	 * 
	 * @param product
	 * @return String
	 */
	@PostMapping(value = "/products")
	public String importProductData(@RequestBody List<Product> product) {
		log.info("ImportController:importProductData() started");
		return importService.saveProductData(product);
	}

	/**
	 * 
	 * @param employee
	 * @return String
	 */
	@PostMapping(value = "/employees")
	public String importEmployeeData(@RequestBody List<Employee> employee) {
		log.info("ImportController:importEmployeeData() started");
		return importService.saveEmployeeData(employee);
	}
}
