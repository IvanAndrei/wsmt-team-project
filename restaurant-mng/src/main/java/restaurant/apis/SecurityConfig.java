//package restaurant.apis;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import java.util.Arrays;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//class SecurityConfig {
//
//  @Bean
//  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    http.cors(
//            httpSecurityCorsConfigurer ->
//                httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource()))
//        .csrf(AbstractHttpConfigurer::disable)
//        .authorizeHttpRequests(
//            request -> {
//              request.requestMatchers("*/**").permitAll();
//              //              request.requestMatchers("/users").hasAnyAuthority("USER", "ADMIN");
//            })
//        .formLogin(withDefaults())
//        .httpBasic(withDefaults());
//    return http.build();
//  }
//
//  //    @Bean
//  //    public CorsConfigurationSource corsConfigurationSource() {
//  //        CorsConfiguration corsConfiguration = new CorsConfiguration();
//  //        //Make the below setting as * to allow connection from any hos
//  //        corsConfiguration.setAllowedOrigins(List.of("http://localhost:4200"));
//  //        corsConfiguration.setAllowedMethods(List.of("GET", "POST"));
//  //        corsConfiguration.setAllowCredentials(true);
//  //        corsConfiguration.setAllowedHeaders(List.of("*"));
//  //        corsConfiguration.setMaxAge(3600L);
//  //        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//  //        source.registerCorsConfiguration("/**", corsConfiguration);
//  //        return source;
//  //    }
//  @Bean
//  CorsConfigurationSource corsConfigurationSource() {
//    CorsConfiguration configuration = new CorsConfiguration();
//    configuration.setAllowedOrigins(Arrays.asList("http://localhost:8080"));
//    configuration.setAllowedMethods(
//        Arrays.asList("GET", "POST", "OPTIONS", "DELETE", "PUT", "PATCH"));
//    configuration.setAllowedHeaders(
//        Arrays.asList("X-Requested-With", "Origin", "Content-Type", "Accept", "Authorization"));
//    configuration.setAllowCredentials(false);
//    configuration.setAllowedHeaders(Arrays.asList("*"));
//    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//    source.registerCorsConfiguration("/**", configuration);
//    return source;
//  }
//}
