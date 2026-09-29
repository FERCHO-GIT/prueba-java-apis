package transport.orders.microservices.core.driver.compose.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DriverDTO {
    @NotNull(message = "Must contain a valid name")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Must contain a valid license number")
    @NotBlank(message = "License Number cannot be blank")
    @Size(max = 10, message = "Must contain at least 10 characters")
    private String licenseNumber;

    private Boolean active;

    public DriverDTO(String name, String licenseNumber, Boolean active) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.active = active;
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
