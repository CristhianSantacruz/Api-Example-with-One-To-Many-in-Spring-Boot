package com.example.datamakers.persistence.impl;

import com.example.datamakers.models.Maker;
import com.example.datamakers.persistence.IMakerDAO;
import com.example.datamakers.repositories.MakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;
@Component
public class MakerDAOImpl implements IMakerDAO {
    @Autowired
    private MakerRepository makerRepository;


    @Override
    public Optional<Maker> findById(Long id) {
        return makerRepository.findById(id);
    }

    @Override
    public List<Maker> findAll() {
        return makerRepository.findAll();
    }

    @Override
    public void save(Maker maker) {
        makerRepository.save(maker);
    }

    @Override
    public void deleteById(Long id) {
        makerRepository.deleteById(id);
    }
}
