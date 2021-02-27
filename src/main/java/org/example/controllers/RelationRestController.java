package org.example.controllers;

import org.example.data.Relation;
import org.example.data.dto.RelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Optional;

@RestController
@RequestMapping(path = "/relation", consumes = "application/json", produces = "application/json")
public class RelationRestController {
    @Autowired
    private RelationRepository relationRepository;

    @PostMapping(path = "/new")
    public Relation create(@RequestBody Relation relation) {
        return relationRepository.save(relation);
    }

    @GetMapping(path = "/get")
    public ResponseEntity<Relation> read(@RequestParam long id) {
        Optional<Relation> relationOptional = relationRepository.findById(BigInteger.valueOf(id));
        if (relationOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(relationOptional.get(), HttpStatus.OK);
    }

    @PatchMapping(path = "/update")
    public ResponseEntity<Relation> update(@RequestBody Relation relation) {
        Optional<Relation> relationOptional = relationRepository.findById(relation.getId());
        if (relationOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Relation existingRelation = relationOptional.get();
        if (relation.getChangeset() != null) {
            existingRelation.setChangeset(relation.getChangeset());
        }
        if (relation.getTimestamp() != null) {
            existingRelation.setTimestamp(relation.getTimestamp());
        }
        if (relation.getUid() != null) {
            existingRelation.setUid(relation.getUid());
        }
        if (relation.getUser() != null) {
            existingRelation.setUser(relation.getUser());
        }
        if (relation.getVersion() != null) {
            existingRelation.setVersion(relation.getVersion());
        }
        if (relation.getVisible() != null) {
            existingRelation.setVisible(relation.getVisible());
        }
        if (relation.getTags() != null) {
            existingRelation.setTags(relation.getTags());
        }
        return new ResponseEntity<>(relationRepository.save(existingRelation), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Relation> delete(@RequestBody Relation relation) {
        if (relation.getId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        relationRepository.deleteById(relation.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
