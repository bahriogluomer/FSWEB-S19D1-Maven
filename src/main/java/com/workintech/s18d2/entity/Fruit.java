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
@Table(name = "fruits", schema = "grocery")
public class Fruit {
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
    @Column(name = "type")
    @NotNull(message = "Fruit type cannot be null")
    @Enumerated(EnumType.STRING)
    private FruitType fruitType;
}
