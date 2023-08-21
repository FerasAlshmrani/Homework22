package com.example.hw21.AddressDTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class AddressDTO {

    private Integer teacher_id;
    @NotEmpty(message = "area should not be empty")
    private String area;

    @NotEmpty(message = "street should not be empty")
    private String street;
    @NotNull(message = "buildingNumber should not be null")
    private Integer buildingNumber;

}
