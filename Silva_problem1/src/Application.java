//Problem 1 shall contain a public class called Application
public class Application { //Application shall contain a main method

    public static void main(String[] args) { 
    	DuplicateRemover duplicateRemover = new DuplicateRemover(); //The main method shall create an instance of a DuplicateRemover called duplicateRemover
    	//The main method shall use the write method of duplicateRemover
    	//to output the unique words of "problem1.txt" to a file called "unique_words.txt"
    	duplicateRemover.remove("problem1.txt");
    	duplicateRemover.write("unique_words.txt");

    }
}