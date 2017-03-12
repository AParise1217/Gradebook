import java.util.Random;
import java.util.regex.Pattern;

/*
 * DataAccessor.java
 * 
 * @author Andrew Parise
 * @since 2/3/2016
 * 
 * <p>
 * Controller for accessing and calling gradebook functions
 * 
 * Use this file to run tests on code
 * 
 */

public class DataAccessor {
	
	public static void printStudentList(StudentDataInterf gradebook){
		//Prints out the roster of students to the console
		for(Student student : gradebook.getAllStudents()) {
	         System.out.println("Student: [ID Number : " + student.getIdNum() + ", Name : " + student.getName() + ", Grade: " + student.getGrade() + "]");
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentDataInterf gradebook = new StudentDataImpl(); //instantiates the gradebook object
		
		/*
		 * Usage Doc:
		 * 
		 * Create gradebook: "StudentDataInterf gradebook = new StudentDataImpl();"
		 * 
		 * Create student object: "Student student0 = new Student(
		 * 			"Andrew",	//Name 				-	String
		 *  		95.0,		//Grade				-	Double
		 *  		 0);"		//Student ID Number	-	Integer
		 * 
		 * Valid Student object method calls:
		 * 		(g/s)etIdNum(int)
		 * 		(g/s)etGrade(double)
		 * 		(g/s)etName(String)
		 * 		
		 * Add Student to gradebook: "gradebook.updateStudent(student0);", where 'student0' is the name of the Student object
		 * 
		 * Valid StudentDataImpl (gradebook) method calls: (check StudentDataInterf.java for usage)
		 * 		getStudent(int iDNum)
		 * 		updateStudent(Student studentObject)
		 * 		deleteStudent(Student studentObject)
		 * 		sortGradebook(String sortBy) //accepts either "NAME" or "GRADE" as input to determine what to sort by
		 * 		
		 * Valid DataAccessor method calls:
		 * 		printStudentList(StudentDataInterf gradebookObject)
		 * 
		 */
		
//		//Sample gradebook population calls
//		Student student0 = new Student("Andrew", 95.0, 0);
//		Student student1 = new Student("Bryan",70.0, 1);
//		Student student2 = new Student("Jesse", 85.0, 2);
//		gradebook.updateStudent(student0);
//		gradebook.updateStudent(student1);
//		gradebook.updateStudent(student2);
		
//		//sample update student call
//		Student student =gradebook.getAllStudents().get(0);
//		student.setName("Zack");
//		gradebook.updateStudent(student);
		
		
//		//sample delete student call
//		student = gradebook.getStudent(1);
//		gradebook.deleteStudent(student);
		  
//		//sample print/sort calls
//		gradebook.getStudent(0);
//		System.out.println("Student: [ID Number : " + student.getIdNum() + ", Name : " + student.getName() + ", Grade: " + student.getGrade() + "]");
//		System.out.println("----");
//		printStudentList(gradebook);
//		System.out.println("----");
//		gradebook.sortGradebook("NAME");
//		printStudentList(gradebook);
//		System.out.println("----");
//		gradebook.sortGradebook("GRADE");
//		printStudentList(gradebook);
		
		
		//***************************************************************************
		//**************************Building a Solution******************************
		//***************************************************************************
		//Generating Random Test Data:
		
		//Randomly generated String of names, with "   " as the delimiter
		String randFiftyName = ("Pilar   Reiko   Gordon   Felica   Veola   Dalton   Rosina   Earlene   Lajuana   Joane   Lu   Dalia   Elke   Laverne   Merle   Candi   Michaele   Meghan   Anisha   Almeda   Elidia   Harmony   Anh   Mervin   Genie   Gala   Gwenn   Karlene   Suk   Myrna   Jefferey   Quyen   Cyrus   Merri   Neely   Lucile   Pinkie   Brenda   Jerold   Ermelinda   Joie   Nga   Pandora   Lucia   Trudie   Araceli   Lowell   Clifford   Pa   Brigida");
		String randThirtyName = ("Vivan   Harrison   Kenyatta   Gretta   Shelba   Eugenia   Latarsha   Charlena   Yael   Marva   Sean   Israel   Gustavo   Renata   Kayla   Gloria   Maybell   Estela   Rosio   Daisy   Nannie   Kum   Rosenda   Hosea   Carleen   Scarlett   Katheleen   Ariel   Celia   Breann");
		String randTwentyName = ("Joie   Libbie   Elizebeth   Jerilyn   Karmen   Leeanna   Concetta   Sasha   Cruz   Keith   Aurelia   Jolie   Melissa   Shawanda   Tawna   Darren   Vanesa   Nichelle   Jennie   Eartha");
		
		//Choose Data Size from above and set randNameList to it
		String randomNameList = randTwentyName; //USEAGE NOTE: MUST BE "randFiftyName", "randThirtyName" or "randTwentyName"
		final String[] studentNameList = randomNameList.split(Pattern.quote("   ")); //splits into String[]
		Random randNumGen = new Random();
		double randDouble, randTruncatedDouble;
		int aux;
		for(int i = 0; i < studentNameList.length; i++){
			randDouble = (randNumGen.nextDouble()*(100-1))+1; //random number between 1 and 100
			aux = (int)(randDouble*100);
			randTruncatedDouble = aux/100d;
			Student student = new Student(studentNameList[i], randTruncatedDouble, i);
			gradebook.updateStudent(student); //adds random student to gradebook
		}
		//***************************************************************************
		//Sort by Grade and Print to Console
		
		System.out.println("Sorting Gradebook by Grade");
		System.out.println("Printing Gradebook:");
		gradebook.sortGradebook("GRADE");
		printStudentList(gradebook);
		
		//***************************************************************************
		//Sort by Name and Print to Console
		
		System.out.println("Sorting Gradebook by Name");
		System.out.println("Printing Gradebook:");
		gradebook.sortGradebook("NAME");
		printStudentList(gradebook);
		
		//***************************************************************************

		
		
		
	}
}
