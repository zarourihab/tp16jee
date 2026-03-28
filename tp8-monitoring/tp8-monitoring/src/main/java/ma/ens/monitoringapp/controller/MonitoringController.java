package ma.ens.monitoringapp.controller;

import ma.ens.monitoringapp.service.MonitoringService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonitoringController {

    private final MonitoringService monitoringService;

    public MonitoringController(MonitoringService monitoringService) {
        this.monitoringService = monitoringService;
    }

    @GetMapping("/process")
    public String process() {
        return monitoringService.processData();
    }

    @GetMapping("/hello")
    public String hello() {
        return "Application Spring Boot Monitoring opérationnelle";
    }
}