//assignment 1 alon cohen 319039707
package s1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Read {
	class Student {
		private String firstName;
		private String lastName;
		private String id;

		// Getter methods
		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public String getId() {
			return id;
		}

		// Constructor that accepts parameters
		public Student(String firstName, String lastName, String id) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.id = id;
		}
	}

	class CourseGrade {
		private String id;

		private double average;
		
		// Getter methods
		public String getId() {
			return id;
		}

		public double getAverage() {
			return average;
		}

		// Constructor that accepts parameters
		public CourseGrade(String id, int grade1, int grade2) {
			this.id = id;
			this.average = (grade2 + grade1) / 2;
		}
	}

	public static void main(String[] args) {
		try {
			Read readInstance = new Read();
			readInstance.start();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void start() throws FileNotFoundException {
        // Read data from files
		Student[] students = readStudentsFile("C:\\Users\\ALON\\Desktop\\CS.txt.txt");
		CourseGrade[] grades = readGradesFile("C:\\Users\\ALON\\Desktop\\hedva.txt.txt");
       
		// Generate report
		generateReport("C:\\Users\\ALON\\Desktop\\report.txt", students, grades);
		System.out.println("the code run corrctly");
	}

	// get the info about the student from a file to create students and carry on
	// until there is no other students

	private Student[] readStudentsFile(String filePath) throws FileNotFoundException {
		try (Scanner input = new Scanner(new File(filePath))) {
			Student[] students = new Student[1];
			int index = 0;

			while (input.hasNext()) {
				String firstName = input.next();
				String lastName = input.next();
				String studentId = input.next();
				students[index] = new Student(firstName, lastName, studentId);

				if (input.hasNext()) {
					Student[] students2 = new Student[students.length + 1];
					for (int i = 0; i < students.length; i++) {
						students2[i] = students[i];
					}
					students = students2;
				}

				index++;
			}

			return students;
		}
	}

	// get the info about the CourseGrade from a file to create CourseGrade and
	// carry on until there is no other CourseGrade in the file
	private CourseGrade[] readGradesFile(String filePath) throws FileNotFoundException {
		try (Scanner input = new Scanner(new File(filePath))) {
			CourseGrade[] grades = new CourseGrade[1];
			int index = 0;

			while (input.hasNext()) {
				String studentId = input.next();
				int grade1 = input.nextInt();
				int grade2 = input.nextInt();
				grades[index] = new CourseGrade(studentId, grade1, grade2);

				if (input.hasNext()) {
					CourseGrade[] grades2 = new CourseGrade[grades.length + 1];
					for (int i = 0; i < grades.length; i++) {
						grades2[i] = grades[i];
					}
					grades = grades2;
				}
				index++;

			}
			return grades;
		}
	}

	private void generateReport(String outputFilePath, Student[] students, CourseGrade[] grades)
			throws FileNotFoundException {
		try (PrintWriter writer = new PrintWriter(outputFilePath)) {
			for (CourseGrade grade : grades) {
				String id = grade.getId();
				Student student = findStudentById(students, id);
//As long as the student not null genrete in the new file in the format that i say
				if (student != null) {
					String line = String.format("%s %s %s ", id, student.getFirstName() + " " + student.getLastName(),
							grade.getAverage());
					writer.println(line);
				}
			}
		}
	}
//check if there id equal to student.id and if true return it and if not null
	private Student findStudentById(Student[] students, String id) {
		for (Student student : students) {
			if (student == null) {
				break;
			}

			if (id.equals(student.id)) {
				return student;
			}
		}

		return null;
	}
}
