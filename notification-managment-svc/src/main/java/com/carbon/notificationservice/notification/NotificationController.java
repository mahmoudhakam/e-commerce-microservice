package com.carbon.notificationservice.notification;

import com.carbon.notificationservice.notification.domain.Address;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/v1/api/notifications")
public class NotificationController {
    @Value("${spring.application.name}")
    private String applicationName;

    @PostMapping("/sendNotification")
    public ResponseEntity notification(@RequestBody String address) {
        log.info("Incoming request at {} at /sendNotification with body {}", applicationName, address);
        return ResponseEntity.ok("response from /path2 ");
    }
}
