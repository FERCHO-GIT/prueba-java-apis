package transport.orders.microservices.core.driver.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;

import transport.orders.microservices.core.driver.dto.DriverDTO;
import transport.orders.microservices.core.driver.dto.DriverListActiveDTO;
import transport.orders.microservices.core.driver.repository.DriverEntity;
import transport.orders.microservices.core.driver.repository.DriverRepository;

@Service
public class DriverManagerServiceImpl implements DriverManagerService {

    private final DriverRepository driverRepository;

    public DriverManagerServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public void createDriver(DriverDTO driverDTO) {
        this.driverRepository.save(new DriverEntity(
            driverDTO.getName(), driverDTO.getLicenseNumber(), driverDTO.getActive()
        ));
    }

    @Override
    public Collection<DriverListActiveDTO> getDriverListActive() {
        Collection<DriverListActiveDTO> driverListActive = new ArrayList<>();
        this.driverRepository.findAll().forEach(row -> {
            driverListActive.add(new DriverListActiveDTO(
                row.getDriverId().toString(), row.getName(), row.getLicenseNumber(), row.getActive()));
        });

        return driverListActive;
    }

}
