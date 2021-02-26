package org.example.data.dto;

import org.example.data.Relation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface RelationRepository extends CrudRepository<Relation, BigInteger> {
}
