package com.insurance.demo.controller;

import com.insurance.demo.dto.PetDto;
import com.insurance.demo.service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@RequiredArgsConstructor
@Tag(name = "반려동물 API", description = "반려동물 CRUD API")
public class PetController {
    private final PetService petService;

    @GetMapping
    @Operation(summary = "전체 반려동물 조회", description = "등록된 모든 반려동물 정보를 조회합니다")
    public ResponseEntity<List<PetDto>> getAllPets() {
        return ResponseEntity.ok(petService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "반려동물 상세 조회", description = "특정 반려동물의 상세 정보를 조회합니다")
    public ResponseEntity<PetDto> getPet(@PathVariable Long id) {
        return ResponseEntity.ok(petService.findById(id));
    }

    @PostMapping
    @Operation(summary = "반려동물 등록", description = "새로운 반려동물을 등록합니다")
    public ResponseEntity<PetDto> createPet(@Valid @RequestBody PetDto petDto) {
        return ResponseEntity.ok(petService.save(petDto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "반려동물 정보 수정", description = "등록된 반려동물의 정보를 수정합니다")
    public ResponseEntity<PetDto> updatePet(@PathVariable Long id, @Valid @RequestBody PetDto petDto) {
        return ResponseEntity.ok(petService.update(id, petDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "반려동물 삭제", description = "등록된 반려동물을 삭제합니다")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.delete(id);
        return ResponseEntity.ok().build();
    }
}