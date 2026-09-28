package transport.orders.microservices.core.order.service;

import java.util.Collection;

import transport.orders.microservices.core.order.dto.OrderRequestDTO;
import transport.orders.microservices.core.order.dto.OrderResponseDTO;
import transport.orders.microservices.core.order.dto.OrderStatusRequestDTO;
import transport.orders.microservices.core.order.dto.OrderStatusResponseDTO;

public interface OrderManagerService {
    void createOrder(OrderRequestDTO orderRequestDTO);
    OrderStatusResponseDTO updateOrderStatus(OrderStatusRequestDTO orderStatusRequestDTO);
    OrderResponseDTO getOrderById(String orderId);
    Collection<OrderResponseDTO> getOrderListByStatus(String status);
    Collection<OrderResponseDTO> getOrderListByDate(String date);
    Collection<OrderResponseDTO> getOrderListByOrigin(String origin);
    Collection<OrderResponseDTO> getOrderListByDestination(String destination);
}
