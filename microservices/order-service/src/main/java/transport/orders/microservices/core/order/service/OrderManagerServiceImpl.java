package transport.orders.microservices.core.order.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import transport.orders.microservices.core.order.dto.OrderRequestDTO;
import transport.orders.microservices.core.order.dto.OrderResponseDTO;
import transport.orders.microservices.core.order.dto.OrderStatusRequestDTO;
import transport.orders.microservices.core.order.dto.OrderStatusResponseDTO;
import transport.orders.microservices.core.order.repository.OrderEntity;
import transport.orders.microservices.core.order.repository.OrderRepository;
import transport.orders.microservices.core.order.repository.Status;

public class OrderManagerServiceImpl implements OrderManagerService {

    private final OrderRepository orderRepository;

    public OrderManagerServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void createOrder(OrderRequestDTO orderRequestDTO) {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.of("America/Mexico_City");
        this.orderRepository.save(new OrderEntity(
            Status.CREATED, orderRequestDTO.getOrigin(), orderRequestDTO.getDestination(), 
            localDateTime.atZone(zoneId), localDateTime.atZone(zoneId)
        ));
    }

    @Override
    public OrderStatusResponseDTO updateOrderStatus(OrderStatusRequestDTO orderStatusRequestDTO) {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.of("America/Mexico_City");
        Status status = null;

        switch (orderStatusRequestDTO.getStatus()) {
            case "CREATED" -> status = Status.CREATED;
            case "CANCELED" -> status = Status.CANCELLED;
            case "DELIVERED" -> status = Status.DELIVERED;
            case "IN_TRANSIT" -> status = Status.IN_TRANSIT;
        }

        OrderEntity orderEntity = this.orderRepository.getReferenceById(UUID.fromString(orderStatusRequestDTO.getOrderId()));
        orderEntity.setStatus(status);
        orderEntity.setUpdatedAt(localDateTime.atZone(zoneId));
        OrderEntity orderEntityUpdated = this.orderRepository.save(orderEntity);
        return new OrderStatusResponseDTO(
            orderEntityUpdated.getOrderId().toString(), 
            orderEntityUpdated.getStatus().toString(), 
            orderEntityUpdated.getUpdatedAt()
        );
    }

    @Override
    public OrderResponseDTO getOrderById(String orderId) {
        OrderEntity orderEntity = this.orderRepository.getReferenceById(UUID.fromString(orderId));
        return new OrderResponseDTO(
            orderEntity.getStatus().toString(), orderEntity.getOrigin(), 
            orderEntity.getDestination(), orderEntity.getCreatedAt(), orderEntity.getUpdatedAt()
        );
    }

    @Override
    public Collection<OrderResponseDTO> getOrderListByStatus(String status) {
        Status statusCheck = null;

        switch (status) {
            case "CREATED" -> statusCheck = Status.CREATED;
            case "CANCELED" -> statusCheck = Status.CANCELLED;
            case "DELIVERED" -> statusCheck = Status.DELIVERED;
            case "IN_TRANSIT" -> statusCheck = Status.IN_TRANSIT;
        }
        Collection<OrderResponseDTO> orderListByStatus = new ArrayList<>();
        this.orderRepository.findByStatus(statusCheck).forEach(row -> {
            orderListByStatus.add(new OrderResponseDTO(
                row.getStatus().toString(), row.getOrigin(), row.getDestination(), 
                row.getCreatedAt(), row.getUpdatedAt()
            ));
        });
        return orderListByStatus;
    }

    @Override
    public Collection<OrderResponseDTO> getOrderListByDate(String date) {
        LocalDateTime localDateTime = LocalDateTime.parse(date);
        ZoneId zoneId = ZoneId.of("America/Mexico_City");

        Collection<OrderResponseDTO> orderListByDate = new ArrayList<>();
        this.orderRepository.findByCreatedAt(localDateTime.atZone(zoneId)).forEach(row -> {
            orderListByDate.add(new OrderResponseDTO(
                row.getStatus().toString(), row.getOrigin(), row.getDestination(), 
                row.getCreatedAt(), row.getUpdatedAt()
            ));
        });
        return orderListByDate;
    }

    @Override
    public Collection<OrderResponseDTO> getOrderListByOrigin(String origin) {
        Collection<OrderResponseDTO> orderListByOrigin = new ArrayList<>();
        this.orderRepository.findByOrigin(origin).forEach(row -> {
            orderListByOrigin.add(new OrderResponseDTO(
                row.getStatus().toString(), row.getOrigin(), row.getDestination(), 
                row.getCreatedAt(), row.getUpdatedAt()
            ));
        });
        return orderListByOrigin;
    }

    @Override
    public Collection<OrderResponseDTO> getOrderListByDestination(String destination) {
        Collection<OrderResponseDTO> orderListByDestination = new ArrayList<>();
        this.orderRepository.findByOrigin(destination).forEach(row -> {
            orderListByDestination.add(new OrderResponseDTO(
                row.getStatus().toString(), row.getOrigin(), row.getDestination(), 
                row.getCreatedAt(), row.getUpdatedAt()
            ));
        });
        return orderListByDestination;
    }

}
