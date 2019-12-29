package it.valeriovaudi.monitoringplayground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.HandlerFunction;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.web.servlet.function.RouterFunctions.route;

@SpringBootApplication
public class MonitoringPlaygroundApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitoringPlaygroundApplication.class, args);
    }
}

@Configuration
class PlayGroundRoutes {

    @Bean
    RouterFunction<ServerResponse> routes() {
        return route()
                .GET("/hello/{name}", helloHandler())
                .build();
    }

    private HandlerFunction<ServerResponse> helloHandler() {
        return serverRequest -> ServerResponse.ok().body("Hello " + serverRequest.pathVariable("name"));
    }
}
