package com.versionOne.service.Impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versionOne.Repository.BranchRepository;
import com.versionOne.Repository.EmployeeCardRepository;
import com.versionOne.Repository.EmployeeRepository;
import com.versionOne.Repository.ProductRepository;
import com.versionOne.Repository.TownRepository;
import com.versionOne.controller.ExportController;
import com.versionOne.model.Branch;
import com.versionOne.model.Employee;
import com.versionOne.model.EmployeeCard;
import com.versionOne.model.Product;
import com.versionOne.model.Town;
import com.versionOne.service.ImportService;

@Transactional
@Service(value = "importService")
public class ImportServiceImpl implements ImportService {


	static Logger log = Logger.getLogger(ExportController.class.getName());
	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeCardRepository employeeCardRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private TownRepository townRepository;

	
	@Override
	public String saveTownData(List<Town> town) {
		StringBuilder response = new StringBuilder("");
		log.info("ImportServiceImpl:saveTownData() started");
		String success = "Successfully imported Town ";
		String error = "Error: Invalid data for Town.\n";
		try {
			for(Town townOne:town) {
			Town townReturn = townRepository.save(townOne);
			if (townReturn != null) {
				response.append(success+townReturn.getName()+".\n");
			} else {
				response.append(error);
			}
			}

			log.info("ImportServiceImpl:saveTownData() finished");
			return response.toString();
		} catch (Exception e) {
			log.log(Level.SEVERE,"Error at ImportServiceImpl:saveTownData()",e);
			return error;
		}
	}

	@Override
	public String saveBranchData(List<Branch> branch) {
		StringBuilder response = new StringBuilder("");
		log.info("ImportServiceImpl:saveBranchData() started");
		String success = "Successfully imported Branch ";
		String error = "Error: Invalid data for Branch.\n";
		try {
			for(Branch branchOne:branch) {
			Branch branchReturn = branchRepository.save(branchOne);
			if (branchReturn != null) {
				response.append(success+branchReturn.getName()+".\n");
			} else {
				response.append(error);
			}
			}
			log.info("ImportServiceImpl:saveBranchData() finished");
			return response.toString();
		} catch (Exception e) {
			log.log(Level.SEVERE,"Error at ImportServiceImpl:saveBranchData()",e);
			return error;
		}
	}

	public String saveEmployeeData(List<Employee> employee) {
		StringBuilder response = new StringBuilder("");
		log.info("ImportServiceImpl:saveEmployeeData() started");
		String success = "Successfully imported Employee ";
		String error = "Error: Invalid data for Employee.\n";
		try {
			for(Employee employeeOne:employee) {
			Employee employeeReturn = employeeRepository.save(employeeOne);
			if (employeeReturn != null) {
				response.append(success+employeeReturn.getFirstName()+employeeReturn.getLastName()+".\n");
			} else {
				response.append(error);
			}
			}
			log.info("ImportServiceImpl:saveEmployeeData() finished");
			return response.toString();
		} catch (Exception e) {
			log.log(Level.SEVERE,"Error at ImportServiceImpl:saveEmployeeData()",e);
			return error;
		}
	}

	@Override
	public String saveProductData(List<Product> product) {
		StringBuilder response = new StringBuilder("");
		log.info("ImportServiceImpl:saveProductData() started");
		String success = "Successfully imported Product ";
		String error = "Error: Invalid data for Product.\n";
		try {
			for(Product productOne:product) {
			Product productReturn = productRepository.save(productOne);
			if (productReturn != null) {
				response.append(success+productReturn.getName()+".\n");
			} else {
				response.append(error);
			}
			}
			log.info("ImportServiceImpl:saveProductData() finished");
			return response.toString();
		} catch (Exception e) {
			log.log(Level.SEVERE,"Error at ImportServiceImpl:saveProductData()",e);
			return error;
		}
		}

	@Override
	public String saveEmployeeCardData(List<EmployeeCard> employeeCard) {
		StringBuilder response = new StringBuilder("");
		log.info("ImportServiceImpl:saveEmployeeCardData() started");
		String success = "Successfully imported EmployeeCard ";
		String error = "Error: Invalid data for EmployeeCard.\n";
		try {
			for(EmployeeCard employeeCardOne:employeeCard) {
			EmployeeCard employeeCardReturn = employeeCardRepository.save(employeeCardOne);
			if (employeeCardReturn != null) {
				response.append(success+employeeCardReturn.getNumber()+".\n");
			} else {
				response.append(error);
			}
			}
			log.info("ImportServiceImpl:saveEmployeeCardData() finished");
			return response.toString();
		} catch (Exception e) {
			log.log(Level.SEVERE,"Error at ImportServiceImpl:saveEmployeeCardData()",e);
			return error;
		}
		}

}
