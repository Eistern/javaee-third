package org.example.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;
import java.util.GregorianCalendar;

@Entity
@Data
@NoArgsConstructor(force = true)
public class Relation {
    @Id
    private final BigInteger id;

    @Column(name = "username")
    private String user;
    private BigInteger uid;
    private Boolean visible;
    private BigInteger version;
    private BigInteger changeset;
    private GregorianCalendar timestamp;
}
