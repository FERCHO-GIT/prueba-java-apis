package transport.orders.microservices.core.order.compose.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OrderStatusRequestDTO {
    @NotNull(message = "Must contain a valid id")
    private String orderId;

    @NotNull(message = "Must contain a valid value")
    @NotBlank(message = "Status cannot be blank")
    private String status;

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

}
