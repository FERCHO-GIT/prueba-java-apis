package transport.orders.microservices.core.order.compose.service;

import java.util.Collection;

import transport.orders.microservices.core.order.compose.dto.OrderRequestDTO;
import transport.orders.microservices.core.order.compose.dto.OrderResponseDTO;
import transport.orders.microservices.core.order.compose.dto.OrderStatusRequestDTO;
import transport.orders.microservices.core.order.compose.dto.OrderStatusResponseDTO;

public interface OrderComposeManagerService {
    void createOrder(OrderRequestDTO orderRequestDTO);
    OrderStatusResponseDTO updateOrderStatus(OrderStatusRequestDTO orderStatusRequestDTO);
    OrderResponseDTO getOrderById(String orderId);
    Collection<OrderResponseDTO> getOrderListByStatus(String status);
    Collection<OrderResponseDTO> getOrderListByDate(String date);
    Collection<OrderResponseDTO> getOrderListByOrigin(String origin);
    Collection<OrderResponseDTO> getOrderListByDestination(String destination);
}
