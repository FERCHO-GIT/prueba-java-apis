package transport.orders.microservices.core.order.assign.repository;

import java.time.ZonedDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="order_assign")
public class OrderAssignEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID orderAssignId;

    @Column(nullable=false)
    private UUID orderId;

    @Column(nullable=false)
    private UUID driverId;

    private String orderAssignFile;

    private String orderAssignImage;

    @Column(nullable=false)
    private ZonedDateTime createdAt;

    public OrderAssignEntity() { }

    public OrderAssignEntity(UUID orderId, UUID driverId, ZonedDateTime createdAt) {
        this.orderId = orderId;
        this.driverId = driverId;
        this.createdAt = createdAt;
    }

    public UUID getOrderAssignId() {
        return orderAssignId;
    }

    public void setOrderAssignId(UUID orderAssignId) {
        this.orderAssignId = orderAssignId;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getDriverId() {
        return driverId;
    }

    public void setDriverId(UUID driverId) {
        this.driverId = driverId;
    }

    public String getOrderAssignFile() {
        return orderAssignFile;
    }

    public void setOrderAssignFile(String orderAssignFile) {
        this.orderAssignFile = orderAssignFile;
    }

    public String getOrderAssignImage() {
        return orderAssignImage;
    }

    public void setOrderAssignImage(String orderAssignImage) {
        this.orderAssignImage = orderAssignImage;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
