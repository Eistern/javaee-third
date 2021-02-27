package org.example.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.GregorianCalendar;
import java.util.List;

@Entity
@Data
@NoArgsConstructor(force = true)
public class Way {
    @Id
    private final BigInteger id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Tag> tags;

    @Column(name = "username")
    private String user;
    private BigInteger uid;
    private Boolean visible;
    private BigInteger version;
    private BigInteger changeset;
    private GregorianCalendar timestamp;
}
