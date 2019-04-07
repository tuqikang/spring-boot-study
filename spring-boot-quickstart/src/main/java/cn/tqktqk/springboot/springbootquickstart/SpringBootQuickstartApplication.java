package cn.tqktqk.springboot.springbootquickstart;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping
public class SpringBootQuickstartApplication {

    @Value("${myname}")
    private String name;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootQuickstartApplication.class, args);
    }

    @GetMapping("/")
    public String hello(){
        return "Hello World "+name;
    }
}
