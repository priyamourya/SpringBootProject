package com.springrest.springrest.services;

import com.springrest.springrest.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class courseServiceImpl implements CourseService {
    List<Course> list;

    public courseServiceImpl(){
        list=new ArrayList<>();
        list.add(new Course(145, "Java Course", "basic Java"));
        list.add(new Course(146, "Spring boot Course", "basic spring boot"));
    }

    @Override
    public List<Course> getCourses() {
        return list;
    }
    @Override
    public Course getCourse(long courseId) {
        Course sCourse=null;
        for(Course course : list){
            if(course.getId()==courseId){
                sCourse=course;
            }
        }
        return sCourse;
    }
    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }
    @Override
    public Course updateCourse(Course course) {
        for(Course courseList : list){
            if(courseList.getId()==course.getId()){
                courseList.setTitle(course.getTitle());
                courseList.setDescription(course.getDescription());
            }
        }
        return course;
    }
}
