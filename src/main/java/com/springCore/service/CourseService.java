package com.springCore.service;

import com.springCore.model.Course;
import com.springCore.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService implements ICourseService{

    private ICourseRepository courseRepository;
    @Autowired
    public CourseService(ICourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> list(){
        try{
            return courseRepository.getAll();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Course create(Course course){
        try{
            return courseRepository.create(course);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    @Override
    public void findById(String id){
        try {
            courseRepository.findById(id);
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    public void update(Course course, String id){
        try {
             courseRepository.update(course,id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public  void delete(String id){
        try{
            courseRepository.delete(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
