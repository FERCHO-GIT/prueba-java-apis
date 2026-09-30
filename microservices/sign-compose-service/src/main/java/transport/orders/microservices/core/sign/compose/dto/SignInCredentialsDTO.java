package transport.orders.microservices.core.sign.compose.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SignInCredentialsDTO {
    @NotNull(message = "Must contain a valid username")
    @NotBlank(message = "Username cannot be blank")
    private String username;

    @NotNull(message = "Must contain a valid password")
    @NotBlank(message = "Password cannot be blank")
    private String password;

    public SignInCredentialsDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
