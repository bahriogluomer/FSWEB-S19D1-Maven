package com.workintech.s18d2.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vegetables", schema = "grocery")
public class Vegetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    @NotNull(message = "Name cannot be null")
    @Size(min = 3, max = 45, message = "Name must be between 3 and 45 characters")
    private String name;
    @Column(name = "price")
    @DecimalMin(value="10.0", message = "Price must be at least 10.0")
    private Double price;
    @Column(name = "is_grown_on_tree")
    @NotNull(message = "Is grown on tree cannot be null")
    private Boolean isGrownOnTree;
}

