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
		// TODO Auto-generated method stub
		
		JSONReader reader = new JSONReader(filePath);
		
		Account testAccount = reader.accounts.get(0);
		
		HTMLGenerator htmlBuilder = new HTMLGenerator(testAccount);
		htmlBuilder.createHTMLFile(testAccount);
		
		
		
		
//		try (OutputStream os = new FileOutputStream("out.pdf")) {
//            PdfRendererBuilder builder = new PdfRendererBuilder();
//            builder.useFastMode();
//            builder.withUri("file:///Users/me/Documents/pdf/in.htm");
//            builder.toStream(os);
//            builder.run();
//		}
	}

}
