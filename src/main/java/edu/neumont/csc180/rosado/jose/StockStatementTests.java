package edu.neumont.csc180.rosado.jose;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;

import org.junit.jupiter.api.Test;

public class StockStatementTests {

	JSONReader reader;
	
	@org.junit.jupiter.api.BeforeEach
	void setup() {
		String filePath = "C:\\Users\\Jose Rosado\\eclipse-workspace\\StockStatementGeneratorAssignment\\src\\main\\java\\edu\\neumont\\csc180\\rosado\\jose\\stock_transations.by.account.holder.json\\";
		reader = new JSONReader(filePath);
	}
	
	@Test
	public void should_read_first_name_of_object_from_JSON() {
		//arrange
		String expected = "Margalo";
		
		//act
		String actual = reader.accounts.get(0).getFirstName();
		
		//assert
		assertEquals(expected, actual);
	}
	
	@Test
	public void html_file_is_created() {
		//arrange
		Account testAccount = reader.accounts.get(0);
		HTMLGenerator htmlBuilder = new HTMLGenerator(testAccount);
		String filePath = "Margalo_Trobey.html";
		
		//act
		htmlBuilder.createHTMLFile(testAccount);
		File f = new File(filePath);
		
		//assert
		boolean exists = f.exists();
		assertTrue(exists);
	}
}
