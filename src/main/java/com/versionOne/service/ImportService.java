package com.versionOne.service;

import java.util.List;

import com.versionOne.model.Branch;
import com.versionOne.model.Employee;
import com.versionOne.model.EmployeeCard;
import com.versionOne.model.Product;
import com.versionOne.model.Town;

public interface ImportService {

	String saveTownData(List<Town> town);
	String saveBranchData(List<Branch> branch);
	String saveEmployeeData(List<Employee> employee);
	String saveProductData(List<Product> product);
	String saveEmployeeCardData(List<EmployeeCard> employeeCard);

}
