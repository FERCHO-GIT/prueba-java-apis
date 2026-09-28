package transport.orders.microservices.core.order.repository;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {

    Collection<OrderEntity> findByStatus(Status status);
    @Query(value="SELECT * FROM orders WHERE created_at::date = ?1", nativeQuery=true)
    Collection<OrderEntity> findByCreatedAtCustom(Date date);
    Collection<OrderEntity> findByOrigin(String origin);
    Collection<OrderEntity> findByDestination(String origin);

}
