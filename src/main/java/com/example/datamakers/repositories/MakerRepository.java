package com.example.datamakers.repositories;

import com.example.datamakers.models.Maker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;


@Repository
public  interface MakerRepository extends JpaRepository<Maker,Long> {


}
