package com.example.courseapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.courseapi.model.Course;
import com.example.courseapi.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService service;

    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course){
        Course c=service.addCourse(course);
        return new ResponseEntity<>(c,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getCourses(){
        return new ResponseEntity<>(service.getCourses(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable int id){
        Course c=service.getCourseById(id);
        if(c==null){
            return new ResponseEntity<>("Course Not Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(c,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id,@RequestBody Course course){
        Course c=service.updateCourse(id,course);
        if(c==null){
            return new ResponseEntity<>("Course Not Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(c,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id){
        boolean deleted=service.deleteCourse(id);
        if(!deleted){
            return new ResponseEntity<>("Course Not Found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Course Deleted",HttpStatus.OK);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> searchCourse(@PathVariable String title){
        return new ResponseEntity<>(service.searchCourse(title),HttpStatus.OK);
    }
}            