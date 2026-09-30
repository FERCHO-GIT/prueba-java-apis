package transport.orders.microservices.core.order.assign.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import transport.orders.microservices.core.order.assign.dto.OrderAssignRequestDTO;
import transport.orders.microservices.core.order.assign.service.OrderAssignService;

@RestController
@RequestMapping("api/v1")
public class OrderAssignAPI {

    private final OrderAssignService orderAssignService;

    public OrderAssignAPI(OrderAssignService orderAssignService) {
        this.orderAssignService = orderAssignService;
    }

    @PostMapping("create/order/assign")
    public void createOrderAssign(@RequestBody OrderAssignRequestDTO orderAssignRequestDTO) {
        this.orderAssignService.createOrderAssign(orderAssignRequestDTO);
    }

}
