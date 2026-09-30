package transport.orders.microservices.core.sign.compose.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SignComposeSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .csrf((csrf) -> csrf.disable())
            .authorizeHttpRequests((authorizeHttpRequest) -> authorizeHttpRequest
                .requestMatchers(HttpMethod.POST, "api/v1/compose/signin").permitAll().anyRequest().authenticated()
            ).httpBasic(httpBasic -> httpBasic.disable());

        return httpSecurity.build();
    }

    @Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}
