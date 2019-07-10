package com.playground.coffeeparty;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DTRWriter {

	public void editWorkbook(ArrayList<OfflineDailyRecord> odtrRecords, String dtrFilename, String yrMonth) throws InvalidFormatException, IOException {
		FileInputStream inputStream = new FileInputStream(new File(dtrFilename));
		// Obtain a workbook from the excel file
		Workbook workbook = WorkbookFactory.create(inputStream);

		workbook.cloneSheet(0);
		workbook.setSheetName(0, yrMonth);
		
		// Get Sheet at index 0
		Sheet sheet = workbook.getSheetAt(0);

		// Get Row at index 1
		Row row;
		try {
			row = sheet.getRow(11);
		} catch (NullPointerException e) {

		} finally {
			row = sheet.createRow(11);
		}

		Cell cell;
		// Get the Cell at index 2 from the above row
		try {
			cell = row.getCell(0);
		} catch (NullPointerException e) {

		} finally {
			cell = row.createCell(0);
		}

		// Update the cell's value
		cell.setCellType(CellType.STRING);
		cell.setCellFormula("8+8");

		// Write the output to the file
		FileOutputStream fileOut = new FileOutputStream(dtrFilename);
		workbook.write(fileOut);
		fileOut.close();

		// Closing the workbook
		workbook.close();
	}

}
