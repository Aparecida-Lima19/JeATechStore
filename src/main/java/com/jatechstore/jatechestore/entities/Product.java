package com.jatechstore.jatechestore.entities;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity // Indica que esta classe é uma entidade JPA (tabela no banco de dados)
@Table(name = "tb_product") // Define explicitamente o nome da tabela como "tb_product"
public class Product {

    @Id // Indica que o campo é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Geração automática do ID pelo banco (auto-incremento)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    // Garante que o campo 'description' possa armazenar textos longos
    private String description;

    private Double price;
    private String imgUrl;

    @ManyToMany
    @JoinTable(
            name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    // Relacionamento muitos-para-muitos entre Product e Category
    // A tabela de junção será "tb_product_category" com colunas "product_id" e "category_id"
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "id.product")
    // Um produto pode estar associado a vários itens de pedido
    // Mapeado pelo atributo "product" dentro do ID embutido (OrderItemPK) da entidade OrderItem
    private Set<OrderItem> items = new HashSet<>();

    public Product() {
    }

    public Product(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    // Getters e Setters padrão

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public List<Order> getOrders() {
        // Método de conveniência para obter a lista de pedidos associados a este produto
        return items.stream().map(x -> x.getOrder()).toList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
