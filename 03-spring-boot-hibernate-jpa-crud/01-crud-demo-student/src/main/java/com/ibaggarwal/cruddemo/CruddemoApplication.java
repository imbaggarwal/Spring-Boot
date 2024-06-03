package com.ibaggarwal.cruddemo;

import com.ibaggarwal.cruddemo.dao.StudentDAO;
import com.ibaggarwal.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createMultipleStudents(studentDAO);

			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@ibaggarwal.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		//display the id of saved student
		int theID = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theID);

		// retrieve student based on id: primary key
		System.out.println("Retrieving the student with id: " + theID);
		Student myStudent = studentDAO.findById(theID);

		// display student
		System.out.println("Found the student: " + myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create the student objects
		System.out.println("Creating new student objects ...");
		Student tempStudent1 = new Student("Bhavya", "Aggarwal", "bhavya@ibaggarwal.com");
		Student tempStudent2 = new Student("Nupur", "Saboo", "nupur@ibaggarwal.com");
		Student tempStudent3 = new Student("John", "Doe", "john@ibaggarwal.com");

		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("John", "Doe", "john@ibaggarwal.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
