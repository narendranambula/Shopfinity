package com.narendra.ecomproj.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    public String description;
    private int price;
    private String category;
    private String brand;
    private Date releasedate;
    private boolean productavailable;
    private int stockquantity;
    private String imageName;
    private String imageType;

    @Lob
    private byte[] imageData;

}
