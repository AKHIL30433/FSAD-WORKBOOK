package com.example.courseapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.courseapi.model.Course;

@Service
public class CourseService {

    List<Course> courselist=new ArrayList<>();

    public Course addCourse(Course course){
        courselist.add(course);
        return course;
    }

    public List<Course> getCourses(){
        return courselist;
    }

    public Course getCourseById(int id){
        for(Course c:courselist){
            if(c.getCourseId()==id){
                return c;
            }
        }
        return null;
    }

    public Course updateCourse(int id,Course course){
        for(Course c:courselist){
            if(c.getCourseId()==id){
                c.setTitle(course.getTitle());
                c.setDuration(course.getDuration());
                c.setFee(course.getFee());
                return c;
            }
        }
        return null;
    }

    public boolean deleteCourse(int id){
        for(Course c:courselist){
            if(c.getCourseId()==id){
                courselist.remove(c);
                return true;
            }
        }
        return false;
    }

    public List<Course> searchCourse(String title){
        List<Course> result=new ArrayList<>();
        for(Course c:courselist){
            if(c.getTitle().equalsIgnoreCase(title)){
                result.add(c);
            }
        }
        return result;
    }
}