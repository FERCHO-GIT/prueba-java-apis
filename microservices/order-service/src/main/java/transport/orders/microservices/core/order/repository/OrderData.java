package transport.orders.microservices.core.order.repository;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OrderData implements CommandLineRunner {

    private final OrderRepository orderRepository;

    public OrderData(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.of("America/Mexico_City");
        this.orderRepository.save(
            new OrderEntity(
                Status.CREATED, "La Villa", 
                "La Raza", localDateTime.atZone(zoneId), 
                localDateTime.atZone(zoneId)
            ));
        this.orderRepository.save(
            new OrderEntity(
                Status.CREATED, "San Bartolo", 
                "Los Reyes", localDateTime.atZone(zoneId), 
                localDateTime.atZone(zoneId)
            ));
    }


}
