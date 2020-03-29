import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//Problem 1 shall contain a public class called DuplicateRemover
public class DuplicateRemover {

  Set<String> uniqueWords = new HashSet<String>();
  public String uniqueWordsFound = "Unique Words found shown below!\n ";
  
  
  public void remove(String dataFile) { //DuplicateRemover shall contain a method called remove
	  try {
		  //Given the path to a text file, the remove method shall determine the 
		  //unique words contained in dataFIle and store those unique words in the associated DuplicateRemover object
		  Scanner fileReader = new Scanner(new File(dataFile));
		  while(fileReader.hasNext()) {
			  uniqueWords.add(fileReader.next().toLowerCase());
		  }
		  fileReader.close();
	  } 
	  catch(FileNotFoundException fileNotFoundException) {//The remove method shall terminate the program and alert the user with a user-friendly message when an exceptional IO event occurs
		  System.out.println("Sorry, it appears that your File can not be found");
		  System.exit(1);
	  }	
	  //The remove method shall clean up any and all resources allocated during method execution(organizes for later usage)
	  for(String wordsFound : uniqueWords) {
		  uniqueWordsFound = uniqueWordsFound + "\n" + wordsFound; 
	  }
  }
  
  public void write(String outputFile) { //DuplicateRemover shall contain a method called write
	  //The write method shall clean up any and all resources allocated during method execution
	  File output = new File(outputFile);
	  if(output.exists()) {
		  output.delete();
	  }
	  
	  try {
		  //Given the path to a text file, the write method shall print the current collection of unique words to outputFile
		 BufferedWriter outputWriter = new BufferedWriter(new FileWriter(outputFile));	  
		  outputWriter.write(uniqueWordsFound);
		  outputWriter.close();
	  }catch(IOException ioException) { //The write method shall terminate the program and alert the user with a user-friendly message when an exceptional IO event occurs
		  System.out.println("Sorry, an error has occurred while writing...");
		  System.exit(1);
	  }
  }
}