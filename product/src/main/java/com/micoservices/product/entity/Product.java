package com.micoservices.product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Entity
@Table (name ="product")
@RequiredArgsConstructor
public class Product {
    @Id
    @Getter
    @NonNull
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Getter
    @NonNull
    private String name;
    @Getter
    @Setter
    @NonNull
    private int price;
    @Getter
    @Setter
    @NonNull
    private String description;
    @Getter
    @Setter
    @NonNull
    private int quantity;
}
