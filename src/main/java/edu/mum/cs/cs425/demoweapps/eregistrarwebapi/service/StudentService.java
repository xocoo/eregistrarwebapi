package edu.mum.cs.cs425.demoweapps.eregistrarwebapi.service;

import java.rmi.StubNotFoundException;
import java.util.List;

import edu.mum.cs.cs425.demoweapps.eregistrarwebapi.exception.StudentNotFoundException;
import edu.mum.cs.cs425.demoweapps.eregistrarwebapi.model.Student;

public interface StudentService {
    public abstract Student addNewStudent(Student student);

    public abstract List<Student> getAllStudents();

    public abstract Student getStudentById(Long studentId) throws StudentNotFoundException;

    Student updatetStudent(Student updateStudent, Long studentId);

    void deleteStudentById(Long studentId);

    public abstract List<Student> getByKeyword(String keyword);
}
