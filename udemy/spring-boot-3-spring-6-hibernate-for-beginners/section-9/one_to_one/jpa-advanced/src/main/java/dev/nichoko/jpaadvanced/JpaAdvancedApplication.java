package dev.nichoko.jpaadvanced;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.nichoko.jpaadvanced.dao.AppDAO;
import dev.nichoko.jpaadvanced.entity.Instructor;
import dev.nichoko.jpaadvanced.entity.InstructorDetail;

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
			deleteInstructorDetail(appDAO);
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
	 * @param appDAO
	 */
	void deleteInstructor(AppDAO appDAO){
		int id = 1;
		System.out.println("Removing instructor with id: " + id);
		appDAO.removeById(id);
	}


	/**
	 * Find instructor detail by an hardcoded id
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
	 * @param appDAO
	 */
	void deleteInstructorDetail(AppDAO appDAO){
		int id = 4;
		System.out.println("Removing instructor detail with id: " + id);
		appDAO.removeInstructorDetailById(id);
	}

}
