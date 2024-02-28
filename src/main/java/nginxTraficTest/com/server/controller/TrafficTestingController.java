package nginxTraficTest.com.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@RestController
public class TrafficTestingController {

    @GetMapping("/health")
    public ResponseEntity<Void> heathCheckUp(){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/timeout")
    public ResponseEntity<Void> timeOutCheck() throws InterruptedException {
        CompletableFuture<Void> future = new CompletableFuture<>();

        // Introduce a delay of 40 seconds
        try {
            TimeUnit.SECONDS.sleep(40);
        } catch (InterruptedException e) {
            // Handle interruption if needed
        }

        // Complete the CompletableFuture
        future.complete(null);

        return ResponseEntity.ok().build();
    }
}
