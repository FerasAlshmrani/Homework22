package com.example.hw21.Controller;

import com.example.hw21.ApiResponse.ApiResponse;
import com.example.hw21.Model.Teacher;
import com.example.hw21.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getAllTeachers(){
        return ResponseEntity.status(200).body(teacherService.getAllTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeatcher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher Added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@RequestBody @Valid Teacher teacher,@PathVariable Integer id){
        teacherService.updateTeacher(teacher, id);
        return ResponseEntity.status(200).body(new ApiResponse("teacher Updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("teacher Deleted"));
    }

    @GetMapping("/get-detail/{id}")
    public ResponseEntity getDetail(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.getAllTeacherDetail(id));
    }
}
