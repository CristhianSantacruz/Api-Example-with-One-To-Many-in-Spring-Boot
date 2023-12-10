package com.example.datamakers.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_products")
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private BigDecimal price; //es mas preciso


    @ManyToOne
    @JoinColumn(name="maker_forkey")
    @JsonIgnore
    private Maker maker;

}
