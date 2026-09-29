package transport.orders.microservices.core.order.compose.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OrderRequestDTO {
    @NotNull(message = "Must contain a valid value")
    @NotBlank(message = "Origin cannot be blank")
    private String origin;
    
    @NotNull(message = "Must contain a valid value")
    @NotBlank(message = "Origin cannot be blank")
    private String destination;

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
}
