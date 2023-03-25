package com.springCore.repository;

import com.springCore.model.Course;
import com.springCore.utils.IRandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Repository
public class CourseArrayRepository implements ICourseRepository{
    private List<Course> courses = new ArrayList<>();

    @Autowired
    @Qualifier("int")
    private IRandomStringGenerator randomStringGenerator;

    @Override
    public List<Course> getAll() throws Exception {
        return courses;
    }

    @Override
    public Course create(Course course) throws Exception {
        course.setCourseId(randomStringGenerator.random());
        courses.add(course);
        return course;
    }

    @Override
    public Optional<Course> findById(String id) throws Exception {

        Optional<Course> findCourseId = Optional.empty();
        for (Course course : courses) {
            if (course.getCourseId().equalsIgnoreCase(id)) {
                findCourseId = Optional.of(course);
                break;
            }
        }
        return findCourseId;
    }

    @Override
    public void update(Course course, String id) throws Exception {
        for(Course course2 : courses){
            if (course2.getCourseId().equals(id)){
                course2.setTitle(course.getTitle());
                course2.setDescription(course.getDescription());
                course2.setLink(course.getLink());
                break;
            }
        }
    }

    @Override
    public void delete(String id) throws Exception {
        for(Course course2 : courses){
            if (course2.getCourseId().equals(id)){
                courses.remove(course2);
            }
            }
    }
}
