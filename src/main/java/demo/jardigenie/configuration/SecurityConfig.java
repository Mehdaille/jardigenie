//package demo.jardigenie.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.logout.HeaderWriterLogoutHandler;
//import org.springframework.security.web.header.writers.ClearSiteDataHeaderWriter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import javax.sql.DataSource;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//
//        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//
//        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT email, mot_de_passe, 1 FROM user WHERE email = ?");
//
//        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT u.id_utilisateur AS UTILISATEUR_id_utilisateur, r.id_role AS ROLE_id_role,  r.libelle ,  u.nom, u.prenom, u.email, u.mot_de_passe FROM role_utilisateur ru JOIN utilisateur u ON u.id_utilisateur = ru.UTILISATEUR_id_utilisateur JOIN role r ON r.id_role = ru.ROLE_id_role WHERE u.email = ?");
//
//        return jdbcUserDetailsManager;
//    }
//
//    @Bean
//    public SecurityFilterChain web(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((authorize) -> authorize
//                        .anyRequest().permitAll()
//                );
//        http.formLogin(form ->
//                form.loginPage("/login")
//                        .defaultSuccessUrl("/profil-utilisateur"));
//        HeaderWriterLogoutHandler clearSiteData = new HeaderWriterLogoutHandler(
//                new ClearSiteDataHeaderWriter(ClearSiteDataHeaderWriter.Directive.ALL));
//
//        http
//                .logout((logout) ->
//                        logout
//
//                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
//                                .logoutSuccessUrl("/login?logout")
//                                .addLogoutHandler(clearSiteData)
//                );
//
//        return http.build();
//    }
//}
