package transport.orders.microservices.core.order.compose.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import transport.orders.microservices.core.order.compose.dto.OrderRequestDTO;
import transport.orders.microservices.core.order.compose.dto.OrderResponseDTO;
import transport.orders.microservices.core.order.compose.dto.OrderStatusRequestDTO;
import transport.orders.microservices.core.order.compose.dto.OrderStatusResponseDTO;
import transport.orders.microservices.core.order.compose.integration.OrderComposeIntegration;

@Service
public class OrderComposeManagerServiceImpl implements OrderComposeManagerService {

    private final OrderComposeIntegration orderComposeIntegration;

    public OrderComposeManagerServiceImpl(OrderComposeIntegration orderComposeIntegration) {
        this.orderComposeIntegration = orderComposeIntegration;
    }

    @Override
    public void createOrder(OrderRequestDTO orderRequestDTO) {
        this.orderComposeIntegration.createOrder(orderRequestDTO);
    }

    @Override
    public OrderStatusResponseDTO updateOrderStatus(OrderStatusRequestDTO orderStatusRequestDTO) {
        return this.orderComposeIntegration.updateOrderStatus(orderStatusRequestDTO);
    }

    @Override
    public OrderResponseDTO getOrderById(String orderId) {
        return this.orderComposeIntegration.getOrderById(orderId);
    }

    @Override
    public Collection<OrderResponseDTO> getOrderListByStatus(String status) {
        return this.orderComposeIntegration.getOrderListByStatus(status);
    }

    @Override
    public Collection<OrderResponseDTO> getOrderListByDate(String date) {
        return this.orderComposeIntegration.getOrderListByDate(date);
    }

    @Override
    public Collection<OrderResponseDTO> getOrderListByOrigin(String origin) {
        return this.orderComposeIntegration.getOrderListByOrigin(origin);
    }

    @Override
    public Collection<OrderResponseDTO> getOrderListByDestination(String destination) {
        return this.orderComposeIntegration.getOrderListByDestination(destination);
    }
}
