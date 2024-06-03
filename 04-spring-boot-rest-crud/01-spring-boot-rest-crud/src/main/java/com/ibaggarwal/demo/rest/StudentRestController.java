package com.ibaggarwal.demo.rest;

import com.ibaggarwal.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Nupur", "Saboo"));
        theStudents.add(new Student("Paprika", "Jain"));
        theStudents.add(new Student("Bhavya", "Aggarwal"));
    }

    @GetMapping("/students")
    public List<Student> getStudent(){
        return theStudents;
    }

    @GetMapping("/students/{studentID}")
    public Student getStudent(@PathVariable int studentID){
        if(studentID >= theStudents.size() || studentID < 0){
            throw new StudentNotFoundException("Student ID not found - " + studentID);
        }
        return theStudents.get(studentID);
    }


}
