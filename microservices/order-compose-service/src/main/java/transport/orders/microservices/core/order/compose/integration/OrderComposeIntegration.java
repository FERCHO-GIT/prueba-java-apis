package transport.orders.microservices.core.order.compose.integration;

import java.util.Collection;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import transport.orders.microservices.core.order.compose.dto.DriverDTO;
import transport.orders.microservices.core.order.compose.dto.OrderAssignRequestDTO;
import transport.orders.microservices.core.order.compose.dto.OrderRequestDTO;
import transport.orders.microservices.core.order.compose.dto.OrderResponseDTO;
import transport.orders.microservices.core.order.compose.dto.OrderStatusRequestDTO;
import transport.orders.microservices.core.order.compose.dto.OrderStatusResponseDTO;

@Component 
public class OrderComposeIntegration {

    private final String orderServiceURL;
    private final String orderAssignationServiceURL;
    private final String driverServiceURL;

    private final RestClient restClient;

    public OrderComposeIntegration() {
        this.orderServiceURL = "http://localhost:8001";
        //this.orderServiceURL = "http://order-service:8080";
        this.orderAssignationServiceURL = "http://localhost:8002";
        //this.orderAssignationServiceURL = "http://order-assignation-service:8080";
        this.driverServiceURL = "http://localhost:5001";
        //this.driverServiceURL = "http://driver-service:5001";
        this.restClient = RestClient.create();
    }

    public ResponseEntity<Void> createOrder(OrderRequestDTO orderRequestDTO) {
        String orderAPI = this.orderServiceURL + "/api/v1";
        return this.restClient.post()
            .uri(orderAPI + "/create/order")
            .contentType(MediaType.APPLICATION_JSON)
            .body(orderRequestDTO)
            .retrieve()
            .toBodilessEntity();
    }

    public OrderStatusResponseDTO updateOrderStatus(OrderStatusRequestDTO orderStatusRequestDTO) {
        String orderAPI = this.orderServiceURL + "/api/v1";
        return this.restClient.put()
            .uri(orderAPI + "/update/order/status")
            .contentType(MediaType.APPLICATION_JSON)
            .body(orderStatusRequestDTO)
            .retrieve()
            .body(OrderStatusResponseDTO.class);
    }

    public OrderResponseDTO getOrderById(String orderId) {
        String orderAPI = this.orderServiceURL + "/api/v1";
        return this.restClient.get()
            .uri(orderAPI + "/order/" + orderId)
            .retrieve()
            .body(OrderResponseDTO.class);
    }

    public Collection<OrderResponseDTO> getOrderListByStatus(String status) {
        String orderAPI = this.orderServiceURL + "/api/v1";
        return this.restClient.get()
            .uri(orderAPI + "/order/status?value=" + status)
            .retrieve()
            .body(new ParameterizedTypeReference<Collection<OrderResponseDTO>>(){});
    }

    public Collection<OrderResponseDTO> getOrderListByDate(String date) {
        String orderAPI = this.orderServiceURL + "/api/v1";
        return this.restClient.get()
            .uri(orderAPI + "/order/date?value=" + date)
            .retrieve()
            .body(new ParameterizedTypeReference<Collection<OrderResponseDTO>>(){});
    }

    public Collection<OrderResponseDTO> getOrderListByOrigin(String origin) {
        String orderAPI = this.orderServiceURL + "/api/v1";
        return this.restClient.get()
            .uri(orderAPI + "/order/origin?value=" + origin)
            .retrieve()
            .body(new ParameterizedTypeReference<Collection<OrderResponseDTO>>(){});
    }

    public Collection<OrderResponseDTO> getOrderListByDestination(String destination) {
        String orderAPI = this.orderServiceURL + "/api/v1";
        return this.restClient.get()
            .uri(orderAPI + "/order/destination?value=" + destination)
            .retrieve()
            .body(new ParameterizedTypeReference<Collection<OrderResponseDTO>>(){});
    }

    public DriverDTO getDriverById(String driverId) {
        String driverAPI = this.driverServiceURL + "/api/v1";
        return this.restClient.get()
            .uri(driverAPI + "/driver?id=" + driverId)
            .retrieve()
            .body(DriverDTO.class);
    }

    public ResponseEntity<Void> createOrderAssign(OrderAssignRequestDTO orderAssignRequestDTO) {
        String orderAssignationAPI = this.orderAssignationServiceURL + "/api/v1";
        return this.restClient.post()
            .uri(orderAssignationAPI + "/create/order/assign")
            .contentType(MediaType.APPLICATION_JSON)
            .body(orderAssignRequestDTO)
            .retrieve()
            .toBodilessEntity();
    }

}
