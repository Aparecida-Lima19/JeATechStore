package com.jatechstore.jatechestore.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
// Indica que esta classe será embutida em outra entidade (OrderItem), formando uma chave composta
public class OrderItemPK {

    @ManyToOne
    @JoinColumn(name = "order_id")
    // Mapeia a coluna de chave estrangeira "order_id" para associação com a entidade Order
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    // Mapeia a coluna de chave estrangeira "product_id" para associação com a entidade Product
    private Product product;

    public OrderItemPK() {
    }

    // Construtor que facilita a criação direta de uma chave composta
    public OrderItemPK(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    // Importante: equals e hashCode são baseados nos dois atributos da chave composta

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItemPK that = (OrderItemPK) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(order);
        result = 31 * result + Objects.hashCode(product);
        return result;
    }
}
