package com.jatechstore.jatechestore.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity // Indica que esta classe é uma entidade JPA (tabela no banco de dados)
@Table(name = "tb_order") // Define o nome da tabela como "tb_order"
public class Order {

    @Id // Indica que o campo é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID pelo banco (auto-incremento)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE") // Usa TIMESTAMP sem fuso horário (compatível com PostgreSQL)
    private Instant moment;
    private OrderStatus status;

    @ManyToOne // Muitos pedidos podem estar associados a um único cliente
    @JoinColumn(name = "client_id") // Define a chave estrangeira com o nome "client_id"
    private User client;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order() {
    }

    public Order(Long id, Instant moment, OrderStatus status, User client, Payment payment) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.payment = payment;
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
    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    public User getClient() {
        return client;
    }
    public void setClient(User client) {
        this.client = client;
    }
    public Payment getPayment() {
        return payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
