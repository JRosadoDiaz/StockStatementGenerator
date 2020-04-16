package edu.neumont.csc180.rosado.jose;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;

public class HTMLGenerator {
	
	static void createHTMLFile(Account acc) {
		String HTMLString = createHTMLString(acc);
		
		String folderName = "HTML_Files";
		boolean folderExists = new File(folderName).mkdir();
		if(folderExists) {
			System.out.println("HTML Folder Created");
		}
		
		try {
			String fileName = acc.getFirstName() + "_" + acc.getLastName() + ".html";
			File htmlFile = new File(folderName + "/" + fileName);
			FileWriter writer = new FileWriter(folderName + "/" + fileName);
			writer.write(HTMLString);
			writer.close();
			
//			if(htmlFile.createNewFile()) {
//				System.out.println("File created: " + htmlFile.getName());
//			}
//			else {
//			}
			System.out.println("File Created: " + htmlFile.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String createHTMLString(Account acc) {
		String RawHTML = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">"
				 + "<html xmlns=\"http://www.w3.org/1999/xhtml\">"
				 	+ "<head>"
				 		+ "<title>" + acc.getFirstName() + " " + acc.getLastName() + "</title>"
				 	+ "</head>"
				 	+ "<body>"
				 		+ "<h1>Account Number: " + acc.getAccountNumber() + ", " + acc.getFirstName() + " " + acc.getLastName() + "</h1>"
				 		+ "<p>email: " + acc.getEmail() + "</p>"
				 		+ "<p>phone: " + acc.getPhone() + "</p>"
				 		+ "<p>beginning balance: " + acc.getBeginningBalance() + "</p>"
				 		+ "<p>ssn: " + acc.getSsn() + "</p>"
				 		+ "<h2>Stock Trades</h2>";
		
		for(StockTrade s : acc.getStockTrades()) {
			RawHTML += "<ul>"
						+ "<li>Type: " + s.getType() + "</li>"
						+ "<li>Stock Symbol: " + s.getStockSymbol() + "</li>"
						+ "<li>Count Shares: " + s.getCountShares() + "</li>"
						+ "<li>Price per Share: " + s.getPricePerShare() + "</li>"
					+ "</ul>";
		}
		
		RawHTML += "</body></html>";
		
		return RawHTML;
	}
	
	static URI getURIFormat(Account account) {
		String fileName = "HTML_Files/" + account.getFirstName() + "_" + account.getLastName() + ".html";
		File currentFile = new File(fileName);
		return currentFile.toURI();
	}
}
