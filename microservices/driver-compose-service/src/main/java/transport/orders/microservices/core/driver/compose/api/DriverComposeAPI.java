package transport.orders.microservices.core.driver.compose.api;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import transport.orders.microservices.core.driver.compose.dto.DriverDTO;
import transport.orders.microservices.core.driver.compose.dto.DriverListActiveDTO;
import transport.orders.microservices.core.driver.compose.service.DriverComposeManagerService;

@RestController
@RequestMapping("api/v1/compose")
public class DriverComposeAPI {

    private final DriverComposeManagerService driverComposeManagerService;

    public DriverComposeAPI(DriverComposeManagerService driverComposeManagerService) {
        this.driverComposeManagerService = driverComposeManagerService;
    }

    @PostMapping("create/driver")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDriver(@Valid @RequestBody DriverDTO driverDTO) {
        this.driverComposeManagerService.createDriver(driverDTO);
    }

    @GetMapping("list/driver")
    public Collection<DriverListActiveDTO> getDriverListActive() {
        return this.driverComposeManagerService.getDriverListActive();
    }
    
}
