package com.example.datamakers.services;

import com.example.datamakers.models.Maker;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IMakerService {

    Optional<Maker> findById(Long id);
    List<Maker> findAll();
    ResponseEntity<Object> save(Maker maker);
    void deleteById(Long id);
}
