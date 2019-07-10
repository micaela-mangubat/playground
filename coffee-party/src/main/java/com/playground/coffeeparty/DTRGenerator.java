package com.playground.coffeeparty;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class DTRGenerator {

	public static void main(String... args) {
		String odtrFilename = args[0];
		String dtrFilename = args[1];
		String yrMonth = args[2];
		generate(odtrFilename, dtrFilename, yrMonth);
	}
	
	public static void generate(String odtrFilename, String dtrFilename, String yrMonth) {
		ODTRReader odtrReader = new ODTRReader();
		DTRWriter dtrWriter = new DTRWriter();
		
		try {
			ArrayList<OfflineDailyRecord> odtrRecords = odtrReader.readOfflineDtr(odtrFilename);
			dtrWriter.editWorkbook(odtrRecords, dtrFilename, yrMonth);
			
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
