package photo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurity {

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests( authz -> authz
                        .requestMatchers(HttpMethod.GET, "users/check").hasAuthority("SCOPE_profile") //Web security will check if the jwt has profile scope for this endpoint after it has checked if the jwt is valid
                        .anyRequest().authenticated())//all requests must come from authenticated users
                .oauth2ResourceServer( oauth2 -> oauth2.jwt(jwt->{})); //specifies that this is a resource project that follow oauth2 rules and is expecting jwt token for security

        return http.build();
    }
}
