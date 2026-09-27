package transport.orders.microservices.core.driver.dto;

public class DriverListActiveDTO {
    private String id;
    private String name;
    private String licenseNumber;
    private Boolean active;

    public DriverListActiveDTO(String id, String name, String licenseNumber, Boolean active) {
        this.id = id;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
