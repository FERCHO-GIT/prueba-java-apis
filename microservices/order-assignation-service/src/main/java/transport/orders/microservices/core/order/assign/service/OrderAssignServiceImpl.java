package transport.orders.microservices.core.order.assign.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

import org.springframework.stereotype.Service;

import transport.orders.microservices.core.order.assign.dto.OrderAssignRequestDTO;
import transport.orders.microservices.core.order.assign.repository.OrderAssignEntity;
import transport.orders.microservices.core.order.assign.repository.OrderAssignRepository;

@Service
public class OrderAssignServiceImpl implements OrderAssignService {

    private final OrderAssignRepository orderAssignRepository;

    public OrderAssignServiceImpl(OrderAssignRepository orderAssignRepository) {
        this.orderAssignRepository = orderAssignRepository;
    }

    @Override
    public void createOrderAssign(OrderAssignRequestDTO orderAssignRequestDTO) {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.of("America/Mexico_City");
        this.orderAssignRepository.save(new OrderAssignEntity(
            UUID.fromString(orderAssignRequestDTO.getOrderId()), 
            UUID.fromString(orderAssignRequestDTO.getDriverId()),
            localDateTime.atZone(zoneId)
        ));
    }

    @Override
    public void uploadAssignationFile() {
        throw new UnsupportedOperationException("Unimplemented method 'uploadAssignationFile'");
    }

    @Override
    public void uploadAssignationImage() {
        throw new UnsupportedOperationException("Unimplemented method 'uploadAssignationImage'");
    }

}
