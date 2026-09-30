package transport.orders.microservices.core.order.assign.dto;

import java.util.UUID;

public class OrderAssignRequestDTO {
    private UUID orderId;
    private UUID driverId;

    public OrderAssignRequestDTO(UUID driverId, UUID orderId) {
        this.driverId = driverId;
        this.orderId = orderId;
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
}
