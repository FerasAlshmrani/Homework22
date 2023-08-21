package com.example.hw21.Service;

import com.example.hw21.AddressDTO.AddressDTO;
import com.example.hw21.ApiResponse.ApiException;
import com.example.hw21.Model.Address;
import com.example.hw21.Model.Teacher;
import com.example.hw21.Repository.AddressRepository;
import com.example.hw21.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;
    public void addAddress(AddressDTO addressDTO){
        Teacher teacher = teacherRepository.getTeachersById(addressDTO.getTeacher_id());

        if(teacher == null){
            throw new ApiException("wrong id");
        }
        Address address = new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);

        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO,Integer id){
        Address address = addressRepository.getAddressById(id);
        Teacher teacher = teacherRepository.getTeachersById(addressDTO.getTeacher_id());

        if(address == null){
            throw new ApiException("Wrong addressId");
        }
        if(addressDTO == null){
            throw new ApiException("Wrong TeacherID");
        }
        address.setTeacher(teacher);
        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());

        addressRepository.save(address);
    }

    public void deleteAddress(Integer id){
        Address address = addressRepository.getAddressById(id);

        if(address == null ){
            throw new ApiException("wrong addressID");
        }
        AddressDTO addressDTO = new AddressDTO(address.getTeacher().getId(),address.getArea(),address.getStreet(),address.getBuildingNumber());
        Teacher teacher = teacherRepository.getTeachersById(addressDTO.getTeacher_id());
        if(teacher.getAddress() == null){
            throw new ApiException("this teacherID dont have details to delete");
        }

        teacher.setAddress(null);
        teacherRepository.save(teacher);
        addressRepository.delete(address);
    }


}
