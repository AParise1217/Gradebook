//Imports
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



/*
 * StudentDataImpl.java
 * 
 * @author Andrew Parise
 * @since 2/3/2016
 * 
 * <p>
 * Concrete class that implements StudentDataInterf.java interface
 * 
 */
public class StudentDataImpl implements StudentDataInterf{
	List<Student> gradebook; //list containing student objects
	
	//constructor
	public StudentDataImpl(){
		
		gradebook = new ArrayList<Student>();
		//TestData - moved to main() of DataAccessor.java 2/3/16
//		Student student0 = new Student("Andrew", 95.0, 0);
//		Student student1 = new Student("Michael",70.0, 1);
//		Student student2 = new Student("Jimmy", 85.0, 2);
//		gradebook.add(student0);
//		gradebook.add(student1);
//		gradebook.add(student2);
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
		
		
		//Below implementation was for searching by Name
//		name = name.toUpperCase(); //convert input to all uppercase
//		
//		for(Student iterVal : gradebook){ //iterates over gradebook list
//			if(iterVal.getName().contains(name)){ //if Student object contains name with value searching for
//				return iterVal;
//			}
//		}
//		return null;
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		
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
	public static Comparator<Student> gradeCompare = new Comparator<Student>() {
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
	
	public static Comparator<Student> nameCompare = new Comparator<Student>(){
		//Sorts the gradebook by name
		public int compare(Student stu1, Student stu2){
			String Student1Name = stu1.getName().toUpperCase();
			String Student2Name = stu2.getName().toUpperCase();
			
			return Student1Name.compareTo(Student2Name);
		}
	};
	
	
	@Override
	public void sortGradebook(String sortBy) {
		// TODO Auto-generated method stub
		sortBy = sortBy.toUpperCase();
		if(sortBy == "NAME"){
			//sorts the gradebook by name
			Collections.sort(gradebook, StudentDataImpl.nameCompare);
		}
		if(sortBy == "GRADE"){
			//sorts the gradebook by grade
			Collections.sort(gradebook, StudentDataImpl.gradeCompare);
		}
	}
	
}
