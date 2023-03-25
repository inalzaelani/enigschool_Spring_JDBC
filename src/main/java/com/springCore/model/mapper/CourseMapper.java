package com.springCore.model.mapper;

import com.springCore.model.Course;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseMapper implements RowMapper<Course> {
    @Override
    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
        Course course = new Course();
        course.setCourseId(rs.getString("course_id"));
        course.setTitle(rs.getString("title"));
        course.setLink(rs.getString("link"));
        course.setDescription(rs.getString("description"));

        return course;
    }
}
