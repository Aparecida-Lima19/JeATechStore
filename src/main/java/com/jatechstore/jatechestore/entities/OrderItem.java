package com.jatechstore.jatechestore.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity // Indica que esta classe é uma entidade JPA (representa uma tabela no banco de dados)
@Table(name = "tb_order_item") // Define explicitamente o nome da tabela como "tb_order_item"
public class OrderItem {

    @EmbeddedId
    // Indica que este campo é uma chave primária composta (EmbeddedId), que agrupa múltiplos atributos em uma única chave primária
    private OrderItemPK id = new OrderItemPK();

    private Integer quantity; // Quantidade de produtos

    private Double price; // Preço unitário do produto

    public OrderItem() {
    }

    // Construtor com parâmetros, facilita a criação de um OrderItem associando Order e Product diretamente
    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    // Métodos de acesso indiretos à chave composta (Order e Product)

    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // Implementação de equals e hashCode com base na chave composta (id), como recomendado em entidades JPA

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
