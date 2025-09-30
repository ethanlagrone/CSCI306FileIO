package part1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {
	private ArrayList<Student> students = new ArrayList<Student>();
	
	public void loadDataFile(String filename) throws FileNotFoundException {
		FileReader reader = new FileReader(filename);
		Scanner in = new Scanner(reader);
		while (in.hasNext()) {
			String name = in.nextLine();     
			int score = Integer.parseInt(in.nextLine());   
		    students.add(new Student(name, score));
		}
		in.close();
	}
	
	public void printInOrder() {
		Collections.sort(students);
		for(Student s : students) {
			System.out.println(s);
		}
	}
	
	public void processFiles() throws FileNotFoundException {
		loadDataFile("scores.txt");
		printInOrder();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		ScoreTrakker tracker = new ScoreTrakker();
	    tracker.processFiles();
		
	}
}
