package transport.orders.microservices.core.driver.compose.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import transport.orders.microservices.core.driver.compose.dto.DriverDTO;
import transport.orders.microservices.core.driver.compose.dto.DriverListActiveDTO;
import transport.orders.microservices.core.driver.compose.integration.DriverComposeIntegration;

@Service
public class DriverComposeManagerServiceImpl implements DriverComposeManagerService {

    public final DriverComposeIntegration driverComposeIntegration;

    public DriverComposeManagerServiceImpl(DriverComposeIntegration driverComposeIntegration) {
        this.driverComposeIntegration = driverComposeIntegration;
    }

    @Override
    public void createDriver(DriverDTO driverDTO) {
        this.driverComposeIntegration.createDriver(driverDTO);
    }

    @Override
    public Collection<DriverListActiveDTO> getDriverListActive() {
        return this.driverComposeIntegration.getDriverListActive();
    }

}
