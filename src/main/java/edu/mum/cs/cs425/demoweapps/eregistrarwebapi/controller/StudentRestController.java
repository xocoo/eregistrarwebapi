package edu.mum.cs.cs425.demoweapps.eregistrarwebapi.controller;

import java.rmi.StubNotFoundException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cs.cs425.demoweapps.eregistrarwebapi.exception.StudentNotFoundException;
import edu.mum.cs.cs425.demoweapps.eregistrarwebapi.model.Student;
import edu.mum.cs.cs425.demoweapps.eregistrarwebapi.service.StudentService;

@RestController
@RequestMapping(value = { "/eregistrar/api/student" })
public class StudentRestController {
    @Autowired
    StudentService studentService;

    @GetMapping(value = { "list" })
    public ResponseEntity<List<Student>> listStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping(value = { "/get/{studentId}" })
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) throws StudentNotFoundException {
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }

    @PostMapping(value = { "/register" })
    public ResponseEntity<Student> addNewStudent(@Valid @RequestBody Student student) {
        return new ResponseEntity<>(studentService.addNewStudent(student), HttpStatus.CREATED);
    }

    @PutMapping(value = { "/update/{studentId}" })
    public ResponseEntity<?> updateStudent(@Valid @RequestBody Student student, @PathVariable Long studentId)
            throws StudentNotFoundException {
        Student updateStudent = studentService.getStudentById(studentId);
        if (updateStudent == null)
            return new ResponseEntity<>("Student ID is invalid", HttpStatus.NOT_FOUND);
        studentService.updatetStudent(student, studentId);
        return new ResponseEntity<>("Student has been updated", HttpStatus.OK);
    }

    @DeleteMapping(value = { "/delete/{studentId}" })
    public ResponseEntity<String> deleteStudent(@PathVariable Long studentId) throws StudentNotFoundException {
        studentService.deleteStudentById(studentId);
        return new ResponseEntity<>("Student deleted ID: " + studentId, HttpStatus.OK);
    }
}
