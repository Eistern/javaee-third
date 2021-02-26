package org.example.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;
import java.util.GregorianCalendar;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Node {
    @Id
    private final BigInteger id;

    private Double lat;
    private Double lon;
    @Column(name = "username")
    private String user;
    private BigInteger uid;
    private Boolean visible;
    private BigInteger version;
    private BigInteger changeset;
    private GregorianCalendar timestamp;

    public static Node fromGenerated(org.example.genearated.Node generated) {
        Node node = new Node(generated.getId());
        node.lat = generated.getLat();
        node.lon = generated.getLon();
        node.user = generated.getUser();
        node.uid = generated.getUid();
        node.timestamp = generated.getTimestamp().toGregorianCalendar();
        node.visible = generated.isVisible();
        node.changeset = generated.getChangeset();
        return node;
    }
}
