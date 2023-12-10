package com.example.datamakers.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.*;
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_MAKERS")
public class Maker {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private Long id;
    private String name;
    private String dni;

    @OneToMany(mappedBy = "maker",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JsonIgnore
    private List<Product> products = new ArrayList<>();

}
