package com.jatechstore.jatechestore.entities;

// Enum que representa os possíveis status de um pedido
public enum OrderStatus {

    WAITING_PAYMENT,  // Aguardando pagamento
    PAID,             // Pago
    SHIPPED,          // Enviado
    DELIVERED,       // Entregue
    CANCELED;        // Cancelado
}
