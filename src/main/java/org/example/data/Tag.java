package org.example.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Tag {
    @Id
    private final String tagKey;
    private String tagValue;

    public static Tag fromGenerated(org.example.genearated.Tag generated) {
        Tag tag = new Tag(generated.getK());
        tag.setTagValue(generated.getV());
        return tag;
    }
}
