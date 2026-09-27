package transport.orders.microservices.core.driver.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<DriverEntity, UUID> {

    

}
