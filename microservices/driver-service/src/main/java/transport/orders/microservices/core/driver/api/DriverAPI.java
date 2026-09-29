package transport.orders.microservices.core.driver.api;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import transport.orders.microservices.core.driver.dto.DriverDTO;
import transport.orders.microservices.core.driver.dto.DriverListActiveDTO;
import transport.orders.microservices.core.driver.service.DriverManagerService;

@RestController
@RequestMapping("api/v1")
public class DriverAPI {

    private final DriverManagerService driverManagerService;

    public DriverAPI(DriverManagerService driverManagerService) {
        this.driverManagerService = driverManagerService;
    }

    @PostMapping("create/driver")
    @ResponseStatus(HttpStatus.CREATED)
    public void createDriver(@RequestBody DriverDTO driverDTO) {
        this.driverManagerService.createDriver(driverDTO);
    }

    @GetMapping("list/driver")
    public Collection<DriverListActiveDTO> getDriverListActive() {
        return this.driverManagerService.getDriverListActive();
    }

}
