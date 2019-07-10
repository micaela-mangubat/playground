package com.playground.coffeeparty;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ODTRReader {

	public ArrayList<OfflineDailyRecord> readOfflineDtr(String odtrfilename) throws IOException, InvalidFormatException {

		// Creating a Workbook from an Excel file (.xls or .xlsx)
		Workbook workbook = WorkbookFactory.create(new File(odtrfilename));

		// Getting the Sheet at index zero
		Sheet sheet = workbook.getSheetAt(0);
		OfflineDailyRecord record;

		for (Row row : sheet) {
			record = new OfflineDailyRecord();
			record.setDate((row.getCell(0).getDateCellValue() + "").substring(4, 10));
			record.setsDay(row.getCell(1).getStringCellValue());
			record.setWorkDay(row.getCell(2).getNumericCellValue() == 1 ? true : false);
			record.setOBL(row.getCell(3).getNumericCellValue() == 1 ? true : false);
			record.setHoliday(!row.getCell(4).getStringCellValue().isEmpty() ? true : false);
			record.setVL(row.getCell(5).getStringCellValue().equals("VL") ? true : false);
			record.setSL(row.getCell(5).getStringCellValue().equals("SL") ? true : false);
			record.setTimeIn((row.getCell(8).getDateCellValue() + "").length() > 4
					? (row.getCell(8).getDateCellValue() + "").substring(10, 16)
					: "");
			record.setTimeOut((row.getCell(9).getDateCellValue() + "").length() > 4
					? (row.getCell(9).getDateCellValue() + "").substring(10, 16)
					: "");

			System.out.println(record.getDate() + " Day:"
					+ record.getsDay() + " Work Day:" + record.isWorkDay() + " OBL:" + record.isOBL() + " Holiday:"
					+ record.isHoliday() + " VL:" + record.isVL() + " SL:" + record.isSL() + " Time-in:"
					+ record.getTimeIn() + " Time-out:" + record.getTimeOut());
		}

		// Closing the workbook
		workbook.close();
		return new ArrayList<OfflineDailyRecord>();
	}
}
