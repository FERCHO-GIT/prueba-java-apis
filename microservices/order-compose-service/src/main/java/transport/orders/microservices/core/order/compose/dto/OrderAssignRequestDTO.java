package transport.orders.microservices.core.order.compose.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OrderAssignRequestDTO {
    @NotNull(message = "Must contain a valid order id")
    @NotBlank(message = "Order id cannot be blank")
    private String orderId;

    @NotNull(message = "Must contain a valid driver id")
    @NotBlank(message = "Driver id cannot be blank")
    private String driverId;

    public OrderAssignRequestDTO(String orderId, String driverId) {
        this.orderId = orderId;
        this.driverId = driverId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

}
