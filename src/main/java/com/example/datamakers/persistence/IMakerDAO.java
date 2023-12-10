package com.example.datamakers.persistence;

import com.example.datamakers.models.Maker;
import java.util.*;
public interface IMakerDAO {

    Optional<Maker> findById(Long id);
    List<Maker>  findAll();
    void save(Maker maker);
    void deleteById(Long id);
}
