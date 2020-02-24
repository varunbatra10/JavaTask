package com.versionOne.service;

import java.util.List;

public interface ExportService {

	List<String> getFreeCards();

	List<List<Object>> getProductiveEmployees();
	
	List<List<Object>> getTowns();
	
	List<List<Object>> getTopBranches();
	

}
