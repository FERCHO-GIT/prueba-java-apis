package transport.orders.microservices.core.sign.compose.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import transport.orders.microservices.core.sign.compose.dto.SignInCredentialsDTO;

@Service
public class SignComposeServiceImpl implements SignComposeService {

    @Value("${sign.username}")
    private final String dataUsername = null;

    @Value("${sign.password}")
    private final String dataPassword = null;

    private final SignComposeJwtService signComposeJwtService;

    public SignComposeServiceImpl(SignComposeJwtService signComposeJwtService) {
        this.signComposeJwtService = signComposeJwtService;
    }

    @Override
    public String createToken(SignInCredentialsDTO signInCredentialsDTO) {
        if (signInCredentialsDTO.getUsername().equals(dataUsername) && signInCredentialsDTO.getPassword().equals(dataPassword)) {
            return this.signComposeJwtService.getJWT(signInCredentialsDTO.getUsername());
        } else {
            throw new RuntimeException("Bad Credentials!");
        }
    }

}
