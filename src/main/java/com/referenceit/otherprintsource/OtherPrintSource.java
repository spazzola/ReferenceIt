package com.referenceit.otherprintsource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.referenceit.otherprintsource.britishstandard.BritishStandard;
import com.referenceit.reference.Reference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(name = "BritishStandard", value = BritishStandard.class),

        @JsonSubTypes.Type(name = "PolishStandard", value = PolishStandard.class) }
)
@Data
@SuperBuilder
@AllArgsConstructor
public abstract class OtherPrintSource extends Reference {

    private String title;
    private String publicationPlace;
    private String publisher;

    public OtherPrintSource() {

    }

}
