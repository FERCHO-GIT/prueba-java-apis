package transport.orders.microservices.core.driver.repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component 
public class DriverData implements CommandLineRunner {

    private final DriverRepository driverRepository;

    public DriverData (DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.driverRepository.save(
            new DriverEntity("Juan", "SON9876543", true)
        );
        this.driverRepository.save(
            new DriverEntity("Pablo", "D9K3219307", false)
        );
    }

}
