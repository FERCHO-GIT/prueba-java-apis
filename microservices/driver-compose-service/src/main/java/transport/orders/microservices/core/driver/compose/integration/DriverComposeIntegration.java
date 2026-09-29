package transport.orders.microservices.core.driver.compose.integration;

import java.util.Collection;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import transport.orders.microservices.core.driver.compose.dto.DriverDTO;
import transport.orders.microservices.core.driver.compose.dto.DriverListActiveDTO;

@Component
public class DriverComposeIntegration {
    private final String driverServiceURL;

    private final RestClient restClient;

    public DriverComposeIntegration() {
        this.driverServiceURL = "http://localhost:5001";
        this.restClient = RestClient.create();
    }

    public ResponseEntity<Void> createDriver(DriverDTO driverDTO) {
        String driverAPI = this.driverServiceURL + "/api/v1";
        return this.restClient.post()
            .uri(driverAPI + "/create/driver")
            .contentType(MediaType.APPLICATION_JSON)
            .body(DriverDTO.class)
            .retrieve()
            .toBodilessEntity();
    }

    public Collection<DriverListActiveDTO> getDriverListActive() {
        String driverAPI = this.driverServiceURL + "/api/v1";
        return this.restClient.get()
            .uri(driverAPI + "/list/driver")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .body(new ParameterizedTypeReference<Collection<DriverListActiveDTO>>(){});
    }
}
