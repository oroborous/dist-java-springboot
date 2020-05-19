package edu.wctc.tacocloud.repository;

import edu.wctc.tacocloud.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByCityOrderByName(String city);

    List<Order> findByZip(String deliveryZip);

    List<Order> readOrdersByZipAndPlacedAtBetween(String deliveryZip,
                                                  LocalDateTime startDate,
                                                  LocalDateTime endDate);

    @Query("from Order o where upper(o.city) = 'WAUKESHA'")
    List<Order> readOrdersDeliveredInWaukesha();

}
