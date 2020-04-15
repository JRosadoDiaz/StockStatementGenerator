package edu.neumont.csc180.rosado.jose;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HTMLGenerator {

	private String RawHTML = "";
	
	public HTMLGenerator(Account acc) {
		RawHTML = createHTMLString(acc);
	}
	
	private String createHTMLString(Account acc) {
		RawHTML += "<!DOCTYPE html>"
				 + "<html>"
				 	+ "<head>"
				 		+ "<title>" + acc.getFirstName() + " " + acc.getLastName() + "</title>"
				 	+ "</head>"
				 	+ "<body>"
				 		+ "<header>"
				 		+ "<h1>Account Number: " + acc.getAccountNumber() + ", " + acc.getFirstName() + " " + acc.getLastName() + "</h1>"
				 		+ "</header>"
				 		+ "<p>email: " + acc.getEmail() + "</p>"
				 		+ "<br>"
				 		+ "<p>phone: " + acc.getPhone() + "</p>"
				 		+ "<br>"
				 		+ "<p>beginning balance: " + acc.getBeginningBalance() + "</p>"
				 		+ "<br>"
				 		+ "<p>ssn: " + acc.getSsn() + "</p>"
				 		+ "<br>"
				 		+ "<h2>Stock Trades</h2>"
				 		+ "<br>";
		
		for(StockTrade s : acc.getStockTrades()) {
			RawHTML += "<ul>"
						+ "<li>Type: " + s.getType() + "</li>"
						+ "<li>Stock Symbol: " + s.getStockSymbol() + "</li>"
						+ "<li>Count Shares: " + s.getCountShares() + "</li>"
						+ "<li>Price per Share: " + s.getPricePerShare() + "</li>"
					+ "</ul>"
					+ "<br>";
		}
		
		RawHTML += "</body></html>";
		
		return RawHTML;
	}
	
	public void createHTMLFile(Account acc) {
		try {
			String fileName = acc.getFirstName() + "_" + acc.getLastName() + ".html";
			File htmlFile = new File(fileName);
			FileWriter writer = new FileWriter(fileName);
			writer.write(RawHTML);
			writer.close();
			
			if(htmlFile.createNewFile()) {
				System.out.println("File created: " + htmlFile.getName());
			}
			else {
				System.out.println("File already exists");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
