package transport.orders.microservices.core.driver.compose.api;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import transport.orders.microservices.core.driver.compose.dto.DriverDTO;
import transport.orders.microservices.core.driver.compose.dto.DriverListActiveDTO;
import transport.orders.microservices.core.driver.compose.service.DriverComposeManagerService;

@RestController
@RequestMapping("api/v1")
public class DriverComposeAPI {

    private final DriverComposeManagerService driverComposeManagerService;

    public DriverComposeAPI(DriverComposeManagerService driverComposeManagerService) {
        this.driverComposeManagerService = driverComposeManagerService;
    }

    @PostMapping("compose/create/driver")
    public void createDriver(DriverDTO driverDTO) {
        this.driverComposeManagerService.createDriver(driverDTO);
    }

    @GetMapping("compose/list/driver")
    public Collection<DriverListActiveDTO> getDriverListActive() {
        return this.driverComposeManagerService.getDriverListActive();
    }
    
}
