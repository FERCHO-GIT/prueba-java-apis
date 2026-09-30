package transport.orders.microservices.core.sign.compose.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import transport.orders.microservices.core.sign.compose.dto.SignInCredentialsDTO;
import transport.orders.microservices.core.sign.compose.service.SignComposeService;

@RestController
@RequestMapping("api/v1/compose")
public class SignComposeAPI {

    private final SignComposeService signComposeService;

    public SignComposeAPI(SignComposeService signComposeService) {
        this.signComposeService = signComposeService;
    }

    @PostMapping("signin")
    public ResponseEntity<Void> signComposeSignIn(@Valid @RequestBody SignInCredentialsDTO signInCredentialsDTO) {
        String jwts = this.signComposeService.createToken(signInCredentialsDTO);

        return ResponseEntity.ok()
            .header(HttpHeaders.AUTHORIZATION, "Bearer" + jwts)
            .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Authorization")
            .body(null);
    }

}
