package dev.nichoko.jpaadvanced;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.nichoko.jpaadvanced.dao.AppDAO;
import dev.nichoko.jpaadvanced.entity.Course;
import dev.nichoko.jpaadvanced.entity.Instructor;
import dev.nichoko.jpaadvanced.entity.InstructorDetail;
import dev.nichoko.jpaadvanced.entity.Review;
import dev.nichoko.jpaadvanced.entity.Student;

@SpringBootApplication
public class JpaAdvancedApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaAdvancedApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			System.out.println("Application is up and running...");
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			// deleteInstructor(appDAO);
			// findInstructorDetail(appDAO);
			// deleteInstructorDetail(appDAO);
			// createInstructorWithCourses(appDAO);
			// findInstructorWithCourses(appDAO);
			// findInstructorCourses(appDAO);
			// findInstructorWithCoursesJoined(appDAO);
			// updateInstructor(appDAO);
			// updateCourse(appDAO);
			// deleteInstructorWithoutCourses(appDAO);
			// deleteCourse(appDAO);
			// createCourseAndReviews(appDAO);
			// findCourseAndReviews(appDAO);
			// deleteCourseAndReviews(appDAO);
			// createCourseAndStudents(appDAO);
			// findCourseAndStudents(appDAO);
			// findStudentAndCourses(appDAO);
			// addCourseToStudent(appDAO);
			deleteStudent(appDAO);
		};
	}

	/**
	 * Creates a new instructor
	 * 
	 * @param appDAO
	 */
	void createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("firstName", "lastName", "test@test.com");

		InstructorDetail instructorDetail = new InstructorDetail("@myYouTubeChannel", "cycling");
		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Creating instructor: " + instructor);
		appDAO.save(instructor);

	}

	/**
	 * Retrieve the data of an hardcoded id
	 * 
	 * @param appDAO
	 */
	void findInstructor(AppDAO appDAO) {
		int id = 4;

		System.out.println("Fetching instructor with id " + id);
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor found: " + instructor);
	}

	/**
	 * Removes a hardcoded instructor by id
	 * 
	 * @param appDAO
	 */
	void deleteInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Removing instructor with id: " + id);
		appDAO.removeById(id);
	}

	/**
	 * Find instructor detail by an hardcoded id
	 * 
	 * @param appDAO
	 */
	private void findInstructorDetail(AppDAO appDAO) {
		int id = 1;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

		System.out.println("Instructor detail found: " + instructorDetail);
		System.out.println("Instructor for detail is: " + instructorDetail.getInstructor());
	}

	/**
	 * Removes a hardcoded instructor by id
	 * 
	 * @param appDAO
	 */
	void deleteInstructorDetail(AppDAO appDAO) {
		int id = 4;
		System.out.println("Removing instructor detail with id: " + id);
		appDAO.removeInstructorDetailById(id);
	}

	/**
	 * Creates a new instructor with two courses
	 * 
	 * @param appDAO
	 */
	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor("myFirstName", "myLastName", "my_email@test.com");

		Course course1 = new Course("my course 5");
		Course course2 = new Course("my course 6");

		instructor.addCourse(course1);
		instructor.addCourse(course2);

		System.out.println("Creating new instructor with courses " + instructor);

		appDAO.save(instructor);
	}

	/**
	 * This method will only work if instructor fetches the courses eagerly
	 * 
	 * @param appDAO
	 */
	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 5;

		System.out.println("Finding instructor by id " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor found " + instructor);
		System.out.println("Instructor courses are " + instructor.getCourses());
	}

	/**
	 * Find the courses independent from the instructor
	 * 
	 * @param appDAO
	 */
	private void findInstructorCourses(AppDAO appDAO) {
		int id = 5;

		System.out.println("Finding instructor courses by id " + id);

		List<Course> courses = appDAO.findCoursesForInstructorId(id);

		System.out.println("Instructor courses are " + courses);
	}

	/**
	 * Explicitly fetch the courses together with the instructor
	 * 
	 * @param appDAO
	 */
	private void findInstructorWithCoursesJoined(AppDAO appDAO) {
		int id = 5;

		System.out.println("Finding instructor by id " + id);

		Instructor instructor = appDAO.findInstructorWithCoursesById(id);

		System.out.println("Instructor found " + instructor);
		System.out.println("Instructor courses are " + instructor.getCourses());
	}

	/**
	 * Update a instructor with a new name
	 * 
	 * @param appDAO
	 */
	private void updateInstructor(AppDAO appDAO) {
		int id = 4;
		Instructor instructor = appDAO.findInstructorById(id);

		instructor.setFirstName("UpdatedFirstName");

		appDAO.update(instructor);
	}

	/**
	 * Update instructor with new title
	 * 
	 * @param appDAO
	 */
	private void updateCourse(AppDAO appDAO) {
		int id = 1;
		Course course = appDAO.findCourseById(id);

		course.setTitle("UpdatedTitle");

		appDAO.update(course);
	}

	/**
	 * Delete instructor
	 * 
	 * @param appDAO
	 */
	private void deleteInstructorWithoutCourses(AppDAO appDAO) {
		int id = 11;

		appDAO.deleteInstructorById(id);

		System.out.println("Instructor with id " + id + " deleted");

	}

	/**
	 * Delete course without deleting instructor
	 * 
	 * @param appDAO
	 */
	private void deleteCourse(AppDAO appDAO) {
		int id = 1;

		appDAO.deleteCourseById(id);

		System.out.println("Course with id " + id + " deleted");

	}

	/**
	 * Create a course and reviews together
	 * 
	 * @param appDAO
	 */
	private void createCourseAndReviews(AppDAO appDAO) {
		Course course = new Course("my new course");

		Review review = new Review("my first review");
		Review review2 = new Review("my second review");

		course.addReview(review);
		course.addReview(review2);

		appDAO.save(course);

		System.out.println("The course " + course + " was saved");
	}

	/**
	 * Fetch a course and its reviews together
	 * 
	 * @param appDAO
	 */
	private void findCourseAndReviews(AppDAO appDAO) {
		int id = 7;
		Course course = appDAO.findCourseAndReviewsByCourseId(id);

		System.out.println("Course found " + course);
		System.out.println("Course reviews are: " + course.getReviews());
	}

	/**
	 * Delete a course and all its reviews
	 * 
	 * @param appDAO
	 */
	private void deleteCourseAndReviews(AppDAO appDAO) {
		int id = 7;

		appDAO.deleteCourseById(id);

		System.out.println("Course with id " + id + " was deleted");
	}

	/**
	 * Save a student together with the courses
	 * 
	 * @param appDAO
	 */
	private void createCourseAndStudents(AppDAO appDAO) {
		Course course1 = new Course("My students course 1");

		Student student1 = new Student("firstName", "SecondName", "email");
		Student student2 = new Student("firstName2", "SecondName2", "email2");

		course1.addStudent(student1);
		course1.addStudent(student2);

		appDAO.save(course1);
	}

	/**
	 * Join a student and all its courses in one single query
	 * 
	 * @param appDAO
	 */
	private void findStudentAndCourses(AppDAO appDAO) {
		int id = 1;

		Student student = appDAO.findStudentAndCoursesByStudentId(id);

		System.out.println("Student found: " + student);
		System.out.println("Courses of student found: " + student.getClass());
	}

	/**
	 * Add course to student
	 * 
	 * @param appDAO
	 */
	private void addCourseToStudent(AppDAO appDAO) {
		int id = 1;

		Student student = appDAO.findStudentAndCoursesByStudentId(id);

		Course newCourse = new Course("the new course");

		student.addCourse(newCourse);

		appDAO.update(student);
	}

	/**
	 * Delete student
	 * 
	 * @param appDAO
	 */
	private void deleteStudent(AppDAO appDAO) {
		int id = 1;

		appDAO.deleteStudentById(id);

		System.out.println("Student with id " + id + " deleted");

	}
}
