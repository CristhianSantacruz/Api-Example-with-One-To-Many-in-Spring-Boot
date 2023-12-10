package com.example.datamakers.controllers;


import com.example.datamakers.controllers.dto.MakerDTO;
import com.example.datamakers.models.Maker;
import com.example.datamakers.services.IMakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/makers")
public class MakerController {
    @Autowired
    private IMakerService makerService;

    @GetMapping("/find/{id}")
    public ResponseEntity<Object> findById(
            @PathVariable(value="id") Long id){
        Optional<Maker> makerOptional = makerService.findById(id);
        if(makerOptional.isPresent()){
            Maker maker = makerOptional.get();
            MakerDTO makerDTO = MakerDTO.builder()
                    .id(maker.getId())
                    .name(maker.getName())
                    .dni(maker.getDni())
                    .products(maker.getProducts())
                    .build();
            return ResponseEntity.ok(makerDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<Object> findAll(){
        List<MakerDTO> makerDTOList = makerService.findAll()
                .stream()
                .map(maker -> MakerDTO.builder()
                                .id(maker.getId())
                                .name(maker.getName())
                                .dni(maker.getDni())
                                .products(maker.getProducts()).build()).toList();



        return ResponseEntity.ok(makerDTOList);
    }
    @PostMapping("/save")
    public void save(@RequestBody  MakerDTO makerDTO){
        //makerDTO viene en el cuerpo de la peticion @requestbody
        if(makerDTO.getName().isBlank()){
            return;
        }
        makerService.save(Maker.builder()
                .name(makerDTO.getName())
                .dni(makerDTO.getDni())
                .build());
    }
    @PutMapping("update/{id}")
    public void update(@PathVariable Long id,@RequestBody  MakerDTO makerDTO){

        Optional<Maker> makerO = makerService.findById(id);
        if(makerO.isPresent()){
            Maker maker = makerO.get();
            maker.setName(makerDTO.getName());
            makerService.save(maker);
        }

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){

        if(id!=null){
            makerService.deleteById(id);
          return ResponseEntity.ok("Registro Eliminado");
        }
        return ResponseEntity.badRequest().build();
    }

}
