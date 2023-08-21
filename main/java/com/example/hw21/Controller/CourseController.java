package com.example.hw21.Controller;

import com.example.hw21.ApiResponse.ApiResponse;
import com.example.hw21.Model.Course;
import com.example.hw21.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/course")
public class CourseController {

    private final CourseService courseService;


    @GetMapping("/get")
    public ResponseEntity getAllCourses(){
        return ResponseEntity.status(200).body(courseService.getAllCourses());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course Added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@RequestBody @Valid Course course,@PathVariable Integer id){
        courseService.updateCourse(course, id);
        return ResponseEntity.status(200).body(new ApiResponse("Course Updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("Course Deleted"));
    }

    @PutMapping("/{teacher_id}/assign/{course_id}")
    public ResponseEntity assignCourseToTeacher(@PathVariable Integer teacher_id,@PathVariable Integer course_id){

        courseService.assaignCourseToTeacher(teacher_id, course_id);
        return ResponseEntity.status(200).body(new ApiResponse("assign added"));
    }

    @GetMapping("/get-teacher-name-by-course/{id}")
    public ResponseEntity getDetail(@PathVariable Integer id){
        return ResponseEntity.status(200).body(courseService.getTeacherName(id));
    }
}
