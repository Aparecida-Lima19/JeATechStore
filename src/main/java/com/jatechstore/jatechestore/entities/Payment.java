package com.jatechstore.jatechestore.entities;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity // Indica que esta classe é uma entidade JPA (representa uma tabela no banco de dados)
@Table(name = "tb_payment") // Define explicitamente o nome da tabela como "tb_payment"
public class Payment {

    @Id // Define o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Estratégia de geração automática do ID pelo banco (auto-incremento)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    // Armazena a data/hora sem fuso horário, recomendado para compatibilidade com bancos como PostgreSQL
    private Instant moment;

    @OneToOne
    @MapsId
    // Indica que a chave primária desta entidade também é chave estrangeira para a entidade Order
    // Garante que Payment e Order compartilham o mesmo ID
    private Order order;

    public Payment() {
    }

    // Construtor com todos os atributos
    public Payment(Long id, Instant moment, Order order) {
        this.id = id;
        this.moment = moment;
        this.order = order;
    }

    // Getters e Setters padrão

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

    // Implementação de equals e hashCode baseada no id, conforme recomendado em entidades JPA

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
