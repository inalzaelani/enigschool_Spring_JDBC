package com.springCore.repository;

import com.springCore.model.Course;
import com.springCore.model.mapper.CourseMapper;
import com.springCore.utils.IRandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
@Repository
public class CourseRepository implements ICourseRepository{

    @Autowired
    @Qualifier("uuid")
    private IRandomStringGenerator randomStringGenerator;
    private JdbcTemplate jdbcTemplate;

    private final  String SQL_GET_ALL = "select * from mst_course";
    private final String SQL_INSERT_COURSE = "insert into mst_course values(?,?,?,?)";
    private final String SQL_FIND_BY_ID = "select * from mst_course where course_id =?";
    private final String SQL_UPDATE_COURSE = "update mst_course set title = ?, description =?, link =? where course_id = ?";
    private final String SQL_DELETE_COURSE = "delete from mst_course where course_id =?";



    @Autowired
    public CourseRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Course> getAll() throws Exception {

        try {
            return  jdbcTemplate.query(SQL_GET_ALL, new CourseMapper());
        }catch (DataAccessException e){
            System.out.println(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Course create(Course course) throws Exception {
        try{
            course.setCourseId(randomStringGenerator.random());
            int result = jdbcTemplate.update(SQL_INSERT_COURSE, course.getCourseId(),course.getTitle(),course.getLink(),course.getDescription());
            if(result<= 0){
                throw  new Exception("Failed Insert Course");
            }
            return course;
        }catch (DataAccessException e){
            throw new RuntimeException();
        }
    }

    @Override
    public Optional<Course> findById(String id) throws Exception {

        try {
            Course course = jdbcTemplate.queryForObject(SQL_FIND_BY_ID,new CourseMapper(), new Object[]{id});
            return Optional.ofNullable(course);
        }catch (DataAccessException e){
            throw new Exception("Failed get Course");
        }
    }

    @Override
    public void update(Course course, String id) throws Exception {
            try{
                jdbcTemplate.update(SQL_UPDATE_COURSE,course.getTitle(),course.getDescription(),course.getLink(),id);
            }catch (DataAccessException e){
                throw new Exception("Failed to update course");
            }
    }

    @Override
    public void delete(String id) throws Exception {
        try{
            jdbcTemplate.update(SQL_DELETE_COURSE,id);
        }catch (DataAccessException e){
            throw  new Exception("Failed to delete course");
        }
    }
}
