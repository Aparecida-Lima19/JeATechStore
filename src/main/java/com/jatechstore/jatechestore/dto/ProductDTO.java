package com.jatechstore.jatechestore.dto;

import com.jatechstore.jatechestore.entities.Product;

public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    public ProductDTO(){
        // Construtor padrão necessário para frameworks que utilizam reflexão (ex.: Jackson, JPA, etc.)
    }

    public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
        // Construtor completo, útil para criar DTOs manualmente
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductDTO(Product entity) {
        // Construtor que instancia o DTO diretamente a partir de uma entidade Product
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();
    }

    // Getters para expor os dados do DTO (não há setters pois o DTO é geralmente imutável)

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
