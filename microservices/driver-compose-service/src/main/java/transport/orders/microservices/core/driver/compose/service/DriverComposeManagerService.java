package transport.orders.microservices.core.driver.compose.service;

import java.util.Collection;

import transport.orders.microservices.core.driver.compose.dto.DriverDTO;
import transport.orders.microservices.core.driver.compose.dto.DriverListActiveDTO;

public interface DriverComposeManagerService {
    void createDriver(DriverDTO driverDTO);
    Collection<DriverListActiveDTO> getDriverListActive();
}
