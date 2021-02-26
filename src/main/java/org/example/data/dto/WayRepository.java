package org.example.data.dto;

import org.example.data.Way;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface WayRepository extends CrudRepository<Way, BigInteger> {
}
