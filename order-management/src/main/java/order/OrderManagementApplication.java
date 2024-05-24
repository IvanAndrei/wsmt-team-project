package order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;

@SpringBootApplication
public class OrderManagementApplication {

    public static void main(String[] args) {


        SpringApplication.run(OrderManagementApplication.class, args);
    }
}
