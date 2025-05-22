package com.jatechstore.jatechestore.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;


@Entity // Indica que esta classe é uma entidade JPA (tabela no banco de dados)
@Table(name = "tb_payment") // Define o nome da tabela como "tb_payment"
public class Payment {

    @Id // Indica que o campo é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID pelo banco (auto-incremento)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE") //útil para manter horário local e compatível com PostgreSQL
    private Instant moment;

    @OneToOne
    @MapsId
    private Order order;

    public Payment() {
    }

    public Payment(Long id, Instant moment, Order order) {
        this.id = id;
        this.moment = moment;
        this.order = order;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
