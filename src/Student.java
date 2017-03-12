/*
 * Student.java
 * 
 * @author Andrew Parise 
 * @since 1/26/2016
 * 
 * <p>
 * Value Object that stores the data for each student
 * 
 */
public class Student {
	private String name; //Name of the Student, store in uppercase
	private double grade; //Grade the student has
	private int idNum; //number of student, for sorting and calling
	//constructor
	Student(String name, double grade, int idNum){
		this.name = name; //store in uppercase
		this.grade = grade;
		this.idNum = idNum;
	}
	
	//Setters and Getters
	public int getIdNum(){
		return idNum;
	}
	public void setIdNum(int idNum){
		this.idNum = idNum;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public double getGrade(){
		return grade;
	}
	public void setGrade(double grade){
		this.grade = grade;
	}
	
}
