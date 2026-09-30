package transport.orders.microservices.core.sign.compose.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignComposeDetailsService implements UserDetailsService {

    @Value("${sign.username}")
    private final String dataUsername = null;

    @Value("${sign.password}")
    private final String dataPassword = null;

    private final PasswordEncoder passwordEncoder;

    public SignComposeDetailsService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User.UserBuilder builder = null;

        if (this.dataUsername.equals(username)) {
            builder = User.builder();
            builder.username(this.dataUsername);
            builder.password(passwordEncoder.encode(this.dataPassword));
        } else {
            throw new UsernameNotFoundException("Customer Not Found");
        }

        return builder.build();
    }

}
