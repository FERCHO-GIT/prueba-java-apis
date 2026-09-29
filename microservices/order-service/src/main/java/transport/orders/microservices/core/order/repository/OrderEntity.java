package transport.orders.microservices.core.order.repository;

import java.time.ZonedDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID orderId;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Status status;

    @Column(nullable=false)
    private String origin;

    @Column(nullable=false)
    private String destination;

    @Column(nullable=false)
    private ZonedDateTime createdAt;

    @Column(nullable=false)
    private ZonedDateTime updatedAt;

    public OrderEntity() { }

    public OrderEntity(Status status, String origin, String destination, ZonedDateTime createdAt, ZonedDateTime updatedAt) {
        this.status = status;
        this.origin = origin;
        this.destination = destination;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
