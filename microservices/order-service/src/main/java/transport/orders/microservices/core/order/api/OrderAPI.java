package transport.orders.microservices.core.order.api;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import transport.orders.microservices.core.order.dto.OrderRequestDTO;
import transport.orders.microservices.core.order.dto.OrderResponseDTO;
import transport.orders.microservices.core.order.dto.OrderStatusRequestDTO;
import transport.orders.microservices.core.order.dto.OrderStatusResponseDTO;
import transport.orders.microservices.core.order.service.OrderManagerService;

@RestController
@RequestMapping("api/v1")
public class OrderAPI {

    private final OrderManagerService orderManagerService;

    public OrderAPI (OrderManagerService orderManagerService) {
        this.orderManagerService = orderManagerService;
    }

    @PostMapping("create/order")
    public void createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        this.orderManagerService.createOrder(orderRequestDTO);
    }

    @PutMapping("update/order/status")
    public OrderStatusResponseDTO updateOrderStatus(@RequestBody OrderStatusRequestDTO orderStatusRequestDTO) {
        return this.orderManagerService.updateOrderStatus(orderStatusRequestDTO);
    }

    @GetMapping("order/{orderId}")
    public OrderResponseDTO getOrderById(@PathVariable String orderId) {
        return this.orderManagerService.getOrderById(orderId);
    }

    @GetMapping("order/status")
    public Collection<OrderResponseDTO> getOrderListByStatus(@PathParam(value="value") String value) {
        return this.orderManagerService.getOrderListByStatus(value);
    }

    @GetMapping("order/date")
    public Collection<OrderResponseDTO> getOrderListByDate(@PathParam(value="value") String value) {
        return this.orderManagerService.getOrderListByDate(value);
    }

    @GetMapping("order/origin")
    public Collection<OrderResponseDTO> getOrderListByOrigin(@PathParam(value="value") String value) {
        return this.orderManagerService.getOrderListByOrigin(value);
    }

    @GetMapping("order/destination")
    public Collection<OrderResponseDTO> getOrderListByDestination(@PathParam(value="value") String value) {
        return this.orderManagerService.getOrderListByDestination(value);
    }

}
