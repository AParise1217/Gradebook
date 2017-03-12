//Imports
import java.util.List;

/*
 * StudentDataInterf.java
 * 
 * @author Andrew Parise
 * @since 1/26/2016
 * 
 * <p>
 * Data Access Interface
 * 
 */
public interface StudentDataInterf {
	public List<Student> getAllStudents(); //returns a list of all students
	public Student getStudent(int idNum); //searches through gradebook by name to return student object
	public void updateStudent(Student student); //updates the grade value for given student
	public void deleteStudent(Student student); //removes student from gradebook
	public void sortGradebook(String sortBy); //sorts the gradebook based off of either name or grade
}
