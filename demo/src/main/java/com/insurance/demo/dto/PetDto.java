package com.insurance.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PetDto {
    private Long id;
    
    @NotBlank(message = "반려동물 이름은 필수입니다")
    private String name;
    
    @NotBlank(message = "동물 종류는 필수입니다")
    private String species;
    
    @NotNull(message = "나이는 필수입니다")
    @Min(value = 0, message = "나이는 0보다 작을 수 없습니다")
    private Integer age;
    
    @NotBlank(message = "품종은 필수입니다")
    private String breed;
} 