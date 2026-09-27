package transport.orders.microservices.core.driver.dto;

public class DriverDTO {
    private String name;
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
