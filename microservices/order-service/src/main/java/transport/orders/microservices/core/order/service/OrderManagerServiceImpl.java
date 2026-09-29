package transport.orders.microservices.core.order.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

import transport.orders.microservices.core.order.dto.OrderRequestDTO;
import transport.orders.microservices.core.order.dto.OrderResponseDTO;
import transport.orders.microservices.core.order.dto.OrderStatusRequestDTO;
import transport.orders.microservices.core.order.dto.OrderStatusResponseDTO;
import transport.orders.microservices.core.order.repository.OrderEntity;
import transport.orders.microservices.core.order.repository.OrderRepository;
import transport.orders.microservices.core.order.repository.Status;

@Service
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
            Status.CREATED, orderRequestDTO.getOrigin().toLowerCase(), orderRequestDTO.getDestination().toLowerCase(), 
            localDateTime.atZone(zoneId), localDateTime.atZone(zoneId)
        ));
    }

    @Override
    public OrderStatusResponseDTO updateOrderStatus(OrderStatusRequestDTO orderStatusRequestDTO) {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.of("America/Mexico_City");
        Status status = null;

        switch (orderStatusRequestDTO.getStatus().toUpperCase()) {
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

        switch (status.toUpperCase()) {
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
        Collection<OrderResponseDTO> orderListByDate = new ArrayList<>();
        try {
            Date toDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            this.orderRepository.findByCreatedAtCustom(toDate).forEach(row -> {
                orderListByDate.add(new OrderResponseDTO(
                row.getStatus().toString(), row.getOrigin(), row.getDestination(), 
                row.getCreatedAt(), row.getUpdatedAt()
                ));
            });
            
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return orderListByDate;
    }

    @Override
    public Collection<OrderResponseDTO> getOrderListByOrigin(String origin) {
        Collection<OrderResponseDTO> orderListByOrigin = new ArrayList<>();
        this.orderRepository.findByOrigin(origin.toLowerCase()).forEach(row -> {
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
        this.orderRepository.findByDestination(destination.toLowerCase()).forEach(row -> {
            orderListByDestination.add(new OrderResponseDTO(
                row.getStatus().toString(), row.getOrigin(), row.getDestination(), 
                row.getCreatedAt(), row.getUpdatedAt()
            ));
        });
        return orderListByDestination;
    }

}
