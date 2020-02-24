package com.versionOne.service.Impl;

import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.versionOne.Repository.EmployeeRepository;
import com.versionOne.Repository.TownRepository;
import com.versionOne.controller.ExportController;
import com.versionOne.service.ExportService;
import com.versionOne.util.CSVWriterUtility;

@Transactional
@Service(value = "exportService")
public class ExportServiceImpl implements ExportService {

	File file;
	FileWriter csvWriter;
	static Logger log = Logger.getLogger(ExportController.class.getName());

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private TownRepository townRepository;

	@Override
	public List<String> getFreeCards() {
		log.info("ExportServiceImpl:getFreeCards() started");
		List<String> employeeCards = employeeRepository.getFreeCards();
		Collections.sort(employeeCards);
		file = new File("c:\\Users\\Public\\Documents\\FreeCards.csv");
		try {
			if (file.createNewFile()) {
				csvWriter = new FileWriter(file);
				csvWriter.append("Employee Card Number");
				csvWriter.append("\n");
				for (String employeeCard : employeeCards) {
					csvWriter.append(employeeCard);
					csvWriter.append("\n");
				}
				csvWriter.flush();
				csvWriter.close();
			}
			log.info("ExporrtServiceImpl:getFreeCards() finished");
			return employeeCards;
		} catch (Exception e) {
			log.log(Level.SEVERE, "Error at ExportServiceImpl:getFreeCards()", e);
			return null;
		}
	}

	@Override
	public List<List<Object>> getProductiveEmployees() {
		log.info("ExportServiceImpl:getProductiveEmployees() started");
		List<List<Object>> productiveEmployees = employeeRepository.getProductiveEmployees();
		CSVWriterUtility.writeCSVFile("ProductiveEmployees.csv", new String[] { "Full Name", "Position", "Card" },
				productiveEmployees);
		log.info("ExportServiceImpl:getProductiveEmployees() finished");
		return productiveEmployees;

	}

	@Override
	public List<List<Object>> getTowns() {
		log.info("ExportServiceImpl:getTowns() started");
		List<List<Object>> towns = townRepository.getTowns();
		CSVWriterUtility.writeCSVFile("Towns.csv", new String[] { "Town", "Population", "Clients" }, towns);
		log.info("ExportServiceImpl:getTowns() finished");
		return towns;
	}

	@Override
	public List<List<Object>> getTopBranches() {
		log.info("ExportServiceImpl:getTopBranches() started");
		List<List<Object>> branches = townRepository.getTopBranches();
		CSVWriterUtility.writeCSVFile("TopBranches.csv", new String[] {"Branch","Town","Clients"}, branches);
				log.info("ExportServiceImpl:getTopBranches() finished");
			return branches;
	}

}
