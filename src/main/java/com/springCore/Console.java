package com.springCore;

import com.springCore.model.Course;
import com.springCore.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Console implements CommandLineRunner {
    @Autowired
    ICourseService courseService;

    @Override
    public void run(String... args) throws Exception {
//        List<Course> courses = courseService.list();
//        Course springCourse = new Course();
//        springCourse.setCourseId("123");
//        springCourse.setTitle("Spring FrameWork");
//        springCourse.setDescription("Spring IoC");
//        springCourse.setLink("https://www.enigmacamp.com/blog/spring");
//
//        courseService.create(springCourse);
//
//        Course golangCourse = new Course();
//        golangCourse.setCourseId("124");
//        golangCourse.setTitle("GoLang");
//        golangCourse.setDescription("Type Interface");
//        golangCourse.setLink("https://www.enigmacamp.com/blog/golang");
//
//        courseService.create(golangCourse);




//        for(Course course : courses){
//            System.out.println(course);
//        }
    }
}