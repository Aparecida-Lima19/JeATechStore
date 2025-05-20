package com.jatechstore.jatechestore.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity // Indica que esta classe é uma entidade JPA (tabela no banco de dados)
@Table(name = "tb_categoty") // Define o nome da tabela como "tb_categoty"
public class Category {

    @Id // Indica que o campo é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID pelo banco (auto-incremento)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();

    public Category() {
    }


    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }
}
