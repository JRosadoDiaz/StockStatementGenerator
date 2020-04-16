package edu.neumont.csc180.rosado.jose;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

public class Main {
	
	static String filePath = "C:\\Users\\Jose Rosado\\eclipse-workspace\\StockStatementGeneratorAssignment\\src\\main\\java\\edu\\neumont\\csc180\\rosado\\jose\\stock_transations.by.account.holder.json\\";

	public static void main(String[] args) {
		
		// Reads JSON file and stores accounts into a list
		JSONReader reader = new JSONReader(filePath);
		
		// Test Account
//		Account testAccount = reader.accounts.get(0);
		 
//		HTMLGenerator htmlBuilder = new HTMLGenerator(testAccount);
//		htmlBuilder.createHTMLFile(testAccount);
		
		for(Account acc : reader.accounts) {
			// Build xhtml files for all accounts in list
			HTMLGenerator.createHTMLFile(acc);
			
			// Then create a PDF file from xhtml file
			PDFGenerator.createPDFFile(acc, HTMLGenerator.getURIFormat(acc).toString());
		}
		
		System.out.println("All PDF Files created");
	}

}
