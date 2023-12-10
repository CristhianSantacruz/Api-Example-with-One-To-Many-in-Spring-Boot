package com.example.datamakers.controllers.dto;

import com.example.datamakers.models.Product;
import lombok.*;


import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MakerDTO {

    private long id;
    private String name;
    private String dni;
    private List<Product> products = new ArrayList<>();

}
