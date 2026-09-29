package transport.orders.microservices.core.driver.repository;

import java.util.UUID;

import org.hibernate.type.YesNoConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "drivers")
public class DriverEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID driverId;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String licenseNumber;

    @Convert(converter = YesNoConverter.class)
    @Column(nullable=false)
    private Boolean active;

    public DriverEntity() { }

    public DriverEntity(String name, String licenseNumber, Boolean active) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.active = active;
    }

    public UUID getDriverId() {
        return driverId;
    }

    public void setDriverId(UUID driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
