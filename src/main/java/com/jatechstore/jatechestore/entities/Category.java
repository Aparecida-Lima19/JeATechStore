package com.jatechstore.jatechestore.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity // Indica que esta classe é uma entidade JPA (representa uma tabela no banco de dados)
@Table(name = "tb_categoty")
public class Category {

    @Id // Define o campo "id" como chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o valor do ID será gerado automaticamente pelo banco
    private int id;

    private String name; // Nome da categoria

    @ManyToMany(mappedBy = "categories")
    // Define um relacionamento muitos-para-muitos com a entidade Product
    // "mappedBy" indica que o lado responsável pela relação é o atributo "categories" da entidade Product
    private Set<Product> products = new HashSet<>();
    // Utiliza Set para garantir que não existam produtos duplicados na coleção

    // Construtor padrão (obrigatório para JPA)
    public Category() {
    }

    // Construtor com parâmetros
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
    // Não possui setter pois geralmente não se substitui o conjunto inteiro, mas sim adiciona ou remove elementos


    // Implementação de equals para comparar objetos pela chave primária "id"
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;
        return id == category.id;
    }

    // Implementação de hashCode consistente com equals
    @Override
    public int hashCode() {
        return id;
    }
}
