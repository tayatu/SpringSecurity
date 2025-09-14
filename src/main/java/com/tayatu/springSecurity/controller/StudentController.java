package com.tayatu.springSecurity.controller;

import com.tayatu.springSecurity.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    List<Student> students  = new ArrayList<>(List.of(
            new Student(1, "sart", "java"),
            new Student(2, "sarthak", "python")
            ));

    @GetMapping("/token")
    public CsrfToken getcsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @PostMapping("/student")
    public void addStudent(@RequestBody Student request){
        students.add(request);
    }


}
