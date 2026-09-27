package transport.orders.microservices.core.driver.service;

import java.util.Collection;

import transport.orders.microservices.core.driver.dto.DriverDTO;
import transport.orders.microservices.core.driver.dto.DriverListActiveDTO;

public interface DriverManagerService {
    void createDriver(DriverDTO driverDTO);
    Collection<DriverListActiveDTO> getDriverListActive();
}
