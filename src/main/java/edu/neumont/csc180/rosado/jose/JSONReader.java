package edu.neumont.csc180.rosado.jose;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONReader {
	
	public List<Account> accounts = new ArrayList<>();
	
	public JSONReader(String filePath) {
		ReadJSON(filePath);
	}

	/*
	 * Reads JSON file and adds all objects into list
	 */
	private void ReadJSON(String filePath) {
		JSONParser parser = new JSONParser();
		
		try(Reader reader = new FileReader(filePath)) {
			JSONArray trades = (JSONArray) parser.parse(reader);
			for(Object obj : trades) {
				JSONObject jsonObject = (JSONObject) obj;

				Account acc = new Account();
				
				acc.setAccountNumber((Long) jsonObject.get("account_number"));
				acc.setSsn((String) jsonObject.get("ssn"));
				acc.setFirstName((String) jsonObject.get("first_name"));
				acc.setLastName((String) jsonObject.get("last_name"));
				acc.setEmail((String) jsonObject.get("email"));
				acc.setPhone((String) jsonObject.get("phone"));
				acc.setBeginningBalance((String) jsonObject.get("beginning_balance"));
				
				JSONArray stockTrades = (JSONArray) jsonObject.get("stock_trades");
				for(Object trade : stockTrades) {
					//Parse trade into a StockTrade object
					JSONObject tradeObject = (JSONObject) trade;
					StockTrade newTrade = new StockTrade();
					
					newTrade.setType((String) tradeObject.get("type"));
					newTrade.setStockSymbol((String) tradeObject.get("stock_symbol"));
					newTrade.setCountShares((Long) tradeObject.get("count_shares"));
					newTrade.setPricePerShare((String) tradeObject.get("price_per_share"));
					
					acc.getStockTrades().add(newTrade);
				}
				
				accounts.add(acc);
			}
		
		} catch(IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		
	}
}
