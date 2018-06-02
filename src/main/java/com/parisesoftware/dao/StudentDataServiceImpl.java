package com.parisesoftware.dao;//Imports
import com.parisesoftware.model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



/*
 * StudentDataServiceImpl.java
 *
 * @author 	Andrew Parise
 * @since 	2/3/2016
 * @version 6/2/2018
 *
 * Concrete class that implements IStudentDataService.java interface
 *
 */
public class StudentDataServiceImpl implements IStudentDataService {

	/**
	 * list containing student objects
	 */
	private List<Student> gradebook;

	/**
	 * Default Constructor
	 */
	public StudentDataServiceImpl(){
		this.gradebook = new ArrayList<>();
	}

	@Override
	public List<Student> getAllStudents() {
		// returns the gradebook list of student objects
		return gradebook;
	}

	@Override
	public Student getStudent(int idNum) {
		// returns student object
		return gradebook.get(idNum);
	}

	public Student getStudentByName(String name){
		name = name.toUpperCase(); //normalize input

		for(Student iterVal : gradebook){
			if(iterVal.getName().contains(name)){ //if Student object contains name with value searching for
				return iterVal;
			}
		}
		return null;
	}

	@Override
	public void updateStudent(Student student) {
		try{
			gradebook.get(student.getIdNum()).setName(student.getName());
			System.out.println("Student: ID Number " + student.getIdNum() + ", updated.");
		} catch (IndexOutOfBoundsException e){
			//Student index does not exist, create new one
			gradebook.add(student.getIdNum(),student);
			System.out.println("Student: [ID Number : " + student.getIdNum() + ", Name : " + student.getName() + ", Grade: " + student.getGrade() + "], added.");
		}

	}

	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub
		gradebook.remove(student.getIdNum());
		System.out.println("Student: ID Number " + student.getIdNum() + ", deleted.");

	}

	private static Comparator<Student> gradeCompare = new Comparator<Student>() {
		public int compare(Student stu1, Student stu2){
			double Student1Grade = stu1.getGrade();
			double Student2Grade = stu2.getGrade();

			//workaround- comparator interface requires int return type, but using double values
			//return Student2Grade-Student1Grade is a double type, not int
			double delta = Student2Grade-Student1Grade; //delta = difference
			if(delta > 0) return 1;
			if(delta < 0) return -1;
			return 0;
		}
	};

	private static Comparator<Student> nameCompare = new Comparator<Student>(){
		//Sorts the gradebook by name
		public int compare(Student stu1, Student stu2){
			String Student1Name = stu1.getName().toUpperCase();
			String Student2Name = stu2.getName().toUpperCase();

			return Student1Name.compareTo(Student2Name);
		}
	};


	@Override
	public void sortGradebook(GradebookSortType sortBy) {

		//sorts the gradebook by name
		if(sortBy == GradebookSortType.Name){
			Collections.sort(gradebook, StudentDataServiceImpl.nameCompare);
		}

		//sorts the gradebook by grade
		if(sortBy == GradebookSortType.Grade){
			Collections.sort(gradebook, StudentDataServiceImpl.gradeCompare);
		}
	}

}
