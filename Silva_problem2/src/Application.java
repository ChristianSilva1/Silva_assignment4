
public class Application { //Problem 2 shall contain a public class called Application

	public static void main(String[] args) { //Application shall contain a main method
		DuplicateCounter duplicateCounter = new DuplicateCounter(); //The main method shall create an instance of a DuplicateCounter called duplicateCounter
		//The main method shall use the write method of duplicateCounter to output the
		//unique words of "problem2.txt" to a file called "unique_word_counts.txt"
		duplicateCounter.count("problem2.txt");
		duplicateCounter.write("unique_word_counts.txt");

	}

}
