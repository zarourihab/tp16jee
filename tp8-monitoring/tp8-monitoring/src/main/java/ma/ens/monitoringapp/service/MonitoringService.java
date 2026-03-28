package ma.ens.monitoringapp.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MonitoringService {

    private static final Logger logger = LoggerFactory.getLogger(MonitoringService.class);
    private final Counter requestCounter;

    public MonitoringService(MeterRegistry meterRegistry) {
        this.requestCounter = meterRegistry.counter("custom.requests.count");
    }

    public String processData() {
        logger.info("Démarrage du traitement des données");
        requestCounter.increment();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            logger.error("Erreur dans le traitement", e);
            Thread.currentThread().interrupt();
            return "Erreur pendant le traitement";
        }

        logger.info("Traitement terminé avec succès");
        return "Traitement effectué avec succès";
    }
}