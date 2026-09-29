package transport.orders.microservices.core.order.compose.api;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import transport.orders.microservices.core.order.compose.dto.OrderRequestDTO;
import transport.orders.microservices.core.order.compose.dto.OrderResponseDTO;
import transport.orders.microservices.core.order.compose.dto.OrderStatusRequestDTO;
import transport.orders.microservices.core.order.compose.dto.OrderStatusResponseDTO;
import transport.orders.microservices.core.order.compose.service.OrderComposeManagerService;

@RestController
@RequestMapping("api/v1")
public class OrderComposeAPI {

    private final OrderComposeManagerService orderComposeManagerService;

    public OrderComposeAPI(OrderComposeManagerService orderComposeManagerService) {
        this.orderComposeManagerService = orderComposeManagerService;
    }

    @PostMapping("compose/create/order")
    public void createOrder(@Valid @RequestBody OrderRequestDTO orderRequestDTO) {
        this.orderComposeManagerService.createOrder(orderRequestDTO);
    }

    @PutMapping("compose/update/order/status")
    public OrderStatusResponseDTO updateOrderStatus(@Valid @RequestBody OrderStatusRequestDTO orderStatusRequestDTO) {
        return this.orderComposeManagerService.updateOrderStatus(orderStatusRequestDTO);
    }

    @GetMapping("compose/order/{orderId}")
    public OrderResponseDTO getOrderById(@PathVariable String orderId) {
        return this.orderComposeManagerService.getOrderById(orderId);
    }

    @GetMapping("compose/order/status")
    public Collection<OrderResponseDTO> getOrderListByStatus(@PathParam(value="value") String value) {
        return this.orderComposeManagerService.getOrderListByStatus(value);
    }

    @GetMapping("compose/order/date")
    public Collection<OrderResponseDTO> getOrderListByDate(@PathParam(value="value") String value) {
        return this.orderComposeManagerService.getOrderListByDate(value);
    }

    @GetMapping("compose/order/origin")
    public Collection<OrderResponseDTO> getOrderListByOrigin(@PathParam(value="value") String value) {
        return this.orderComposeManagerService.getOrderListByOrigin(value);
    }

    @GetMapping("compose/order/destination")
    public Collection<OrderResponseDTO> getOrderListByDestination(@PathParam(value="value") String value) {
        return this.orderComposeManagerService.getOrderListByDestination(value);
    }

}
