package com.net.coccus.repo;

import com.net.coccus.FlightEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface flightLogRepository extends CrudRepository<FlightEntity, Long> {
}
