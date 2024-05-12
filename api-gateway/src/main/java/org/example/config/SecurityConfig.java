package org.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig {

//    private String allowedOrigins = "*";
//    private String allowedMethods = "GET,POST,PUT,DELETE,OPTIONS";
//    private String allowedHeaders = "X-Requested-With,Content-Type,Accept,Origin";
    @Value("${cors.allowedOrigin}")
    private String allowedOrigins;

    @Value("${cors.allowedMethods}")
    private String allowedMethods;

    @Value("${cors.allowedHeaders}")
    private String allowedHeaders;

    @Value("${cors.corsConfiguration}")
    private String corsConfiguration;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            public void addCorsMappings(final CorsRegistry registry) {
                registry.addMapping(corsConfiguration).allowedHeaders(allowedHeaders).allowedMethods(allowedMethods);
            }
        };
    }

//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity) {
//        serverHttpSecurity
//                .csrf(ServerHttpSecurity.CsrfSpec::disable)
//                .authorizeExchange(exchange ->
//                        exchange.pathMatchers("/wsmt/**")
//                                .permitAll()
//                                .anyExchange()
//                                .authenticated())
//                .oauth2ResourceServer(spec -> spec.jwt(Customizer.withDefaults()));
//        return serverHttpSecurity.build();
//    }
}
