package part1;

public class Student implements Comparable<Student>{
	private String name = new String();
	private int score = 0;
	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	
	//toString implementation
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}
	
	
	//comparing by score
	@Override
	public int compareTo(Student o) {
		return this.score - o.score;
	}
}
