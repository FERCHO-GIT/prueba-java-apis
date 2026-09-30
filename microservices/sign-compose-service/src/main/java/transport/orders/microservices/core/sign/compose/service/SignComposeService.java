package transport.orders.microservices.core.sign.compose.service;

import transport.orders.microservices.core.sign.compose.dto.SignInCredentialsDTO;

public interface SignComposeService {
    String createToken(SignInCredentialsDTO signInCredentialsDTO);
}
