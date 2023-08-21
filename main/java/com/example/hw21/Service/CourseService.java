package com.example.hw21.Service;

import com.example.hw21.ApiResponse.ApiException;
import com.example.hw21.Model.Course;
import com.example.hw21.Model.Teacher;
import com.example.hw21.Repository.CourseRepository;
import com.example.hw21.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    public List<Course> getAllCourses(){
    return courseRepository.findAll();
    }


    public void addCourse(Course course){
        courseRepository.save(course);
    }


    public void updateCourse(Course course, Integer id){
        Course course1 = courseRepository.findCourseById(id);

        if(course1 == null){
            throw new ApiException("wrong id");
        }

        course1.setName(course.getName());
        courseRepository.save(course1);

    }

    public void deleteCourse(Integer id){
        Course course = courseRepository.findCourseById(id);

        if(course == null){
            throw new ApiException("wrong id");
        }
        courseRepository.delete(course);
    }


    public void assaignCourseToTeacher(Integer teacher_id,Integer course_id){
        Teacher teacher= teacherRepository.getTeachersById(teacher_id);

        Course course = courseRepository.findCourseById(course_id);

        if(course == null || teacher == null){
            throw new ApiException("course or teacher is wrong id");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);

    }

    public String getTeacherName(Integer id){
        Course course = courseRepository.findCourseById(id);

        if(course == null){
            throw new ApiException("wrong id");
        }

        if(course.getTeacher() == null){
            throw new ApiException("there's no teacher took the course");
        }
        return course.getTeacher().getName();
    }




}
