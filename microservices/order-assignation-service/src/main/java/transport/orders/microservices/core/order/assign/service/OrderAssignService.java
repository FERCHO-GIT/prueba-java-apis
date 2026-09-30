package transport.orders.microservices.core.order.assign.service;

import transport.orders.microservices.core.order.assign.dto.OrderAssignRequestDTO;

public interface OrderAssignService {
    void createOrderAssign(OrderAssignRequestDTO orderAssignRequestDTO);
    void uploadAssignationFile();
    void uploadAssignationImage();
}
