package com.springCore.service;

import com.springCore.model.Course;

import java.util.List;
import java.util.Optional;

public interface ICourseService {
    public List<Course> list();

    public Course create(Course course);
    void findById(String id);

    public void update(Course course, String id);

    public  void delete(String id);
}
