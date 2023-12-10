package com.example.datamakers.services.impl;

import com.example.datamakers.models.Maker;
import com.example.datamakers.persistence.IMakerDAO;
import com.example.datamakers.services.IMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MakerServiceImpl implements IMakerService {

    @Autowired
    private IMakerDAO makerDAO;

    @Override
    public Optional<Maker> findById(Long id) {
        return makerDAO.findById(id);
    }

    @Override
    public List<Maker> findAll() {
        return makerDAO.findAll();
    }

    @Override
    public ResponseEntity<Object> save(Maker maker) {
        makerDAO.save(maker);
        return null;
    }

    @Override
    public void deleteById(Long id) {
        makerDAO.deleteById(id);
    }
}
