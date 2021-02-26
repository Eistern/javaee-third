package org.example.data.dto;

import org.example.data.Node;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface NodeRepository extends CrudRepository<Node, BigInteger> {
}
