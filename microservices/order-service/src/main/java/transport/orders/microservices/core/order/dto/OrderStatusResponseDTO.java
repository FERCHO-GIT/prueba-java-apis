package transport.orders.microservices.core.order.dto;

import java.time.ZonedDateTime;

public class OrderStatusResponseDTO {
    private String orderId;
    private String status;
    private ZonedDateTime updatedAt;

    public OrderStatusResponseDTO(String orderId, String status, ZonedDateTime updatedAt) {
        this.orderId = orderId;
        this.status = status;
        this.updatedAt = updatedAt;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
