package transport.orders.microservices.core.order.assign.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderAssignRepository extends JpaRepository<OrderAssignEntity, UUID> {

}
