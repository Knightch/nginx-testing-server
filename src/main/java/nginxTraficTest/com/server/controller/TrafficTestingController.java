package nginxTraficTest.com.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrafficTestingController {

    @GetMapping("/health")
    public String heathCheckUp(){
        return "ok";
    }

    @GetMapping("/timeout")
    public String timeOutCheck() throws InterruptedException {
        Thread.sleep(40000);
        return "ok";
    }
}
