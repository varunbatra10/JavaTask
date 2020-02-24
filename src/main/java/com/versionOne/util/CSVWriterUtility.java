package com.versionOne.util;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CSVWriterUtility {

	static Logger log = Logger.getLogger(CSVWriterUtility.class.getName());
	static File file;
	static final String filePath = "c:\\Users\\Public\\Documents\\";
	static FileWriter csvWriter;

	public static void writeCSVFile(String fileName, String[] headings, List<List<Object>> objects) {
		log.info("CSVWriterUtility:writeCSVFile() started");
		file = new File("./files/"+fileName);
		try {
			csvWriter = new FileWriter(file);
			file.createNewFile();
				log.info("CSVWriterUtility:writeCSVFile() " + fileName +" created");
				for (String heading : headings) {
					csvWriter.append(heading);
					csvWriter.append(",");
				}
				csvWriter.append("\n");
				for (List<Object> object : objects) {
					for (Object values : object) {
						csvWriter.append(String.valueOf(values));
						csvWriter.append(",");
					}
					csvWriter.append("\n");
				}
			
			csvWriter.flush();
			csvWriter.close();
			log.info("CSVWriterUtility:writeCSVFile() finished");
		} catch (Exception e) {
			log.log(Level.SEVERE, "Error at CSVWriterUtility:writeCSVFile()", e);
		}
	}
}
