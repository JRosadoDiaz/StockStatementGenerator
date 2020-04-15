import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.neumont.csc180.rosado.jose.JSONReader;

class StockStatementTests {

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

}
