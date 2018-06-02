package com.parisesoftware.output;

import com.parisesoftware.dao.IStudentDataService;
import com.parisesoftware.model.Student;

public class StudentDataConsoleWriter implements IStudentDataWriter {

    @Override
    public void output(IStudentDataService gradebook) {
        for(Student student : gradebook.getAllStudents()) {
            System.out.println("Student: [ID Number : " + student.getIdNum()
                    + ", Name : " + student.getName() +
                    ", Grade: " + student.getGrade() + "]");
        }
    }
}
