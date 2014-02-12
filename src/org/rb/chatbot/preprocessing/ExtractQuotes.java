package org.rb.chatbot.preprocessing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is used to extract stuff from the Quotes Dataset file.
 * @author RB
 *
 */
public class ExtractQuotes {

	/**
	 * The delimiter I used in my dataset file.
	 */
	private static final String QUOTE_DELIMITER = "-------";
	
	/**
	 * Name of the dataset file
	 */
	private static final String FILE_NAME = "quotesDataSet.txt";
	
	/**
	 * Does what it says. Extracts the quotes and puts 'em in an ArrayList for your usage.
	 * @return ArrayList of Strings. Each element is a quotes.
	 * @throws IOException
	 */
	public static ArrayList<String> getQuotesList() throws IOException{
		FileReader fileReader = new FileReader(FILE_NAME);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		ArrayList<String> quotesList = new ArrayList<String>();
		String line = "";
		String joke = "";
		while((line=bufferedReader.readLine())!=null){
			if(line.trim().equals(QUOTE_DELIMITER)){
				quotesList.add(joke);
				joke = "";
			}
			else{
				joke += " " + line;
			}
		}
		bufferedReader.close();
		fileReader.close();
		return quotesList;
	}

}
