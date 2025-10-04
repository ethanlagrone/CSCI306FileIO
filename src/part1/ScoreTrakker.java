package part1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {
	private ArrayList<Student> students = new ArrayList<Student>();
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };

	public void loadDataFile(String filename) throws FileNotFoundException {
		String line = "";
		FileReader reader = new FileReader(filename);
		Scanner in = new Scanner(reader);
		String score= new String();
		while (in.hasNextLine()) {
			//catch the format exception and print the problem line
			try {
				String name = in.nextLine();     
				line = name;
				score=in.nextLine();
				int intScore = Integer.parseInt(score);
			    students.add(new Student(name, intScore));
			} catch (NumberFormatException e) {
	            System.out.println("Incorrect format for " + line + " not a valid score: " +score);
	        }
			
		}
		in.close(); 
	}
	
	public void printInOrder() {
		System.out.println("\nStudent Score List");
		Collections.sort(students);
		for(Student s : students) {
			System.out.println(s);
		}
		students.clear();
		System.out.println();
	}
	
	public void processFiles(String filename) throws FileNotFoundException {
		//catch fileNotFound exception
		try {
			loadDataFile(filename);
			printInOrder();
		} catch(FileNotFoundException e) {
			System.out.println("\n" + filename + ": this file was not found. \n");
		}
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		ScoreTrakker tracker = new ScoreTrakker();
		for (String f : tracker.files) {  
			tracker.processFiles(f);
	    }
		
	}
}
