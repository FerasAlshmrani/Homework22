package com.example.hw21.Service;

import com.example.hw21.ApiResponse.ApiException;
import com.example.hw21.Model.Address;
import com.example.hw21.Model.Teacher;
import com.example.hw21.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public void addTeatcher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Teacher teacher,Integer id){
        Teacher teacher1 = teacherRepository.getTeachersById(id);
        if(teacher1 == null){
            throw new ApiException("Wrong id");
        }
        teacher1.setName(teacher.getName());
        teacher1.setAddress(teacher.getAddress());
        teacher1.setAge(teacher.getAge());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setSalary(teacher.getSalary());
        teacherRepository.save(teacher1);

    }
    public void deleteTeacher(Integer id){
        Teacher teacher = teacherRepository.getTeachersById(id);
        if(teacher == null){
            throw new ApiException("Wrong id");
        }
        teacherRepository.delete(teacher);
    }

    public Address getAllTeacherDetail(Integer id){
        Teacher teacher = teacherRepository.getTeachersById(id);
        if(teacher == null){
            throw new ApiException("wrong id");
        }
        if(teacher.getAddress() == null){
            throw new ApiException("this teacher dont have details");
        }
        return teacher.getAddress();

    }




}
