package transport.orders.microservices.core.order.compose.dto;

import java.time.ZonedDateTime;

public class OrderResponseDTO {
    private String status;
    private String origin;
    private String destination;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public OrderResponseDTO(String status, String origin, String destination, ZonedDateTime createdAt, ZonedDateTime updatedAt) {
        this.status = status;
        this.origin = origin;
        this.destination = destination;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
