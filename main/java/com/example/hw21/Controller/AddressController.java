package com.example.hw21.Controller;

import com.example.hw21.AddressDTO.AddressDTO;
import com.example.hw21.ApiResponse.ApiResponse;
import com.example.hw21.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address Added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateAddress(@RequestBody @Valid AddressDTO addressDTO,@PathVariable Integer id){
        addressService.updateAddress(addressDTO, id);
        return ResponseEntity.status(200).body(new ApiResponse("Address Updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body(new ApiResponse("Address Deleted"));
    }

}
