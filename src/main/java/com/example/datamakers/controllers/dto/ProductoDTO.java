package com.example.datamakers.controllers.dto;
import com.example.datamakers.models.Maker;
import lombok.*;


import java.math.BigDecimal;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductoDTO {

    private Long id;
    private String name;
    private BigDecimal price; //es mas preciso
    private Maker maker;
}
