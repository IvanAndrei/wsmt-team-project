package kitchen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

@EnableFeignClients
@SpringBootApplication
public class KitchenManagementApplication {

    public static void main(String[] args) {
        SpringApplication. run(KitchenManagementApplication.class, args);
    }

}
