package dev.nichoko.hibernate;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.nichoko.hibernate.dao.StudentDAO;
import dev.nichoko.hibernate.entity.Student;

@SpringBootApplication
public class HibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
			readStudent(studentDAO);
			readdAllStudents(studentDAO);
			updateStudent(studentDAO);
			deleteStudent(studentDAO);
		};
	}

	private void readdAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		for (Student student : students) {
			System.out.println(student);
		}

	}

	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("Hans", "Mayer", "test@test.com");
		studentDAO.save(student);
	}

	private void readStudent(StudentDAO studentDAO) {
		int id = 2;
		Student foundStudent = studentDAO.findById(id);
		System.out.println("Read student: " + foundStudent);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int id = 2;
		Student foundStudent = studentDAO.findById(id);

		String newEmail = "updated@email.com";
		foundStudent.setEmail("updated@email.com");

		studentDAO.update(foundStudent);
		System.out.println("Updating student to: " + newEmail);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		List<Student> students = studentDAO.findAll();

		Integer lastPosition = students.size() - 1;
		Integer lastStudent = students.get(lastPosition).getId();
		studentDAO.delete(lastStudent);
		System.out.println("Deleting student with id: " + lastStudent);
	}

}
