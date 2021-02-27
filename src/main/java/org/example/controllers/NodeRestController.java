package org.example.controllers;

import org.example.data.Node;
import org.example.data.dto.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/node", consumes = "application/json", produces = "application/json")
public class NodeRestController {
    @Autowired
    private NodeRepository nodeRepository;

    @PostMapping(path = "/new")
    public Node create(@RequestBody Node node) {
        return nodeRepository.save(node);
    }

    @GetMapping(path = "/find")
    public ResponseEntity<Node> read(@RequestBody Node node) {
        Optional<Node> nodeOptional = nodeRepository.findById(node.getId());
        if (nodeOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(nodeOptional.get(), HttpStatus.OK);
    }

    @PatchMapping(path = "/update")
    public ResponseEntity<Node> update(@RequestBody Node node) {
        Optional<Node> nodeOptional = nodeRepository.findById(node.getId());
        if (nodeOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Node existingNode = nodeOptional.get();
        if (node.getChangeset() != null) {
            existingNode.setChangeset(node.getChangeset());
        }
        if (node.getLat() != null) {
            existingNode.setLat(node.getLat());
        }
        if (node.getLon() != null) {
            existingNode.setLon(node.getLon());
        }
        if (node.getTimestamp() != null) {
            existingNode.setTimestamp(node.getTimestamp());
        }
        if (node.getUid() != null) {
            existingNode.setUid(node.getUid());
        }
        if (node.getUser() != null) {
            existingNode.setUser(node.getUser());
        }
        if (node.getVersion() != null) {
            existingNode.setVersion(node.getVersion());
        }
        if (node.getVisible() != null) {
            existingNode.setVisible(node.getVisible());
        }
        return new ResponseEntity<>(nodeRepository.save(existingNode), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Node> delete(@RequestBody Node node) {
        if (node.getId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        nodeRepository.deleteById(node.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/find")
    public ResponseEntity<List<Node>> find(@RequestBody RadiusRequestDTO requestDTO) {
        List<Node> inRegion = nodeRepository.findInRegion(requestDTO.getLat(), requestDTO.getLon(), requestDTO.getRadius());
        if (inRegion.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(inRegion, HttpStatus.OK);
    }
}
