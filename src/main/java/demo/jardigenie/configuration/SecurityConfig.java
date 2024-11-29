package demo.jardigenie.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Gestion des autorisations
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/delete-article/**").authenticated() // Authentification requise pour les suppressions
                        .anyRequest().permitAll()  // Autoriser toutes les autres requêtes
                )
                // Activation de la protection CSRF
                .csrf(Customizer.withDefaults());  // Utilisation de la configuration par défaut pour CSRF

//        http.csrf(csrf -> csrf
//                .ignoringRequestMatchers("/api/no-csrf/**")  // Désactiver CSRF pour certaines routes
//        );


        return http.build();
    }
}

