package com.example.datamakers.controllers;


import com.example.datamakers.controllers.dto.ProductoDTO;
import com.example.datamakers.models.Product;
import com.example.datamakers.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/products")
public class ProductController {
    @Autowired
    public IProductService productService;

    @GetMapping("/find/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value="id") Long id){
        Optional<Product> product0 = productService.findById(id);
        if(product0.isPresent()){
            Product producto = product0.get();
            ProductoDTO productoDTO = ProductoDTO.builder()
                    .id(producto.getId())
                    .name(producto.getName())
                    .maker(producto.getMaker())
                    .price(producto.getPrice()).build();
          return ResponseEntity.ok(productoDTO);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/findAll")
    public ResponseEntity<Object> findAll(){
        List<ProductoDTO> productoDTOList = productService.findAll()
                .stream()
                .map(producto -> ProductoDTO.builder()
                        .name(producto.getName())
                        .id(producto.getId())
                        .price(producto.getPrice())
                        .maker(producto.getMaker()).build()).toList();
        return ResponseEntity.ok(productoDTOList);
    }

    @PostMapping("/save")
    public void save(@RequestBody ProductoDTO productoDTO){
        if(productoDTO.getMaker() == null || productoDTO.getName().isBlank()||productoDTO.getPrice()==null){
            return;
        }
        productService.save(Product.builder()
                .name(productoDTO.getName())
                .price(productoDTO.getPrice())
                .maker(productoDTO.getMaker()).build());

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@RequestBody ProductoDTO productoDTO, @PathVariable Long id){
            Optional<Product> product0 = productService.findById(id);
            if(product0.isPresent()){
                Product product = product0.get();
                product.setName(productoDTO.getName());
                product.setPrice(productoDTO.getPrice());
                product.setMaker(productoDTO.getMaker());

                productService.save(product);
                return ResponseEntity.ok("Producto Actualizado");
            }
            return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/detele/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        if(id!=null){
            productService.deleteById(id);
            return ResponseEntity.ok("Registro eliminado");
        }
        return ResponseEntity.badRequest().build();
    }

}
