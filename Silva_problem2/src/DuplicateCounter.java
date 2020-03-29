import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
//Problem 2 shall contain a public class called DuplicateCounter

public class DuplicateCounter {
	
	private HashMap<String, Integer> duplicateWordCounter = new HashMap<String, Integer>();
	
	public void count(String dataFile) { //DuplicateCounter shall contain a method called count
		//The count method shall clean up any and all resources allocated during method execution
		try {
			Scanner textReader = new Scanner(new File(dataFile));
			String words;
			while(textReader.hasNext()) { //Given the path to a text file, the count method shall determine
				//the number of occurrences of each word contained in dataFIle and store each unique word and its count in the associated DuplicateCounter object

				words = textReader.next().toLowerCase();
				
				if(duplicateWordCounter.containsKey(words)) {
					
					int counter = duplicateWordCounter.get(words);
					
					counter = counter + 1;
					
					duplicateWordCounter.replace(words, counter);
					
				} else {
					duplicateWordCounter.put(words, 1);
					
				}
			}
		 //The count method shall terminate the program and alert the user when an exceptional IO event occurs	
		} catch(FileNotFoundException fileNotFoundException) {
			System.out.println("Sorry, your file could not be located, please try again...");
			System.exit(1);
		}
		
	}
	
	public void write(String outputFile) { //DuplicateCounter shall contain a method called write
		Iterator duplicateWordCounterIterator = duplicateWordCounter.entrySet().iterator();
		String uniqueWordsAndCounter = " ";
		//The write method shall clean up any and all resources allocated during method execution
		 File output = new File(outputFile);
		  if(output.exists()) {
			  output.delete();
		  }
		  
		try { //Given the path to a text file, the write method shall print the current collection of unique words and their counts to outputFile
			BufferedWriter outputWriter = new BufferedWriter(new FileWriter(outputFile));
			while(duplicateWordCounterIterator.hasNext()) {
				Map.Entry mapElement = (Map.Entry)duplicateWordCounterIterator.next();
				int count = ((int)mapElement.getValue());
				uniqueWordsAndCounter = (mapElement.getKey() + " was repeated " + count + " times\n");	  
				  outputWriter.write(uniqueWordsAndCounter);
			}
			outputWriter.close();
		} catch(IOException ioException) { //The write method shall terminate the program and alert the user when an exceptional IO event occurs
			System.out.println("An error has occured trying to open the File");
			System.exit(1);
		}
		
		
	}
}
