package com.insurance.demo.service;

import com.insurance.demo.dto.PetDto;
import com.insurance.demo.entity.Pet;
import com.insurance.demo.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PetService {
    private final PetRepository petRepository;

    public List<PetDto> findAll() {
        return petRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public PetDto findById(Long id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("반려동물을 찾을 수 없습니다: " + id));
        return convertToDto(pet);
    }

    @Transactional
    public PetDto save(PetDto petDto) {
        Pet pet = convertToEntity(petDto);
        pet = petRepository.save(pet);
        return convertToDto(pet);
    }

    @Transactional
    public PetDto update(Long id, PetDto petDto) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("반려동물을 찾을 수 없습니다: " + id));
        
        pet.setName(petDto.getName());
        pet.setSpecies(petDto.getSpecies());
        pet.setAge(petDto.getAge());
        pet.setBreed(petDto.getBreed());
        
        return convertToDto(pet);
    }

    @Transactional
    public void delete(Long id) {
        petRepository.deleteById(id);
    }

    private PetDto convertToDto(Pet pet) {
        PetDto dto = new PetDto();
        dto.setId(pet.getId());
        dto.setName(pet.getName());
        dto.setSpecies(pet.getSpecies());
        dto.setAge(pet.getAge());
        dto.setBreed(pet.getBreed());
        return dto;
    }

    private Pet convertToEntity(PetDto dto) {
        Pet pet = new Pet();
        pet.setId(dto.getId());
        pet.setName(dto.getName());
        pet.setSpecies(dto.getSpecies());
        pet.setAge(dto.getAge());
        pet.setBreed(dto.getBreed());
        return pet;
    }
} 