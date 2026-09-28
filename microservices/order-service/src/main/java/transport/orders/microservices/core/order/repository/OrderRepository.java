package transport.orders.microservices.core.order.repository;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {

    Collection<OrderEntity> findByStatus(Status status);
    Collection<OrderEntity> findByCreatedAt(ZonedDateTime date);
    Collection<OrderEntity> findByOrigin(String origin);
    Collection<OrderEntity> findByDestination(String origin);

}
