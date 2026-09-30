package transport.orders.microservices.core.order.assign.dto;

public class OrderAssignRequestDTO {
    private String orderId;
    private String driverId;

    public OrderAssignRequestDTO(String driverId, String orderId) {
        this.driverId = driverId;
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }
}
