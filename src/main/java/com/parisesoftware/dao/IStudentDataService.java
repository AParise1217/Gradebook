package com.parisesoftware.dao;//Imports
import com.parisesoftware.model.Student;

import java.util.List;

/*
 * IStudentDataService.java
 * 
 * @author 	Andrew Parise
 * @since 	1/26/2016
 * @version 6/2/2018
 *
 * Data Access Interface
 */
public interface IStudentDataService {


	List<Student> getAllStudents(); //returns a list of all students


	Student getStudent(int idNum); //searches through gradebook by name to return student object


	void updateStudent(Student student); //updates the grade value for given student


	void deleteStudent(Student student); //removes student from gradebook


	void sortGradebook(GradebookSortType sortBy); //sorts the gradebook based off of either name or grade


}
