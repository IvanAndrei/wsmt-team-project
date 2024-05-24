package kitchen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class KitchenManagementApplication {

    public static void main(String[] args) {
        SpringApplication. run(KitchenManagementApplication.class, args);
    }

}
